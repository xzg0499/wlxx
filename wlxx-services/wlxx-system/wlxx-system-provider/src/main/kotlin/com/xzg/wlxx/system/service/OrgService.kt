package com.xzg.wlxx.system.service

import com.baomidou.mybatisplus.extension.service.IService
import com.xzg.wlxx.system.entity.po.Org
import com.xzg.wlxx.system.entity.vo.OrgVo

interface OrgService : IService<Org> {

    fun insertOrUpdate(org: Org): Boolean

    fun list4Tree(): List<OrgVo>
}