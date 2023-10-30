package com.xzg.wlxx.auth.config;

import com.xzg.wlxx.auth.config.security.config.RestAuthorizationEntryPoint;
import com.xzg.wlxx.auth.config.security.filter.JwtAuthenticationFilter;
import com.xzg.wlxx.auth.config.security.handler.RestfulAccessDeniedHandler;
import com.xzg.wlxx.web.config.WlxxInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;
    private final RestAuthorizationEntryPoint restAuthorizationEntryPoint;
    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(WlxxInterceptor.WHITE_LIST).permitAll()
                            .requestMatchers("/org/**").authenticated()
                            .requestMatchers("/user/**").authenticated();
                })
                .sessionManagement(manager -> {
                    manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .authenticationProvider(authenticationProvider)
                //添加jwt 登录授权过滤器
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(handler -> {
                    handler.logoutUrl("/auth/logout")
                            .addLogoutHandler(logoutHandler)
                            .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
                });
        //添加自定义未授权和未登录结果返回
        http.exceptionHandling(handler -> {
            handler
                    .accessDeniedHandler(restfulAccessDeniedHandler)
                    .authenticationEntryPoint(restAuthorizationEntryPoint);
        });

        return http.build();
    }
}
