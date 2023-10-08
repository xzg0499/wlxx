package com.xzg.wlxx.system.client.entity.vo

import lombok.Data
import lombok.EqualsAndHashCode

@Data
@EqualsAndHashCode(callSuper = true)
data class OrgVo(
    var id: Long? = null,
    var orgCode: String? = null,

    var orgName: String? = null,
    var orgLevel: Int? = null,
    var orgId: Long? = null,
    var orgType: Int? = null,
    var children: List<OrgVo>? = null
)
