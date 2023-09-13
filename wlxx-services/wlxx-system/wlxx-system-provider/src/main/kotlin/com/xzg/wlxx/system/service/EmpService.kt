package com.xzg.wlxx.system.service

import com.baomidou.mybatisplus.extension.service.IService
import com.xzg.wlxx.system.entity.po.Emp

interface EmpService : IService<Emp> {

    fun insertOrUpdate(emp: Emp): Boolean


}