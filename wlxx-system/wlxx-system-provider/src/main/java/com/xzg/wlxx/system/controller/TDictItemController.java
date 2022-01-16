package com.xzg.wlxx.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzg.wlxx.common.core.pojo.entity.BaseController;
import com.xzg.wlxx.common.core.response.ResponseData;
import com.xzg.wlxx.system.api.entity.TDict;
import com.xzg.wlxx.system.api.entity.TDictItem;
import com.xzg.wlxx.system.service.ITDictItemService;
import com.xzg.wlxx.system.service.ITDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzg
 * @since 2022-01-16
 */
@Api(tags = "业务字典项")
@RestController
@RequestMapping("/dict-item")
public class TDictItemController extends BaseController {
    @Autowired
    ITDictItemService dictItemService;

    @ApiOperation("新增")
    @PostMapping("/add")
    public ResponseData<Boolean> add(@RequestBody TDictItem dictItem) throws Exception{
        return success(dictItemService.save(dictItem));
    }

    @ApiOperation("分页查询")
    @PostMapping("/queryByPage")
    public ResponseData<IPage<TDictItem>> queryByPage(@RequestBody TDictItem dictItem) throws Exception{
        return success(dictItemService.page(new Page<>(dictItem.getPageNo(),dictItem.getPageSize()),new LambdaQueryWrapper<>()));
    }

    @ApiOperation("根据ID查询字典项")
    @GetMapping("/getById/{id}")
    public ResponseData<TDictItem> getById(@PathVariable("id") String id) throws Exception{
        return success(dictItemService.getById(id));
    }
}
