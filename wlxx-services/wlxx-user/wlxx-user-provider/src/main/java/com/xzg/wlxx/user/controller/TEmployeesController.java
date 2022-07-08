package com.xzg.wlxx.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzg.wlxx.common.core.base.BaseController;
import com.xzg.wlxx.common.core.response.Res;
import com.xzg.wlxx.system.client.entity.TDict;
import com.xzg.wlxx.system.client.feign.IDictFeign;
import com.xzg.wlxx.user.client.entity.TEmployees;
import com.xzg.wlxx.user.service.TEmployeesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @author xzgan
 * @date 2022/6/7
 * @since jdk1.8
 */
@Api(tags = "员工管理")
@RestController
@RequestMapping("/employees")
public class TEmployeesController extends BaseController {

    @Autowired
    TEmployeesService employeesService;

    @ApiOperation("新增")
    @PostMapping("/add")
    public Res<Boolean> add(@RequestBody TEmployees employees) {
        if(employeesService.save(employees)){
            return success();
        }
        return failure();
    }

    @ApiOperation("修改")
    @PutMapping("/modify")
    public Res<Boolean> modify(@RequestBody TEmployees employees) {
        if(employees.updateById()){
            return success();
        }
        return failure();
    }

    @ApiOperation("查询")
    @PostMapping("/queryByPage")
    public Res<IPage<TEmployees>> queryByPage(@RequestBody TEmployees employees) {
        return success(employeesService.page(new Page<>(0,10),new LambdaQueryWrapper<>()));
    }

    @ApiOperation("根据ID删除")
    @DeleteMapping("/delById/{id}")
    public Res<Boolean> delById(@PathVariable String id) {
        if(employeesService.removeById(id)){
            return success();
        }
        return failure();
    }

    @Autowired
    IDictFeign dictFeign;

    @ApiModelProperty("测试feign")
    @GetMapping("/demo")
    public Res demo() throws Exception {
        TDict dict = new TDict();
        return dictFeign.queryByPage(dict);
    }
}
