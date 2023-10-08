package com.xzg.wlxx.system.controller

import cn.zhxu.bs.BeanSearcher
import cn.zhxu.bs.MapSearcher
import cn.zhxu.bs.SearchResult
import cn.zhxu.bs.util.MapUtils
import com.xzg.wlxx.common.base.ApiResult
import com.xzg.wlxx.common.base.ApiResult.Companion.success
import com.xzg.wlxx.common.base.BaseController
import com.xzg.wlxx.system.client.entity.dto.RegisterUserDto
import com.xzg.wlxx.system.client.entity.po.UserPo
import com.xzg.wlxx.system.service.UserService
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.constraints.NotBlank
import lombok.RequiredArgsConstructor
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "user")
@RequestMapping("user")
@RequiredArgsConstructor
class UserController : BaseController() {
    private val service: UserService? = null
    @PostMapping("findByUsername/{username}")
    fun findByUsername(@PathVariable username: @NotBlank(message = "用户名不能为空") String?): ApiResult<UserPo?> {
        return success(service!!.findByUsername(username))
    }

    @PostMapping("register")
    fun register(@RequestBody @Validated dto: RegisterUserDto): ApiResult<Boolean> {
        return success(service!!.register(dto))
    }

    private val beanSearcher: BeanSearcher? = null
    private val mapSearcher: MapSearcher? = null
    @GetMapping("/mapSearcher")
    fun mapSearcher(request: HttpServletRequest): SearchResult<Map<String, Any>> {
        // 一行代码，实现一个用户检索接口（MapUtils.flat 只是收集前端的请求参数）
        return mapSearcher!!.search(UserPo::class.java, MapUtils.flat(request.parameterMap))
    }

    @GetMapping("/beanSearcher")
    fun beanSearcher(request: HttpServletRequest): SearchResult<UserPo> {
        // 一行代码，实现一个用户检索接口（MapUtils.flat 只是收集前端的请求参数）
        return beanSearcher!!.search(UserPo::class.java, MapUtils.flat(request.parameterMap))
    }
}
