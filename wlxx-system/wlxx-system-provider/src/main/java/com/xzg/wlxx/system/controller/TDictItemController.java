package com.xzg.wlxx.system.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzg.wlxx.common.core.base.BaseController;
import com.xzg.wlxx.common.core.response.ResponseResult;
import com.xzg.wlxx.system.client.entity.TDictItem;
import com.xzg.wlxx.system.service.ITDictItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseResult<Boolean> add(@RequestBody TDictItem dictItem) throws Exception{
        return success(dictItem.insert());
    }

    @ApiOperation("分页查询")
    @PostMapping("/queryByPage")
    public ResponseResult<IPage<TDictItem>> queryByPage(@RequestBody TDictItem dictItem) throws Exception{
        return success(dictItemService.page(new Page<>(dictItem.getPageNo(),dictItem.getPageSize()),new LambdaQueryWrapper<>()));
    }

    @ApiOperation("根据ID查询字典项")
    @GetMapping("/getById/{id}")
    public ResponseResult<TDictItem> getById(@PathVariable("id") String id) throws Exception{
        return success(dictItemService.getById(id));
    }

    @ApiOperation("根据ID修改字典项")
    @PutMapping("/updateById")
    public ResponseResult<Boolean> updateById(@RequestBody TDictItem dictItem){
        return success(dictItem.updateById());
    }

    @ApiOperation("根据code获取字典")
    @GetMapping("/getByCode/{code}")
    public ResponseResult<TDictItem> getByCode(@PathVariable("code")String code){
        TDictItem dictItem = dictItemService.lambdaQuery().eq(StrUtil.isNotBlank(code),TDictItem::getDictCode,code).one();
        return success(dictItem);
    }
}
