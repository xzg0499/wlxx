package com.xzg.wlxx.camunda.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer


@Configuration
class SecurityConfiguration : WebSecurityCustomizer {
    override fun customize(web: WebSecurity?) {
        // 关闭security认证
        web?.ignoring()?.antMatchers("**")
    }
}