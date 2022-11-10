package com.xzg.wlxx.common.web.base;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * FIXME controller 中service注册会导致多例
 *
 * @author xzgang0499
 * @date 2022-01-14
 * @since jdk1.8
 */
public class BaseController<S extends IService<T>, T> extends BaseRes {

    //@Autowired
    //protected S service;


    // Class<S> clas = (Class<S>) ReflectionKit.getSuperClassGenericType(this.getClass(), BaseController.class, 0);
    // @Autowired
    // MapSearcher mapSearcher;


    // @ApiOperation("新增")
    // @PostMapping("add")
    // public Res<Object> add(@RequestBody T t){
    //     return success(service.save(t));
    // }
    //
    // @ApiOperation("删除")
    // @DeleteMapping("del")
    // public Res<Boolean> del(@RequestBody Serializable id){
    //     return success(service.removeById(id));
    // }
    //
    // @ApiOperation("批量删除")
    // @DeleteMapping("del-batch")
    // public Res<Object> delBatch(@RequestBody List<Object> ids){
    //     return success(service.removeBatchByIds(ids));
    // }
    //
    // @ApiOperation("修改")
    // @PutMapping("update")
    // public Res<Object> update(@RequestBody T t){
    //     return success(service.updateById(t));
    // }
    //
    // @ApiOperation("查询")
    // @PostMapping("/query")
    // public Res<IPage<T>> query(@RequestBody T t){
    //     return success(service.page(new Page<>(0,10),new LambdaQueryWrapper<>()));
    // }

    // @GetMapping("/beanSearch")
    // public SearchResult<Map<String, Object>> beanSearch(HttpServletRequest request) {
    //     // 一行代码，实现一个用户检索接口（MapUtils.flat 只是收集前端的请求参数）
    //     // log.info("数据库地址：{}",jdbcUrl);
    //     // return mapSearcher.search(clas, MapUtils.flat(request.getParameterMap()));
    //     return null;
    // }
}
