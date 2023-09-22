package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.po.Emp;

import java.util.List;

public interface EmpService extends IService<Emp> {

    List<Emp> listByOrg(Long orgId);
}
