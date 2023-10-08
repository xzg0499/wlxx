package com.xzg.wlxx.auth.config.security.config

import cn.hutool.core.bean.BeanUtil
import com.xzg.wlxx.system.client.entity.po.TokenPo
import com.xzg.wlxx.system.client.feign.TokenProvider
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.lang.NonNull
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Slf4j
@Component
@RequiredArgsConstructor
class JwtAuthenticationFilter : OncePerRequestFilter() {
    private val jwtService: JwtTokenUtils? = null
    private val userDetailsService: UserDetailsService? = null
    private val tokenService: TokenProvider? = null

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        @NonNull request: HttpServletRequest,
        @NonNull response: HttpServletResponse,
        @NonNull filterChain: FilterChain
    ) {
        if (request.servletPath.contains("/auth")) {
            filterChain.doFilter(request, response)
            return
        }
        val authHeader = request.getHeader("Authorization")
        val jwt: String
        val userEmail: String?
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }
        jwt = authHeader.substring(7)
        // log.info("当前请求用户的token：{}",jwt);
        userEmail = jwtService!!.extractUsername(jwt)
        // log.info("当前请求用户的邮箱：{}",userEmail);
        if (userEmail != null && SecurityContextHolder.getContext().authentication == null) {
            val userDetails = userDetailsService!!.loadUserByUsername(userEmail)
            val isTokenValid = tokenService!!.findToken(
                TokenPo(token = jwt)
            )
            if (jwtService.isTokenValid(jwt, userDetails) && BeanUtil.isNotEmpty(isTokenValid)) {
                val authToken = UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.authorities
                )
                authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authToken
            }
        }
        filterChain.doFilter(request, response)
    }
}
