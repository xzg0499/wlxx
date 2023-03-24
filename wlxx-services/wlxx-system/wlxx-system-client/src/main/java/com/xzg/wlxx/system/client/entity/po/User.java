package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_user")
@Schema(description = "User对象")
public class User extends BasePo<User> {

    private static final long serialVersionUID = 1L;

    @Schema(description = "是否启用")
    private Boolean isEnabled;

    @Schema(description = "用户名称")
    private String userName;

    @Schema(description = "用户姓名")
    private String userRealName;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "员工ID")
    private Long empId;
}
