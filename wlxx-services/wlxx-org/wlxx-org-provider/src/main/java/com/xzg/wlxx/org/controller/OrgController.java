package com.xzg.wlxx.org.controller;

import com.xzg.wlxx.core.base.BaseController;
import com.xzg.wlxx.core.response.Res;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org.controller
 * @date 2022/11/10 16:04
 */
@RestController
@Api(tags = "组织结构", value = "组织结构")
@RequestMapping("org")
@Slf4j
public class OrgController extends BaseController {

    @ApiOperation("新增")
    @PostMapping("add")
    public Res add() {
        log.debug("add");
        return success();
    }
}
