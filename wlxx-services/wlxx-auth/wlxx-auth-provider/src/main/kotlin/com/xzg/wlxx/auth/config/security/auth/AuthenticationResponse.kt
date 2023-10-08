package com.xzg.wlxx.auth.config.security.auth

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
data class AuthenticationResponse(
    @JsonProperty("access_token")
    private val accessToken: String? = null,

    @JsonProperty("refresh_token")
    var refreshToken: String? = null
)
