package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("org")
@Data
@EqualsAndHashCode(callSuper = true)
public class OrgPo extends BasePo<OrgPo> {

    @TableField("org_code")
    @NotBlank(message = "不能为空")
    private String orgCode;

    @TableField("org_name")
    @NotBlank(message = "不能为空")
    private String orgName;
    private Integer orgLevel;
    private Long orgId;
    private Integer orgType;
}
