package com.xzg.wlxx.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzg.wlxx.core.base.BaseRes;
import com.xzg.wlxx.core.base.controller.BaseController;
import com.xzg.wlxx.core.base.response.RestResult;
import com.xzg.wlxx.system.client.entity.param.DictParam;
import com.xzg.wlxx.system.client.entity.po.DictPo;
import com.xzg.wlxx.system.service.IDictService;
import com.xzg.wlxx.web.apo.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
@RestController
@RequestMapping("/dict")
@Api(tags = "数据字典管理", value = "数据字典管理")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictController extends BaseController {

    private final IDictService service;


    @ApiOperation("新增")
    @PostMapping("add")
    @Log
    public RestResult add(@RequestBody DictPo po) {
        if (service.add(po)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @ApiOperation("编辑")
    @PutMapping("edit")
    @Log
    public RestResult edit(@RequestBody DictPo po) {
        if (service.edit(po)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @ApiOperation("分页查询")
    @PostMapping("search")
    @Log
    public RestResult<IPage<DictPo>> search(@RequestBody DictParam param) {
        return BaseRes.success(service.search(param));
    }

    @ApiOperation("启用")
    @PutMapping("enabled/{id}")
    public RestResult enabled(@PathVariable Long id) {
        if (service.enabled(id, true)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @ApiOperation("禁用")
    @PutMapping("disabled/{id}")
    public RestResult disabled(@PathVariable Long id) {
        if (service.enabled(id, false)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @ApiOperation("删除")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "主键", dataTypeClass = Long.class)
    )
    @DeleteMapping("del/{id}")
    public RestResult del(@PathVariable Long id) {
        if (service.removeById(id)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }
}
