package com.xzg.wlxx.org.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.xzg.wlxx.core.base.BaseRes;
import com.xzg.wlxx.core.base.controller.BaseController;
import com.xzg.wlxx.core.base.response.Result;
import com.xzg.wlxx.org.entity.param.CompanyPageParam;
import com.xzg.wlxx.org.entity.po.CompanyPo;
import com.xzg.wlxx.org.service.ICompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org.controller
 * @date 2022/11/11 15:01
 */
@RestController
@Api(tags = "公司", value = "公司")
@RequestMapping("company")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyController extends BaseController<ICompanyService, CompanyPo> {

    private final ICompanyService service;

    private final BeanSearcher beanSearcher;

    private final MapSearcher mapSearcher;

    @ApiOperation("BeanSearcher")
    @PostMapping("bean-searcher")
    public SearchResult<CompanyPo> beanSearch(HttpServletRequest request) {
        SearchResult<CompanyPo> result = beanSearcher.search(CompanyPo.class, MapUtils.flat(request.getParameterMap()));
        return result;
    }

    @ApiOperation("MapSearcher")
    @PostMapping("map-searcher")
    public SearchResult<Map<String, Object>> mapSearch(HttpServletRequest request) {
        SearchResult<Map<String, Object>> result = mapSearcher.search(CompanyPo.class, MapUtils.flat(request.getParameterMap()));
        return result;
    }

    @ApiOperation("新增")
    @PostMapping("add")
    public Result add(@RequestBody @Validated CompanyPo entity) {
        if (service.save(entity)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @ApiOperation("分页查询")
    @PostMapping("query-page")
    public Result<IPage<CompanyPo>> queryByPage(@RequestBody CompanyPageParam param) {
        return BaseRes.success(service.page(param.getPage()));
    }

    @ApiOperation("获取所有公司")
    @PostMapping("getAll")
    public Result<List<CompanyPo>> getAll() {

        return BaseRes.success();
    }

    @ApiOperation("修改")
    @PutMapping("update")
    public Result update(@RequestBody CompanyPo entity) {
        if (service.updateById(entity)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }

    @ApiOperation(value = "逻辑删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        if (service.removeById(id)) {
            return BaseRes.success();
        }
        return BaseRes.failure();
    }
}
