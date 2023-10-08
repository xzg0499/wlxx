package com.xzg.wlxx.system.client.feign

import com.xzg.wlxx.system.client.entity.dto.RegisterUserDto
import com.xzg.wlxx.system.client.entity.po.UserPo
import com.xzg.wlxx.system.client.feign.failback.UserFallback
import com.xzg.wlxx.web.config.FeignConfiguration
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Component
@FeignClient(
    name = "wlxx-system",
    contextId = "userProvider",
    fallback = UserFallback::class,
    configuration = [FeignConfiguration::class]
)
interface UserProvider {
    @PostMapping("/user/findByUsername/{username}")
    fun findByUsername(@PathVariable(value = "username") username: String?): UserPo?

    @PostMapping("/user/register")
    fun register(@RequestBody dto: RegisterUserDto?): Boolean
}
