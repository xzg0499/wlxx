package com.xzg.wlxx.auth.config

import com.xzg.wlxx.auth.config.security.config.JwtAuthenticationFilter
import com.xzg.wlxx.auth.config.security.config.RestAuthorizationEntryPoint
import com.xzg.wlxx.auth.config.security.config.RestfulAccessDeniedHandler
import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.authentication.logout.LogoutHandler

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
class SecurityConfiguration {
    private val jwtAuthFilter: JwtAuthenticationFilter? = null
    private val authenticationProvider: AuthenticationProvider? = null
    private val logoutHandler: LogoutHandler? = null
    private val restAuthorizationEntryPoint: RestAuthorizationEntryPoint? = null
    private val restfulAccessDeniedHandler: RestfulAccessDeniedHandler? = null

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { obj: CsrfConfigurer<HttpSecurity> -> obj.disable() }
            .authorizeHttpRequests(Customizer { auth ->
                auth.requestMatchers(*WHITE_LIST).permitAll()
                    .requestMatchers("/org/**").authenticated()
                    .requestMatchers("/user/**").authenticated()
            })
            .sessionManagement { manager ->
                manager.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            }
            .authenticationProvider(authenticationProvider) //添加jwt 登录授权过滤器
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter::class.java)
            .logout { handler: LogoutConfigurer<HttpSecurity?> ->
                handler.logoutUrl("/auth/logout")
                    .addLogoutHandler(logoutHandler)
                    .logoutSuccessHandler { _, _, _: Authentication? -> SecurityContextHolder.clearContext() }
            }
        //添加自定义未授权和未登录结果返回
        http.exceptionHandling { handler: ExceptionHandlingConfigurer<HttpSecurity?> ->
            handler
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthorizationEntryPoint)
        }
        return http.build()
    }

    companion object {
        private val WHITE_LIST = arrayOf(
            "/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/doc.html",
            "/webjars/**",
            "/swagger-ui.html",
            "/favicon.ico"
        )
    }
}
