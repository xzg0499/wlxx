package com.xzg.wlxx.system.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.xzg.wlxx.system.client.entity.po.EmpPo
import com.xzg.wlxx.system.mapper.EmpMapper
import com.xzg.wlxx.system.service.EmpService
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.util.*

@Service
@Slf4j
@RequiredArgsConstructor
class EmpServiceImpl : ServiceImpl<EmpMapper?, EmpPo?>(), EmpService {
    override fun listByOrg(orgId: Long?): List<EmpPo?>? {
        return ktQuery()
            .eq(Objects.nonNull(orgId), EmpPo::orgId, orgId)
            .list()
    }
}
