package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

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
@ApiModel(value = "Organization对象", description = "组织")
public class OrganizationPo extends BasePo<OrganizationPo> {

    private static final long serialVersionUID = 1L;

    public static final Integer ROOT = 0;

    @ApiModelProperty(value = "组织编码")
    @NotBlank(message = "组织编码不能为空")
    //@NotBlank(message = "{user.name.notBlank}")
    // XXX 从配置文件读取错误信息
    private String orgCode;

    @ApiModelProperty(value = "组织名称")
    @NotBlank(message = "组织名称不能为空")
    private String orgName;

    @ApiModelProperty(value = "组织级别")
    private Integer level;

    @ApiModelProperty(value = "上级组织名称")
    private Long parentOrgId;

    @ApiModelProperty(value = "是否启用")
    private Boolean isEnabled;
}
