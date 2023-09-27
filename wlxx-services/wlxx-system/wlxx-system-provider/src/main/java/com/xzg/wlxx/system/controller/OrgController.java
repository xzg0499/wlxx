package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.BaseController;
import com.xzg.wlxx.system.service.OrgService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "org")
@RequestMapping("org")
@RequiredArgsConstructor
public class OrgController extends BaseController {

    private final OrgService service;


}
