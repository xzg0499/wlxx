package com.xzg.wlxx.system.controller;


import com.xzg.wlxx.core.base.BaseRes;
import com.xzg.wlxx.core.base.response.RestResult;
import com.xzg.wlxx.system.client.entity.po.OrganizationPo;
import com.xzg.wlxx.system.client.entity.vo.OrganizationVo;
import com.xzg.wlxx.system.service.IOrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 组织 前端控制器
 * </p>
 *
 * @author xzgang0499
 * @since 2022-11-11
 */
@RestController
@Tag(name = "组织结构管理")
@RequestMapping("org")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrganizationController {

    private final IOrganizationService service;

    @Operation(summary = "新增")
    @PostMapping("add")
    public RestResult add(@RequestBody @Validated OrganizationPo po) {
        if (service.add(po)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @Operation(summary = "修改")
    @PostMapping("edit")
    public RestResult edit(@RequestBody OrganizationPo po) {
        if (service.edit(po)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    /**
     * FIXME restful接口不能传空
     */
    @Operation(summary = "获取组织结构")
    @GetMapping("get-all")
    public RestResult<List<OrganizationVo>> getAll() {
        return BaseRes.success(service.get(null));
    }

    @Operation(summary = "获取组织结构")
    @GetMapping("get/{id}")
    public RestResult<List<OrganizationVo>> get(@PathVariable(value = "id", required = false) Long id) {
        return BaseRes.success(service.get(id));
    }
}
