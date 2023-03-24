package com.xzg.wlxx.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzg.wlxx.core.base.ApiResult;
import com.xzg.wlxx.core.base.response.RestApiResult;
import com.xzg.wlxx.system.client.entity.param.DictParam;
import com.xzg.wlxx.system.client.entity.param.EnabledParam;
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
@Tag(name = "数据字典管理", description = "数据字典管理")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictController {

    private final IDictService service;


    @Operation(summary = "新增")
    @PostMapping("add")
    public RestApiResult add(@RequestBody DictPo po) {
        return ApiResult.msg(service.add(po));
    }

    @Operation(summary = "编辑")
    @PutMapping("edit")
    public RestApiResult edit(@RequestBody DictPo po) {
        return ApiResult.msg(service.edit(po));
    }

    @Operation(summary = "分页查询")
    @PostMapping("search")
    public RestApiResult<IPage<DictPo>> search(@RequestBody DictParam param) {
        return ApiResult.success(service.search(param));
    }

    @Operation(summary = "启用/禁用")
    @PutMapping("enabled")
    public RestApiResult enabled(@RequestBody EnabledParam param) {
        return ApiResult.msg(service.enabled(param.getId(), param.getEnabled()));
    }

    @Operation(summary = "删除")
    @Parameters({
            @Parameter(name = "id", description = "主键", required = true, in = ParameterIn.PATH)
    })
    @DeleteMapping("del/{id}")
    public RestApiResult del(@PathVariable Long id) {
        if (service.removeById(id)) {
            return ApiResult.success();
        }
        return ApiResult.failure();
    }
}
