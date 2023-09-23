package com.xzg.wlxx.system.config.security.auth;

import cn.hutool.core.lang.Assert;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.system.client.entity.dto.UserDto;
import com.xzg.wlxx.system.client.entity.po.User;
import com.xzg.wlxx.system.client.exception.BusinessException;
import com.xzg.wlxx.system.config.security.config.JwtTokenUtils;
import com.xzg.wlxx.system.service.UserService;
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
import java.util.function.Supplier;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtils jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public ApiResult register(UserDto request) {
        Supplier supplier = () -> {
            throw new BusinessException("参数不能为空！");
        };
        Assert.notBlank(request.getUsername(), supplier);
        Assert.notBlank(request.getPassword(), supplier);

        var oldUser = userService.lambdaQuery()
                .eq(User::getUsername, request.getUsername())
                .exists();
        // DONE 判断用户是否存在
        if (!oldUser) {
            var user = User.builder()
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build();
            // mybatis-plus 保存用户信息后自动返回递增的主键id
            userService.save(user);
            return ApiResult.message("注册成功！");
        }
        // 用户存在，提示用户登录
        return ApiResult.failure("用户已存在！");
    }

    public ApiResult authenticate(UserDto dto) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());

        if (userDetails == null || !passwordEncoder.matches(dto.getPassword(), userDetails.getPassword())) {
            return ApiResult.failure("用户名或密码不正确！");
        }

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );
        // TODO 考虑不从数据库中查数据

        var user = (SystemUserDetails) authenticate.getPrincipal();
        // var user = userService.findByEmail(request.getEmail());
        // var user = userDetailsService.loadUserByUsername(request.getEmail());


        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeUserToken(user.getId());
        saveUserToken(user.getId(), jwtToken);
        AuthenticationResponse response = AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
        return ApiResult.success("认证成功！", response);

    }

    public ApiResult refreshToken(HttpServletRequest request,
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
            var user = (SystemUserDetails) userDetailsService.loadUserByUsername(username);
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                log.info("accessToken: {}", accessToken);
                revokeUserToken(user.getId());
                saveUserToken(user.getId(), accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                // new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
                return ApiResult.success("刷新成功！", authResponse);
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
        var token = User.builder()
                .token(jwtToken)
                .expired(false)
                .build();
        token.setId(userId);
        userService.saveOrUpdate(token);
    }


    /**
     * 销毁用户的 token
     * - expired = true
     * - revoked = true
     *
     * @param userId
     */
    private void revokeUserToken(Long userId) {
        var validUserToken = userService.findValidTokenByUserId(userId);
        if (validUserToken.isEmpty())
            return;
        validUserToken.ifPresent(token -> {
            token.setExpired(true);
            userService.updateById(token);
        });

    }
}
