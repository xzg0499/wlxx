package com.xzg.wlxx.system.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.xzg.wlxx.system.client.entity.dto.RegisterUserDto
import com.xzg.wlxx.system.client.entity.po.UserPo
import com.xzg.wlxx.system.client.exception.BusinessException
import com.xzg.wlxx.system.mapper.UserMapper
import com.xzg.wlxx.system.service.UserService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

/**
 * @author XiaoZG
 */
@Service
@RequiredArgsConstructor
class UserServiceImpl : ServiceImpl<UserMapper?, UserPo?>(), UserService {
    override fun findByUsername(username: String?): UserPo? {
        return ktQuery().eq(UserPo::username, username).oneOpt().orElse(UserPo())
    }

    override fun register(dto: RegisterUserDto): Boolean {
        val exists = ktQuery().eq(UserPo::username, dto.username)
            .exists()
        if (exists) {
            throw BusinessException("用户已存在")
        }
        val user = UserPo(username = dto.username, password = dto.password)
        return save(user)
    }
}
