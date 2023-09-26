package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.apt.AutoFeign;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.base.BaseController;
import com.xzg.wlxx.system.client.entity.po.OrgPo;
import com.xzg.wlxx.system.service.OrgService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "org")
@RequestMapping("org")
@RequiredArgsConstructor
public class OrgController extends BaseController {

    private final OrgService service;

    @PostMapping("add")
    @AutoFeign(name = "Demo")
    public ApiResult<Boolean> add(@RequestBody OrgPo org) {
        return success(service.add(org));
    }


}
