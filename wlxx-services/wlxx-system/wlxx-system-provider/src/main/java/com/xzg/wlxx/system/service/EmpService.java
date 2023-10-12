package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.dto.EmpDto;
import com.xzg.wlxx.system.client.entity.po.EmpPo;

import java.util.List;

public interface EmpService extends IService<EmpPo> {

    List<EmpPo> listByOrg(Long orgId);

    boolean add(EmpDto dto);
}
