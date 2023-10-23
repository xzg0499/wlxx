package com.xzg.wlxx.system.client.entity.po;


import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@TableName("user")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(title = "用户")
public class UserPo extends BasePo<UserPo> {

    private String username;
    private String realName;
    private String password;
    private Long empId;
    @Schema(name = "roleId", title = "角色", description = "ID", example = "0", requiredMode = Schema.RequiredMode.REQUIRED, format = "0")
    private Long roleId;

    @Schema(description = "是否启用", defaultValue = "1")
    private Boolean enabled;
}
