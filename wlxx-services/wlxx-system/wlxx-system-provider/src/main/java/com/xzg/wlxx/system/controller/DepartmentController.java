package com.xzg.wlxx.system.controller;


import com.xzg.wlxx.core.base.controller.BaseController;
import com.xzg.wlxx.system.client.entity.po.DepartmentPo;
import com.xzg.wlxx.system.service.IDepartmentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门 前端控制器
 * </p>
 *
 * @author xzgan
 * @since 2022-11-12
 */
@RestController
@Api(tags = "部门", value = "部门")
@RequestMapping("department")
public class DepartmentController extends BaseController<IDepartmentService, DepartmentPo> {

}
