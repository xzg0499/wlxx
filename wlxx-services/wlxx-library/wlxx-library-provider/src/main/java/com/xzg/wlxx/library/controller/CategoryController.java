package com.xzg.wlxx.library.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.library.pojo.dto.CategoryDto;
import com.xzg.wlxx.library.pojo.po.CategoryPo;
import com.xzg.wlxx.library.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "category")
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping("batchAdd")
    public ApiResult<Boolean> batchAdd(@RequestBody List<CategoryDto> list) {
        return ApiResult.message(service.batchAdd(list));
    }

    @PostMapping("page")
    public ApiResult<IPage<CategoryPo>> page(@RequestBody CategoryDto dto) {
        return ApiResult.success(service.search(dto));
    }
}
