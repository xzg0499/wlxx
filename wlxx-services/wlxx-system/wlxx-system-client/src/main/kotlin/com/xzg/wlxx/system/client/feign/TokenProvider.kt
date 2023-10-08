package com.xzg.wlxx.system.client.feign

import com.xzg.wlxx.system.client.entity.po.TokenPo
import com.xzg.wlxx.system.client.feign.failback.TokenFallback
import com.xzg.wlxx.web.config.FeignConfiguration
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Component
@FeignClient(
    name = "wlxx-system",
    contextId = "tokenProvider",
    fallback = TokenFallback::class,
    configuration = [FeignConfiguration::class]
)
interface TokenProvider {
    @PostMapping("/token/findToken")
    fun findToken(@RequestBody tokenPo: TokenPo?): TokenPo?

    @PostMapping("/token/saveOrUpdate")
    fun saveOrUpdate(@RequestBody po: TokenPo?): Boolean
}
