package com.xzg.wlxx.system.config

import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@MapperScan("com.xzg.wlxx.**.mapper")
class MybatisPlusConfiguration {

    @Bean
    fun mybatisPlusInterceptor(): MybatisPlusInterceptor {
        var interceptor = MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(PaginationInnerInterceptor(DbType.MYSQL));//如果配置多个插件,切记分页最后添加
        return interceptor;
    }


}