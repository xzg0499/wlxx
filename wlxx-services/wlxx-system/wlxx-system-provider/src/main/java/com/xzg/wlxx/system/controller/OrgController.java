package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.base.BaseController;
import com.xzg.wlxx.system.client.feign.OrgProvider;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Tag(name = "org")
@RequestMapping("org")
@RequiredArgsConstructor
public class OrgController extends BaseController {

    private final OrgProvider orgProvider;

    @PostMapping("get")
    public ApiResult<Map<String, Object>> get(@RequestBody Map<String, Object> map) {
        return success(orgProvider.test(map));
    }

    @PostMapping("test")
    public ApiResult<Map<String, Object>> test(@RequestBody Map<String, Object> map) {
        return success(map);
    }
}
