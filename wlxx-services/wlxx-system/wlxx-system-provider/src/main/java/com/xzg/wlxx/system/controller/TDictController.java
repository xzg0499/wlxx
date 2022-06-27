package com.xzg.wlxx.system.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzg.wlxx.common.core.base.BaseController;
import com.xzg.wlxx.common.core.response.Res;
import com.xzg.wlxx.system.client.entity.TDict;
import com.xzg.wlxx.system.service.ITDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 业务字典
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
    public Res<Boolean> add(@RequestBody TDict dict) throws Exception{
        if(dictService.add(dict)){
            return success();
        }
        return failure();
    }

    @ApiOperation("分页查询")
    @PostMapping("/queryByPage")
    public Res<IPage<TDict>> queryByPage(@RequestBody TDict dict) throws Exception{
        return success(dictService.query(dict));
    }

    @ApiOperation("根据ID查询字典")
    @GetMapping("/getById/{id}")
    public Res<TDict> getById(@PathVariable("id") String id) throws Exception{
        return success(dictService.getById(id));
    }

    @ApiOperation("根据ID修改字典")
    @PutMapping("/updateById")
    public Res<Boolean> modify(@RequestBody TDict dict) throws Exception{
        if(dictService.modify(dict)){
            return success();
        }
        return failure();
    }

    @ApiOperation("根据code获取字典值")
    @GetMapping("/getByCode/{code}")
    public Res<TDict> getByCode(@PathVariable("code") String code) throws Exception {
        return success(dictService.getByCode(code));
    }

    @ApiOperation("删除业务字典")
    @DeleteMapping("/delById/{id}")
    public Res<Boolean> delById(@PathVariable("id") String id) throws Exception{
        if(dictService.delById(id)){
            return success();
        }
        return failure();
    }
}
