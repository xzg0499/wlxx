package com.xzg.wlxx.camunda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> {
            AntPathRequestMatcher[] antPathRequestMatcher = {
                    AntPathRequestMatcher.antMatcher("/**")
            };
            web.ignoring().requestMatchers(antPathRequestMatcher);
        };
    }
}
