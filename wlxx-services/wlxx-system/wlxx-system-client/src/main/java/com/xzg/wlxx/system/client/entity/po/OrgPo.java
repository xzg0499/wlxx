package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("org")
@Data
@EqualsAndHashCode(callSuper = true)
public class OrgPo extends BasePo<OrgPo> {

    @TableField("org_code")
    private String orgCode;

    @TableField("org_name")
    private String orgName;
    private Integer orgLevel;
    private Long orgId;
    private Integer orgType;
}
