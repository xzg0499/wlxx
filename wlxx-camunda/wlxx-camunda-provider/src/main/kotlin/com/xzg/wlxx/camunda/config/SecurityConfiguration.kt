package com.xzg.wlxx.camunda.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@Configuration
@EnableWebSecurity
class SecurityConfiguration {

//    @Bean
//    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
//        http.authorizeHttpRequests {
//            it.requestMatchers("/**")
//                .permitAll()
//        }
//        return http.build();
//    }

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer() { web: WebSecurity? ->
            val ant = arrayOf(AntPathRequestMatcher.antMatcher("/**"))
            web?.ignoring()?.requestMatchers(*ant)
        }
    }

//    @Bean
//    fun authenticationManager(): AuthenticationManager {
//        val daoAuthenticationProvider = DaoAuthenticationProvider()
////        daoAuthenticationProvider.setUserDetailsService(userService);
//        val pm = ProviderManager(daoAuthenticationProvider);
//        return pm;
//    }

}