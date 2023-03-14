package com.xzg.wlxx.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * 全局security配置
 *
 * @author xzgan
 * @date 2022/7/3
 * @since jdk1.8
 */


@Configuration
@EnableWebSecurity // 开启WebSecurity支持
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

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

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 禁用session
//                .and().authorizeRequests() // 所有请求都要验证
//                .antMatchers("/api/*/auth/**", "/test/**").permitAll() // 登录注册等请求过滤 // 傻瓜式乱测
//                .antMatchers("/doc.html", "/doc.html/**", "/webjars/**", "/v2/**", "/swagger-resources",
//                        "/swagger-resources/**", "/swagger-ui.html", "/swagger-ui.html/**")
//                .permitAll()
//
//                // 开发配置
//                .antMatchers("**").permitAll()
//                // API手册
//                // 请求过滤
//                .anyRequest().fullyAuthenticated().and().exceptionHandling()
//        ;
//
//        // 添加JWT filter
////        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//
//        // super.configure(http);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//    }

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

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // WebSecurityCustomizer是一个类似于Consumer<WebSecurity>的接口，函数接受一个WebSecurity类型的变量，无返回值
        // 此处使用lambda实现WebSecurityCustomizer接口，web变量的类型WebSecurity，箭头后面可以对其进行操作
        // 使用requestMatchers()代替antMatchers()
        return (web) -> web.ignoring()
                .requestMatchers("/doc.html", "/doc.html/**", "/webjars/**", "/v2/**"
                        , "/swagger-resources"
                        , "/v2/api-docs"
                        , "/v3/api-docs"
                        , "/api-docs"
                        , "/v2/api-docs-ext"
                        , "/swagger-resources/**", "/swagger-ui.html", "/swagger-ui.html/**"
                        , "/api/*/auth/**", "/test/**"
                        , "**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //使用authorizeHttpRequests()代替authorizeRequests()
                .authorizeHttpRequests((authz) -> authz
                        //这种写法被称为Lambda DSL，代替原来的and()链式操作
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        // 需要进行build()，返回SecurityFilterChain
        return http.build();
    }
}
