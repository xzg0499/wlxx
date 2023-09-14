package com.xzg.wlxx.system.entity.vo

import com.xzg.wlxx.common.base.BasePo
import com.xzg.wlxx.system.entity.po.Org

data class OrgVo(
    var orgCode: String? = null,
    var orgName: String? = null,
    var orgLevel: Int? = null,
    var orgId: Long? = null,

    var children: List<OrgVo>? = listOf()
) : BasePo<Org>() {
    fun copy(org: Org) {
        this.id = org.id
        this.createBy = org.createBy
        this.createDate = org.createDate
        this.updateBy = org.updateBy
        this.updateDate = org.updateDate
        this.orgCode = org.orgCode
        this.orgName = org.orgName
        this.orgLevel = org.orgLevel
        this.orgId = org.orgId
    }
}
