package com.xzg.wlxx.system.controller

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.xzg.wlxx.common.base.ApiResult
import com.xzg.wlxx.common.base.BaseController
import com.xzg.wlxx.system.entity.po.Emp
import com.xzg.wlxx.system.service.EmpService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "emp")
@RequestMapping("emp")
class EmpController(var service: EmpService) : BaseController() {

    @Operation(summary = "save")
    @PostMapping("save")
    fun save(@RequestBody emp: Emp): ApiResult<Boolean> {
        return success(service.insertOrUpdate(emp))
    }

    @Operation(summary = "page")
    @PostMapping("page/{page}/{size}")
    fun page(@RequestBody emp: Emp, @PathVariable page: Long, @PathVariable size: Long): ApiResult<Page<Emp>> {
        return success(service.page(Page(page, size)))
    }
}