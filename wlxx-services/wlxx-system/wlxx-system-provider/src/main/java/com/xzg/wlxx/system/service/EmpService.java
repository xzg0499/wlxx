package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.dto.EmpDto;
import com.xzg.wlxx.system.client.entity.po.EmpPo;

public interface EmpService extends IService<EmpPo> {

    IPage<EmpPo> searchByOrg(EmpDto dto);


    boolean add(EmpDto dto);
}
