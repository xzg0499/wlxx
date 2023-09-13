package com.xzg.wlxx.system.base

data class ApiResult<T>(
    var code: Int? = null,
    var msg: String? = null,
    var data: T? = null,
    var ex: Throwable? = null
)