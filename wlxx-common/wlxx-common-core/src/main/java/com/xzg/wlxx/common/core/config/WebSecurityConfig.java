package com.xzg.wlxx.common.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @author xzgan
 * @date 2022/7/3
 * @since jdk1.8
 */


@Configuration
@EnableWebSecurity // 开启WebSecurity支持
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] URL_WHITE_LIST = new String[]{
            "/api/*/auth/**",
            "/test/**",
            "/doc.html",
            "/doc.html/**",
            "/webjars/**",
            "/v2/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/swagger-ui.html/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 禁用session
                .and().authorizeRequests() // 所有请求都要验证
                .antMatchers("/api/*/auth/**", "/test/**").permitAll() // 登录注册等请求过滤 // 傻瓜式乱测
                .antMatchers("/doc.html", "/doc.html/**", "/webjars/**", "/v2/**", "/swagger-resources",
                        "/swagger-resources/**", "/swagger-ui.html", "/swagger-ui.html/**")
                .permitAll()

                // 开发配置
                .antMatchers("**").permitAll()
                // API手册
                // 请求过滤
                .anyRequest().fullyAuthenticated().and().exceptionHandling()
        ;

        // 添加JWT filter
//        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        // super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    //    @Configuration
//    @EnableWebSecurity // 开启WebSecurity支持
//    @EnableGlobalMethodSecurity(prePostEnabled = true) // 开启prePostEnabled注解支持
//    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.csrf().disable() // 禁用csrf保护
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 禁用session
//                    .and().authorizeRequests() // 所有请求都要验证
//                    .antMatchers("/api/*/auth/**", "/test/**").permitAll() // 登录注册等请求过滤 // 傻瓜式乱测
//
//                    .antMatchers("/doc.html", "/doc.html/**", "/webjars/**", "/v2/**", "/swagger-resources",
//                            "/swagger-resources/**", "/swagger-ui.html", "/swagger-ui.html/**")
//                    .permitAll()
//                    // API手册
//                    // 请求过滤
//                    .anyRequest().fullyAuthenticated().and().exceptionHandling()
//                    .authenticationEntryPoint(new RestAuthenticationEntryPoint());
//            // 添加JWT filter
//            http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//
//        }
//    }
}
