package com.xzg.wlxx.system.client.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * @author XiaoZG
 */
@Data
@Validated
@Builder
public class RegisterUserDto {
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
