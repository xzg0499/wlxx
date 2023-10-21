package com.xzg.wlxx.system.controller;

import cn.zhxu.bs.SearchResult;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.base.BaseController;
import com.xzg.wlxx.system.client.entity.po.OrgPo;
import com.xzg.wlxx.system.client.entity.vo.OrgVo;
import com.xzg.wlxx.system.service.OrgService;
import com.xzg.wlxx.system.service.impl.SearcherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;


@RestController
@Tag(name = "org")
@RequestMapping("org")
@RequiredArgsConstructor
public class OrgController extends BaseController {

    private final OrgService service;
    private final SearcherService searcherService;

    @PostMapping("add")
    public ApiResult<Boolean> add(@Validated @RequestBody OrgPo org) {
        return ApiResult.success(service.add(org));
    }

    @GetMapping("search")
    public ApiResult<SearchResult<OrgPo>> search(HttpServletRequest request) {
        return ApiResult.success(searcherService.search(OrgPo.class, request));
    }

    @PostMapping("search")
    public ApiResult<Page<OrgPo>> search(@RequestBody OrgPo po) {
        return ApiResult.success(service.page(new Page<OrgPo>(0, 10), null));
    }

    @PostMapping("export")
    public ApiResult<Boolean> export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("组织", StandardCharsets.UTF_8)
                .replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), OrgPo.class)
                .sheet("模板").doWrite(service.list());
        return ApiResult.success();
    }

    @GetMapping("list")
    public ApiResult<List<OrgVo>> list(@RequestParam(required = false) Long orgId) {
        return ApiResult.success(service.list4Tree(orgId));
    }
}
