package com.xzg.wlxx.system.controller;


import com.xzg.wlxx.core.base.BaseRes;
import com.xzg.wlxx.core.base.controller.BaseController;
import com.xzg.wlxx.core.base.response.Result;
import com.xzg.wlxx.system.client.entity.po.OrganizationPo;
import com.xzg.wlxx.system.service.IOrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 组织 前端控制器
 * </p>
 *
 * @author xzgang0499
 * @since 2022-11-11
 */
@RestController
@Api(tags = "组织结构", value = "组织结构")
@RequestMapping("org")
@Slf4j
public class OrganizationController extends BaseController<IOrganizationService, OrganizationPo> {

    @ApiOperation("新增")
    @PostMapping("add")
    public Result add(@RequestBody @Validated OrganizationPo entity) {
        return BaseRes.success();
    }
}
