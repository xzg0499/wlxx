package com.xzg.wlxx.system.client.feign.failback

import com.xzg.wlxx.system.client.entity.dto.RegisterUserDto
import com.xzg.wlxx.system.client.entity.po.UserPo
import com.xzg.wlxx.system.client.feign.UserProvider

class UserFallback : UserProvider {
    override fun findByUsername(username: String?): UserPo? {
        return null
    }

    override fun register(dto: RegisterUserDto?): Boolean {
        return false
    }
}
