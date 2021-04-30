package com.xzg.wlxx.module.controller;


import com.xzg.wlxx.framework.base.BaseCtrl;
import com.xzg.wlxx.framework.model.AjaxResult;
import com.xzg.wlxx.module.entity.TDict;
import com.xzg.wlxx.module.service.ITDictService;
import com.xzg.wlxx.utils.BasicUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-01-13
 */
@RestController
@Slf4j
@RequestMapping("/dict")
public class TDictController extends BaseCtrl {
    @Autowired
    private ITDictService itDictService;

    @PostMapping("/add")
    public AjaxResult add(TDict entity){
        entity.setId(BasicUtils.getUUID());
        entity.setCreateTime(LocalDateTime.now());
        entity.setDictCode("TEST");
        entity.setDictName("TEST");
        //TODO 插入时默认值处理
//        entity.setIsDictRoot(1);
//        entity.setState(1);
        itDictService.add(entity);
        return success();
    }

    @PostMapping("/query")
    public AjaxResult query(TDict entity){

        return success("ok",itDictService.queryAll());
    }
}
