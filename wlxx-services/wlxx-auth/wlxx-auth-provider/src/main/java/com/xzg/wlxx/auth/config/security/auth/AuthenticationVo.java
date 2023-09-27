package com.xzg.wlxx.auth.config.security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author XiaoZG
 */
@Data
@Builder
public class AuthenticationVo {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
}
