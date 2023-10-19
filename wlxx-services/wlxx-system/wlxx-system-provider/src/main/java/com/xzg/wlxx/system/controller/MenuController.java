package com.xzg.wlxx.system.controller;

import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.system.client.entity.dto.MenuDto;
import com.xzg.wlxx.system.client.entity.vo.MenuVo;
import com.xzg.wlxx.system.service.MenuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "menu")
@RequestMapping("menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService service;

    @PostMapping("add")
    public ApiResult<Boolean> addMenu(@RequestBody MenuDto dto) {
        return ApiResult.success(service.addMenu(dto));
    }

    @PostMapping("update")
    public ApiResult<Boolean> updateMenu(@RequestBody MenuDto dto) {
        return ApiResult.success(service.updateMenu(dto));
    }

    @GetMapping("list")
    public ApiResult<List<MenuVo>> list() {
        return ApiResult.success(service.listMenu());
    }

}
