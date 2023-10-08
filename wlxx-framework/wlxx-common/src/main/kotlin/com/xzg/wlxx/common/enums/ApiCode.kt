package com.xzg.wlxx.common.enums

import cn.hutool.core.lang.func.Func1
import cn.hutool.core.util.EnumUtil
import lombok.Getter

/**
 * @author XiaoZG
 */
@Getter
enum class ApiCode(private val code: Int, private val msg: String) {
    NULL(404, "null"),
    NO_AUTH(401, "认证失败");

    companion object {
        fun findByCode(code: Int): ApiCode {
            return EnumUtil.getBy<ApiCode, Int>(Func1<ApiCode, Int> { obj: ApiCode -> obj.code }, code, NULL)
        }
    }
}
