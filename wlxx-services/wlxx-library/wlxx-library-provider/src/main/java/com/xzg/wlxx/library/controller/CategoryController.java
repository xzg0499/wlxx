package com.xzg.wlxx.library.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.library.pojo.dto.CategoryDto;
import com.xzg.wlxx.library.pojo.po.CategoryPo;
import com.xzg.wlxx.library.service.CategoryService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("import")
    @Parameter(name = "file")
    public ApiResult<Boolean> importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        return ApiResult.success(service.importExcel(file));
    }

    @PostMapping("export")
    public ApiResult<Boolean> exportExcel(@RequestBody CategoryDto dto, HttpServletResponse response) throws IOException {
        // FIXME knife4j导出异常，junit导出正常
        service.exportExcel(dto, response);
        return ApiResult.success();
    }
}
