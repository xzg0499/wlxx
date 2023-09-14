package com.xzg.wlxx.system.entity.po

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import com.xzg.wlxx.common.base.BasePo

@TableName("org")
data class Org(
    @TableField("org_code")
    var orgCode: String? = null,

    @TableField("org_name")
    var orgName: String? = null,
    var orgLevel: Int? = null,
    var orgId: Long? = null
) : BasePo<Org>()