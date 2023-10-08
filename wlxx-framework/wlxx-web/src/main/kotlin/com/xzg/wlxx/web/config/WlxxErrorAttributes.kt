package com.xzg.wlxx.web.config

import cn.hutool.core.bean.BeanUtil
import cn.hutool.core.map.MapUtil
import com.xzg.wlxx.common.base.ApiResult.Companion.message
import com.xzg.wlxx.common.log.WlxxLog.Companion.log
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.stereotype.Component
import org.springframework.web.context.request.WebRequest

/**
 * @author XiaoZG
 */
@Component
@Slf4j
class WlxxErrorAttributes : DefaultErrorAttributes() {
    override fun getErrorAttributes(webRequest: WebRequest, options: ErrorAttributeOptions): Map<String, Any> {
        val errorAttributes = super.getErrorAttributes(webRequest, options)
        val strings: Set<String?> = errorAttributes.keys
        for (it in strings) {
            val o = errorAttributes[it]
            log.info("key : {} value: {}", it, o)
        }
        val result = message(
            code = MapUtil.getInt(errorAttributes, "status"),
            msg = MapUtil.getStr(errorAttributes, "message", "")
                    + " " + MapUtil.getStr(errorAttributes, "error", "")
                    + " " + MapUtil.getStr(errorAttributes, "path", ""), null, null
        )
        return BeanUtil.beanToMap(result)
    }
}
