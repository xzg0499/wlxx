package com.xzg.wlxx.system.controller

import cn.zhxu.bs.*
import cn.zhxu.bs.util.MapUtils
import com.alibaba.excel.EasyExcel
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.xzg.wlxx.common.base.ApiResult
import com.xzg.wlxx.common.base.ApiResult.Companion.success
import com.xzg.wlxx.common.base.BaseController
import com.xzg.wlxx.system.client.entity.po.OrgPo
import com.xzg.wlxx.system.service.OrgService
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import java.io.IOException
import java.net.URLEncoder

@RestController
@Tag(name = "org")
@RequestMapping("org")
@RequiredArgsConstructor
class OrgController : BaseController() {
    private val service: OrgService? = null
    private val beanSearcher: BeanSearcher? = null

    @PostMapping("add")
    fun add(@RequestBody org: OrgPo): ApiResult<Boolean> {
        return success(service!!.save(org))
    }

    @GetMapping("search")
    fun search(request: HttpServletRequest): ApiResult<SearchResult<OrgPo>> {
        return success(beanSearcher!!.search(OrgPo::class.java, MapUtils.flat(request.parameterMap)))
    }

    @PostMapping("search")
    fun search(@RequestBody po: OrgPo?): ApiResult<Page<OrgPo?>> {
        return success(service!!.page(Page(0, 10), null))
    }

    @PostMapping("export")
    @Throws(IOException::class)
    fun export(request: HttpServletRequest?, response: HttpServletResponse): ApiResult<Boolean?> {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        response.characterEncoding = "utf-8"
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        val fileName = URLEncoder.encode("测试", "UTF-8").replace("\\+".toRegex(), "%20")
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''$fileName.xlsx")
        EasyExcel.write(response.outputStream, OrgPo::class.java)
            .sheet("模板").doWrite(service!!.list())
        return success()
    }
}
