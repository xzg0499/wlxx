package com.xzg.wlxx.auth.config.security.auth

import io.swagger.v3.oas.annotations.media.Schema
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class RegisterRequest {
    @Schema(description = "昵称")
    private val username: String? = null

    @Schema(description = "邮箱")
    private val realName: String? = null

    @Schema(description = "密码")
    private val password: String? = null

    @Schema(description = "角色，可选值: CHASER, SUPERVISOR, ADMIN")
    private val role: String? = null
}
