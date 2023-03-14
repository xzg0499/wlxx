package com.xzg.wlxx.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzg.wlxx.core.base.BaseRes;
import com.xzg.wlxx.core.base.response.RestResult;
import com.xzg.wlxx.system.client.entity.param.DictParam;
import com.xzg.wlxx.system.client.entity.po.DictPo;
import com.xzg.wlxx.system.service.IDictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "数据字典管理")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictController {

    private final IDictService service;


    @Operation(summary = "新增")
    @PostMapping("add")
    public RestResult add(@RequestBody DictPo po) {
        if (service.add(po)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @Operation(summary = "编辑")
    @PutMapping("edit")
    public RestResult edit(@RequestBody DictPo po) {
        if (service.edit(po)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @Operation(summary = "分页查询")
    @PostMapping("search")
    public RestResult<IPage<DictPo>> search(@RequestBody DictParam param) {
        return BaseRes.success(service.search(param));
    }

    @Operation(summary = "启用")
    @PutMapping("enabled/{id}")
    public RestResult enabled(@PathVariable Long id) {
        if (service.enabled(id, true)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @Operation(summary = "禁用")
    @PutMapping("disabled/{id}")
    public RestResult disabled(@PathVariable Long id) {
        if (service.enabled(id, false)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @Operation(summary = "删除")
    @Parameters({
            @Parameter(name = "id", description = "主键", required = true, in = ParameterIn.PATH)
    })
    @DeleteMapping("del/{id}")
    public RestResult del(@PathVariable Long id) {
        if (service.removeById(id)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }
}
