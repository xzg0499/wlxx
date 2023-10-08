package com.xzg.wlxx.system.client.entity.po

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import com.xzg.wlxx.common.base.BasePo
import lombok.Data
import lombok.EqualsAndHashCode

@TableName("org")
@Data
@EqualsAndHashCode(callSuper = true)
data class OrgPo(
    @TableField("org_code")
    var orgCode: String? = null,

    @TableField("org_name")
    var orgName: String? = null,
    var orgLevel: Int? = null,
    var orgId: Long? = null,
    var orgType: Int? = null,
) : BasePo<OrgPo?>()
