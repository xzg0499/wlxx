package com.xzg.wlxx.system.client.entity.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import lombok.Builder
import lombok.Data
import org.springframework.validation.annotation.Validated

/**
 * @author XiaoZG
 */
@Data
@Validated
@Builder
data class RegisterUserDto(
    var username: @NotEmpty(message = "用户名不能为空") String? = null,
    var password: @NotBlank(message = "密码不能为空") String? = null
)
