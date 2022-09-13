package com.xzg.wlxx.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.xzg.wlxx.common.core.base.BaseController;
import com.xzg.wlxx.common.core.response.Res;
import com.xzg.wlxx.system.client.entity.TDict;
import com.xzg.wlxx.system.service.ITDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 业务字典
 * @author xzgang0499
 * @date 2022-01-16
 * @since jdk1.8
 */

@Api(tags = "业务字典")
@RestController
@RequestMapping("/dict")
@Slf4j
public class TDictController extends BaseController<ITDictService,TDict> {

    @Autowired
    MapSearcher mapSearcher;

    @Autowired
    ITDictService service;

    // @Value("${spring.datasource.url}")
    // private String jdbcUrl;

    @GetMapping("/query")
    public SearchResult<Map<String, Object>> query(HttpServletRequest request) {
        // 一行代码，实现一个用户检索接口（MapUtils.flat 只是收集前端的请求参数）
        // log.info("数据库地址：{}",jdbcUrl);
        return mapSearcher.search(TDict.class, MapUtils.flat(request.getParameterMap()));
    }

    @ApiOperation("新增")
    @PostMapping("/add")
    public Res<Boolean> add(@RequestBody TDict dict) throws Exception{
        if(service.add(dict)){
            return success();
        }
        return failure();
    }

    @ApiOperation("分页查询")
    @PostMapping("/queryByPage")
    public Res<IPage<TDict>> queryByPage(@RequestBody TDict dict) throws Exception{
        // FIXME 查询是，status枚举不能传NIL，可以传null
        // return success(service.query(dict));
        return null;
    }

    @ApiOperation("根据ID查询字典")
    @GetMapping("/getById/{id}")
    public Res<TDict> getById(@PathVariable("id") String id) throws Exception{
        return success(service.getById(id));
        // return null;
    }

    @ApiOperation("根据ID修改字典")
    @PutMapping("/updateById")
    public Res<Boolean> modify(@RequestBody TDict dict) throws Exception{
        if(service.modify(dict)){
            return success();
        }
        return failure();
    }

    @ApiOperation("根据code获取字典值")
    @GetMapping("/getByCode/{code}")
    public Res<TDict> getByCode(@PathVariable("code") String code) throws Exception {
        return success(service.getByCode(code));
        // return null;
    }

    @ApiOperation("删除业务字典")
    @DeleteMapping("/delById/{id}")
    public Res<Boolean> delById(@PathVariable("id") String id) throws Exception{
        if(service.delById(id)){
            return success();
        }
        return failure();
    }
}
