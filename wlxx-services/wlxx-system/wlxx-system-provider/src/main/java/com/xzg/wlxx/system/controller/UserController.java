package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.BaseController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "user")
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController extends BaseController {


}
