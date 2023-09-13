package com.xzg.wlxx.system.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.xzg.wlxx.system.entity.po.Org
import com.xzg.wlxx.system.entity.vo.OrgVo
import com.xzg.wlxx.system.mapper.OrgMapper
import com.xzg.wlxx.system.service.OrgService
import org.springframework.stereotype.Service

@Service
class OrgServiceImpl() : ServiceImpl<OrgMapper, Org>(), OrgService {

    override fun insertOrUpdate(org: Org): Boolean {
        return saveOrUpdate(org)
    }

    override fun list4Tree(): List<OrgVo> {
        val list: List<OrgVo> = ktQuery()
            .eq(Org::orgLevel, 0)
            .list()
            .map {
                val vo: OrgVo = OrgVo()
                vo.copy(it)
                vo
            }
        iterator(list)
        return list
    }

    fun iterator(list: List<OrgVo>) {
        list.forEach {
            val children = ktQuery().eq(Org::orgId, it.id)
                .list()
                .map {
                    val vo: OrgVo = OrgVo()
                    vo.copy(it)
                    vo
                }
            it.children = children
            if (children.isNotEmpty()) {
                iterator(children)
            }
        }
    }

}

