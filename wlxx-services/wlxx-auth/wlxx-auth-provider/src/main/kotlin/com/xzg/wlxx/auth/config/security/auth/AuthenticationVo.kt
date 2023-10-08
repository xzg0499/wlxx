package com.xzg.wlxx.auth.config.security.auth

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Builder
import lombok.Data

/**
 * @author XiaoZG
 */
@Data
@Builder
data class AuthenticationVo(
    @JsonProperty("access_token")
    var accessToken: String? = null,

    @JsonProperty("refresh_token")
    var refreshToken: String? = null
)
