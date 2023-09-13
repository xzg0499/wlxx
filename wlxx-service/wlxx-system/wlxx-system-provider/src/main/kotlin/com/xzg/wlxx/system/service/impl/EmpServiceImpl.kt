package com.xzg.wlxx.system.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.xzg.wlxx.system.entity.po.Emp
import com.xzg.wlxx.system.mapper.EmpMapper
import com.xzg.wlxx.system.service.EmpService
import org.springframework.stereotype.Service

@Service
class EmpServiceImpl() : ServiceImpl<EmpMapper, Emp>(), EmpService {

    override fun insertOrUpdate(emp: Emp): Boolean {
        return save(emp)
    }
}