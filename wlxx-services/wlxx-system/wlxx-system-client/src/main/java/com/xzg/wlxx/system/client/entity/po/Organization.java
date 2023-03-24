package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * <p>
 * 组织
 * </p>
 *
 * @author xzgang0499
 * @since 2022-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_organization")
@Schema(description = "Organization对象")
public class Organization extends BasePo<Organization> {

    private static final long serialVersionUID = 1L;

    public static final Integer ROOT = 0;

    @Schema(description = "组织编码")
    @NotBlank(message = "组织编码不能为空")
    //@NotBlank(message = "{user.name.notBlank}")
    // XXX 从配置文件读取错误信息
    private String orgCode;

    @Schema(description = "组织名称")
    @NotBlank(message = "组织名称不能为空")
    private String orgName;

    @Schema(description = "组织级别")
    private Integer level;

    @Schema(description = "上级组织名称")
    private Long parentOrgId;

    @Schema(description = "是否启用")
    private Boolean isEnabled;
}
