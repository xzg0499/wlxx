package com.xzg.wlxx.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzg.wlxx.common.core.pojo.entity.BaseController;
import com.xzg.wlxx.common.core.response.ResponseData;
import com.xzg.wlxx.system.api.entity.TDict;
import com.xzg.wlxx.system.service.ITDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xzgang0499
 * @date 2022-01-16
 * @since jdk1.8
 */

@Api(tags = "业务字典")
@RestController
@RequestMapping("/dict")
public class TDictController extends BaseController {

    @Autowired
    ITDictService dictService;

    @ApiOperation("新增")
    @PostMapping("/add")
    public ResponseData<Boolean> add(@RequestBody TDict dict) throws Exception{
        return success(dictService.save(dict));
    }

    @ApiOperation("分页查询")
    @PostMapping("/queryByPage")
    public ResponseData<IPage<TDict>> queryByPage(@RequestBody TDict dict) throws Exception{
        return success(dictService.page(new Page<>(dict.getPageNo(),dict.getPageSize()),new LambdaQueryWrapper<>()));
    }

    @ApiOperation("根据ID查询字典")
    @GetMapping("/getById/{id}")
    public ResponseData<TDict> getById(@PathVariable("id") String id) throws Exception{
        return success(dictService.getById(id));
    }
}
