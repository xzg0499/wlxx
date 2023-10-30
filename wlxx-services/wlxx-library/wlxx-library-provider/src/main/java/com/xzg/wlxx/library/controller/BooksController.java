package com.xzg.wlxx.library.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.library.pojo.dto.BooksDto;
import com.xzg.wlxx.library.pojo.po.BooksPo;
import com.xzg.wlxx.library.service.BooksService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "books")
@RequestMapping("books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService service;

    @PostMapping("add")
    public ApiResult<Boolean> add(@RequestBody BooksDto dto) {
        return ApiResult.message(service.batchAdd(List.of(dto)));
    }

    @PostMapping("batchAdd")
    public ApiResult<Boolean> batchAdd(@RequestBody List<BooksDto> list) {
        return ApiResult.message(service.batchAdd(list));
    }

    @PostMapping("search")
    public ApiResult<IPage<BooksPo>> search(@RequestBody BooksDto dto) {
        return ApiResult.success(service.search(dto));
    }

    @PostMapping("import")
    @Parameter(name = "file", schema = @Schema(type = "string", format = "binary"))
    public ApiResult<Boolean> importExcel(@RequestParam("file") MultipartFile file) {
        return ApiResult.success(service.importExcel(file));
    }
}
