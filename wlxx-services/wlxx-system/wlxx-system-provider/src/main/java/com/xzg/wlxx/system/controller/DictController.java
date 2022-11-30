package com.xzg.wlxx.system.controller;


import com.xzg.wlxx.core.base.controller.BaseController;
import com.xzg.wlxx.system.service.IDictService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Api(tags = "数据字典", value = "数据字典")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictController extends BaseController {

    private final IDictService service;


}
