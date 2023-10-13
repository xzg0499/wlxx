package com.xzg.wlxx.auth.config.security.auth;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.xzg.wlxx.auth.config.security.config.JwtTokenUtils;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.system.client.entity.dto.UserDto;
import com.xzg.wlxx.system.client.entity.po.TokenPo;
import com.xzg.wlxx.system.client.feign.TokenProvider;
import com.xzg.wlxx.system.client.feign.UserProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {
    private final TokenProvider tokenService;
    private final UserProvider userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtils jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public ApiResult<?> register(AuthenticationDto request) {
        Assert.notBlank(request.getUsername(), "参数不能为空！");
        Assert.notBlank(request.getPassword(), "参数不能为空");

        var user = new UserDto();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return ApiResult.success(userService.register(user));
    }

    public ApiResult<?> authenticate(AuthenticationDto dto) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());

        if (userDetails == null || !passwordEncoder.matches(dto.getPassword(), userDetails.getPassword())) {
            return ApiResult.failure("用户名或密码不正确！");
        }

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );
        // TODO 考虑不从数据库中查数据

        userDetails = (SystemUserDetails) authenticate.getPrincipal();
        var user = userService.findByUsername(userDetails.getUsername());
        // var user = userService.findByEmail(request.getEmail());
        // var user = userDetailsService.loadUserByUsername(request.getEmail());


        var jwtToken = jwtService.generateToken(userDetails);
        var refreshToken = jwtService.generateRefreshToken(userDetails);
        revokeUserToken(user.getId());
        saveUserToken(user.getId(), jwtToken);
        AuthenticationVo authenticationVo = AuthenticationVo.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
        return ApiResult.success(authenticationVo);

    }

    public ApiResult<?> refreshToken(HttpServletRequest request,
                                     HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String username;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ApiResult.failure("你的操作非法！");
        }
        refreshToken = authHeader.substring(7);
        username = jwtService.extractUsername(refreshToken);
        if (username != null) {
            // log.info("username: {}",username);
            // TODO 考虑不从数据库获取用户数据
            // var user = userService.findByEmail(username);
            var userDetails = (SystemUserDetails) userDetailsService.loadUserByUsername(username);
            var user = userService.findByUsername(userDetails.getUsername());
            if (jwtService.isTokenValid(refreshToken, userDetails)) {
                var accessToken = jwtService.generateToken(userDetails);
                log.info("accessToken: {}", accessToken);
                revokeUserToken(user.getId());
                saveUserToken(user.getId(), accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                // new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
                return ApiResult.success(authResponse);
            }
            return ApiResult.failure("令牌无效！");
        }
        return ApiResult.failure("获取用户名失败！");
    }


    /**
     * 保存用户的 token
     *
     * @param userId
     * @param jwtToken
     */
    private void saveUserToken(Long userId, String jwtToken) {
        var token = TokenPo.builder()
                .token(jwtToken)
                .expired(false)
                .revoked(false)
                .userId(userId)
                .build();
        token.setId(userId);
        tokenService.saveOrUpdate(token);
    }


    /**
     * 销毁用户的 token
     * - expired = true
     * - revoked = true
     *
     * @param userId
     */
    private void revokeUserToken(Long userId) {
        var validUserToken = tokenService.findToken(TokenPo.builder()
                .userId(userId)
                .expired(true)
                .revoked(true)
                .build()
        );
        if (BeanUtil.isEmpty(validUserToken))
            return;
        validUserToken.setExpired(true);
        tokenService.saveOrUpdate(validUserToken);
    }
}
