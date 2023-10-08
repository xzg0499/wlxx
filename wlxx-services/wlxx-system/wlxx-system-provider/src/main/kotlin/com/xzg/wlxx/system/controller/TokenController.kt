package com.xzg.wlxx.system.controller

import com.xzg.wlxx.common.base.ApiResult
import com.xzg.wlxx.common.base.ApiResult.Companion.success
import com.xzg.wlxx.system.client.entity.po.TokenPo
import com.xzg.wlxx.system.service.TokenService
import io.swagger.v3.oas.annotations.tags.Tag
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "token")
@RequestMapping("token")
@RequiredArgsConstructor
class TokenController {
    private val service: TokenService? = null

    @PostMapping("findToken")
    fun findToken(@RequestBody tokenPo: TokenPo): ApiResult<TokenPo?> {
        return success(service!!.lambdaQuery(tokenPo).one())
    }

    @PostMapping("saveOrUpdate")
    fun saveOrUpdate(@RequestBody po: TokenPo): ApiResult<Boolean> {
        return success(service!!.save(po))
    }
}
