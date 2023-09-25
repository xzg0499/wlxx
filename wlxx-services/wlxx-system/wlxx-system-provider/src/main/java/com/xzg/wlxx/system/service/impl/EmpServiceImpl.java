package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.po.EmpPo;
import com.xzg.wlxx.system.mapper.EmpMapper;
import com.xzg.wlxx.system.service.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmpServiceImpl extends ServiceImpl<EmpMapper, EmpPo> implements EmpService {

    @Override
    public List<EmpPo> listByOrg(Long orgId) {
        return lambdaQuery()
                .eq(Objects.nonNull(orgId), EmpPo::getOrgId, orgId)
                .list();
    }
}
