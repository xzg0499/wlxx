package com.xzg.wlxx.system.service.impl

import cn.hutool.core.bean.BeanUtil
import cn.hutool.core.collection.CollUtil
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.xzg.wlxx.system.client.entity.po.OrgPo
import com.xzg.wlxx.system.client.entity.vo.OrgVo
import com.xzg.wlxx.system.client.exception.BusinessException
import com.xzg.wlxx.system.mapper.OrgMapper
import com.xzg.wlxx.system.service.OrgService
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Consumer
import java.util.stream.Collectors

@Service
@Slf4j
@RequiredArgsConstructor
class OrgServiceImpl : ServiceImpl<OrgMapper?, OrgPo?>(), OrgService {
    override fun add(org: OrgPo): Boolean {
        val isRepeat = ktQuery().eq(OrgPo::orgCode, org.orgCode)
            .exists()
        if (isRepeat) {
            throw BusinessException("orgCode is repeat")
        }
        return save(org)
    }

    override fun list4Tree(rootId: Long?): List<OrgVo?> {
        val list = ktQuery().orderByAsc(OrgPo::orgLevel)
            .list()
        val rootLevel: Int? = list[0]?.orgLevel
        val result = list.stream()
            .filter { e: OrgPo? -> if (Objects.nonNull(rootId)) e?.id == rootId else e?.orgLevel == rootLevel }
            .map<OrgVo?> { e: OrgPo? ->
                val vo = OrgVo()
                BeanUtil.copyProperties(e, vo)
                vo
            }.collect(Collectors.toList<OrgVo?>())
        iterator(list, result)
        return result
    }

    fun iterator(list: List<OrgPo?>, result: List<OrgVo?>) {
        result.forEach(Consumer<OrgVo?> { e: OrgVo? ->
            val children = list.stream()
                .filter { sub: OrgPo? -> e?.id == sub?.orgId }
                .map<OrgVo?> { map: OrgPo? ->
                    val vo = OrgVo()
                    BeanUtil.copyProperties(map, vo)
                    vo
                }.collect(Collectors.toList<OrgVo?>())
            if (!CollUtil.isEmpty(children)) {
                iterator(list, children)
                
            }
        })
    }
}
