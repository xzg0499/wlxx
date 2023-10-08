package com.xzg.wlxx.auth.config.security.auth

import cn.hutool.core.bean.BeanUtil
import cn.hutool.core.lang.Assert
import com.xzg.wlxx.auth.config.security.config.JwtTokenUtils
import com.xzg.wlxx.common.base.ApiResult
import com.xzg.wlxx.common.base.ApiResult.Companion.failure
import com.xzg.wlxx.common.base.ApiResult.Companion.success
import com.xzg.wlxx.common.log.WlxxLog.Companion.log
import com.xzg.wlxx.system.client.entity.dto.RegisterUserDto
import com.xzg.wlxx.system.client.entity.po.TokenPo
import com.xzg.wlxx.system.client.feign.TokenProvider
import com.xzg.wlxx.system.client.feign.UserProvider
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.io.IOException

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
class AuthenticationService {
    private val tokenService: TokenProvider? = null
    private val userService: UserProvider? = null
    private val passwordEncoder: PasswordEncoder? = null
    private val jwtService: JwtTokenUtils? = null
    private val authenticationManager: AuthenticationManager? = null
    private val userDetailsService: UserDetailsService? = null
    fun register(request: AuthenticationDto): ApiResult<*> {
        Assert.notBlank(request.username, "参数不能为空！")
        Assert.notBlank(request.password, "参数不能为空")
        val user = RegisterUserDto(username = request.username, password = passwordEncoder!!.encode(request.password))

        return success<Any>(userService!!.register(user))
    }

    fun authenticate(dto: AuthenticationDto): ApiResult<*> {
        var userDetails = userDetailsService!!.loadUserByUsername(dto.username)
        if (userDetails == null || !passwordEncoder!!.matches(dto.password, userDetails.password)) {
            return failure<Any>("用户名或密码不正确！")
        }
        val authenticate = authenticationManager!!.authenticate(
            UsernamePasswordAuthenticationToken(dto.username, dto.password)
        )
        // TODO 考虑不从数据库中查数据
        userDetails = authenticate.principal as SystemUserDetails
        val user = userService!!.findByUsername(userDetails.getUsername())
        // var user = userService.findByEmail(request.getEmail());
        // var user = userDetailsService.loadUserByUsername(request.getEmail());
        val jwtToken = jwtService!!.generateToken(userDetails)
        val refreshToken = jwtService.generateRefreshToken(userDetails)
        user?.id?.let { revokeUserToken(it) }
        user?.id?.let { saveUserToken(it, jwtToken) }
        val authenticationVo = AuthenticationVo(accessToken = jwtToken, refreshToken = refreshToken)

        return success<Any>(authenticationVo)
    }

    @Throws(IOException::class)
    fun refreshToken(
        request: HttpServletRequest,
        response: HttpServletResponse?
    ): ApiResult<*> {
        val authHeader = request.getHeader(HttpHeaders.AUTHORIZATION)
        val refreshToken: String
        val username: String?
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return failure<Any>("你的操作非法！")
        }
        refreshToken = authHeader.substring(7)
        username = jwtService!!.extractUsername(refreshToken)
        if (username != null) {
            // log.info("username: {}",username);
            // TODO 考虑不从数据库获取用户数据
            // var user = userService.findByEmail(username);
            val userDetails = userDetailsService!!.loadUserByUsername(username) as SystemUserDetails
            val user = userService!!.findByUsername(userDetails.username)
            if (jwtService.isTokenValid(refreshToken, userDetails)) {
                val accessToken = jwtService.generateToken(userDetails)
                log.info("accessToken: {}", accessToken)
                user?.id?.let { revokeUserToken(it) }
                user?.id?.let { saveUserToken(it, accessToken) }
                val authResponse = AuthenticationResponse(accessToken = accessToken, refreshToken = refreshToken)

                // new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
                return success<Any>(authResponse)
            }
            return failure<Any>("令牌无效！")
        }
        return failure<Any>("获取用户名失败！")
    }

    /**
     * 保存用户的 token
     *
     * @param userId
     * @param jwtToken
     */
    private fun saveUserToken(userId: Long, jwtToken: String?) {
        val token = TokenPo(jwtToken, false, false, userId)
        token.id = userId
        tokenService!!.saveOrUpdate(token)
    }

    /**
     * 销毁用户的 token
     * - expired = true
     * - revoked = true
     *
     * @param userId
     */
    private fun revokeUserToken(userId: Long) {
        val validUserToken = tokenService!!.findToken(
            TokenPo(userId = userId, expired = true, revoked = true)
        )
        if (BeanUtil.isEmpty(validUserToken)) return
        validUserToken?.expired = true
        tokenService.saveOrUpdate(validUserToken)
    }
}
