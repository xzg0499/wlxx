package com.xzg.wlxx.system.controller;

import cn.zhxu.bs.BeanSearcher;
import cn.zhxu.bs.SearchResult;
import cn.zhxu.bs.util.MapUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzg.wlxx.common.base.ApiResult;
import com.xzg.wlxx.common.base.BaseController;
import com.xzg.wlxx.system.client.entity.po.OrgPo;
import com.xzg.wlxx.system.service.OrgService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "org")
@RequestMapping("org")
@RequiredArgsConstructor
public class OrgController extends BaseController {

    private final OrgService service;
    private final BeanSearcher beanSearcher;

    @PostMapping("add")
    public ApiResult<Boolean> add(@RequestBody OrgPo org) {
        return ApiResult.success(service.save(org));
    }

    @GetMapping("search")
    public ApiResult<SearchResult<OrgPo>> search(HttpServletRequest request) {
        return ApiResult.success(beanSearcher.search(OrgPo.class, MapUtils.flat(request.getParameterMap())));
    }

    @PostMapping("search")
    public ApiResult<Page<OrgPo>> search(@RequestBody OrgPo po) {
        return ApiResult.success(service.page(new Page<OrgPo>(0, 10), null));
    }
}
