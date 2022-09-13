package com.xzg.wlxx.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzg.wlxx.common.core.base.BaseController;
import com.xzg.wlxx.common.core.response.Res;
import com.xzg.wlxx.system.client.entity.TDictItem;
import com.xzg.wlxx.system.service.ITDictItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 业务字典项
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
public class TDictItemController extends BaseController<ITDictItemService, TDictItem> {
    @Autowired
    ITDictItemService service;

    @ApiOperation("新增")
    @PostMapping("/add")
    public Res<Boolean> add(@RequestBody TDictItem dictItem) throws Exception{
        if(service.add(dictItem)){
            return success();
        }
        return failure();
    }

    @ApiOperation("分页查询")
    @PostMapping("/queryByPage")
    public Res<IPage<TDictItem>> queryByPage(@RequestBody TDictItem dictItem) throws Exception{
        return success(service.query(dictItem));
        // return null;
    }

    @ApiOperation("根据ID查询字典项")
    @GetMapping("/getById/{id}")
    public Res<TDictItem> getById(@PathVariable("id") String id) throws Exception{
        return success(service.getById(id));
        // return null;
    }

    @ApiOperation("根据ID修改字典项")
    @PutMapping("/updateById")
    public Res<Boolean> updateById(@RequestBody TDictItem dictItem) throws Exception {
        if(service.modify(dictItem)){
            return success();
        }
        return failure();
    }

    @ApiOperation("根据code获取字典")
    @GetMapping("/getByCode/{code}")
    public Res<TDictItem> getByCode(@PathVariable("code")String code) throws Exception {
        return success(service.getByCode(code));
        // return null;
    }
}
