package com.xzg.wlxx.system.service

import com.baomidou.mybatisplus.extension.service.IService
import com.xzg.wlxx.system.client.entity.dto.RegisterUserDto
import com.xzg.wlxx.system.client.entity.po.UserPo

/**
 * @author XiaoZG
 */
interface UserService : IService<UserPo?> {
    fun findByUsername(username: String?): UserPo?
    fun register(dto: RegisterUserDto): Boolean
}
