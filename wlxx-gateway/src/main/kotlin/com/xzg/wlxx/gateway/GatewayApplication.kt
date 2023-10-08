package com.xzg.wlxx.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@EnableDiscoveryClient
object GatewayApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(GatewayApplication::class.java, *args)
    }
}
