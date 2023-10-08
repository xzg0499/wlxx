package com.xzg.wlxx.system.service

import com.baomidou.mybatisplus.extension.service.IService
import com.xzg.wlxx.system.client.entity.po.OrgPo
import com.xzg.wlxx.system.client.entity.vo.OrgVo

interface OrgService : IService<OrgPo?> {
    fun add(org: OrgPo): Boolean
    fun list4Tree(rootId: Long?): List<OrgVo?>
}
