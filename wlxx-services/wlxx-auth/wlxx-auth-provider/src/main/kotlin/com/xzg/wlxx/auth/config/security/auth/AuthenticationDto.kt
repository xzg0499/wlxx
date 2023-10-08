package com.xzg.wlxx.auth.config.security.auth

import lombok.Data

/**
 * @author XiaoZG
 */
@Data
data class AuthenticationDto(
    var username: String? = null,
    var password: String? = null
)
