package com.xzg.wlxx.system.service

import com.baomidou.mybatisplus.extension.service.IService
import com.xzg.wlxx.system.client.entity.po.EmpPo

interface EmpService : IService<EmpPo?> {
    fun listByOrg(orgId: Long?): List<EmpPo?>?
}
