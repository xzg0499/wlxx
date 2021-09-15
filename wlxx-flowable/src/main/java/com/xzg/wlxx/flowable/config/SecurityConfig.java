//package com.xzg.wlxx.flowable.config;
//
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.swagger.web.SecurityConfiguration;
//
///**
// * @Author: 肖志刚
// * @Date: 2021/9/2 23:00
// */
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private  static  final  String[]  AUTH_WHITELIST  =  {
//            // -- swagger ui
//            "/swagger-resources/**",
//            "/swagger-ui.html",
//            "/v2/api-docs",
//            "/webjars/**"
//    };
//    @Override
//    protected  void  configure(HttpSecurity http)  throws  Exception  {
//        http.authorizeRequests()
//                .antMatchers(AUTH_WHITELIST).permitAll()
//                .antMatchers("/**/*").denyAll();
//    }
//}
