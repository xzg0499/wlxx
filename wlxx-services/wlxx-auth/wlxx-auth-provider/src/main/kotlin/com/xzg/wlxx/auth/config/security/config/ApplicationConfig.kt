package com.xzg.wlxx.auth.config.security.config

import com.xzg.wlxx.auth.config.security.auth.SystemUserDetails
import com.xzg.wlxx.system.client.feign.UserProvider
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Slf4j
@Configuration
@RequiredArgsConstructor
class ApplicationConfig {
    private val userService: UserProvider? = null

    @Bean
    fun userDetailsService(): UserDetailsService {
        // return username -> userService.findByEmail(username);
        return UserDetailsService { username: String? ->
            val userPo = userService!!.findByUsername(username)
            SystemUserDetails(userPo?.username, userPo?.password)
        }
    }

    @Bean
    fun authenticationProvider(): AuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService())
        authProvider.setPasswordEncoder(passwordEncoder())
        return authProvider
    }

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager {
        return config.getAuthenticationManager()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
