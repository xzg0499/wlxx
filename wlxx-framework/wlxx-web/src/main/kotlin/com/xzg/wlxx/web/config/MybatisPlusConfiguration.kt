package com.xzg.wlxx.web.config

import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import com.xzg.wlxx.web.config.mybatisplus.component.WlxxMetaObjectHandler
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy

@Lazy
@Configuration
@MapperScan("com.xzg.wlxx.**.mapper")
class MybatisPlusConfiguration {
    @Bean
    fun mybatisPlusInterceptor(): MybatisPlusInterceptor {
        val interceptor = MybatisPlusInterceptor()
        interceptor.addInnerInterceptor(PaginationInnerInterceptor(DbType.MYSQL))
        return interceptor
    }

    @Bean
    fun wlxxMetaObjectHandler(): WlxxMetaObjectHandler {
        return WlxxMetaObjectHandler()
    }
}
