package com.xzg.wlxx.system.controller

import com.xzg.wlxx.common.base.BaseController
import com.xzg.wlxx.system.entity.po.Org
import com.xzg.wlxx.system.service.OrgService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "org")
@RequestMapping("org")
class OrgController(var orgService: OrgService) : BaseController() {


    @Operation(summary = "save")
    @PostMapping("save")
    fun test(@RequestBody org: Org) = success(orgService.insertOrUpdate(org));

}