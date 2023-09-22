package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.po.Org;
import com.xzg.wlxx.system.client.entity.vo.OrgVo;
import com.xzg.wlxx.system.client.exception.BusinessException;
import com.xzg.wlxx.system.mapper.OrgMapper;
import com.xzg.wlxx.system.service.OrgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements OrgService {
    @Override
    public Boolean add(Org org) {
        boolean isRepeat = baseMapper.exists(Wrappers.<Org>lambdaQuery()
                .eq(Org::getOrgCode, org.getOrgCode()));
        if (isRepeat) {
            throw new BusinessException("orgCode is repeat");
        }
        return save(org);
    }

    @Override
    public List<OrgVo> list4Tree(Long rootId) {
        List<Org> list = baseMapper.selectList(Wrappers.<Org>lambdaQuery()
                .orderByAsc(Org::getOrgLevel));
        Integer rootLevel = list.stream().findFirst().get().getOrgLevel();
        List<OrgVo> result = list.stream()
                .filter(e ->
                        Objects.nonNull(rootId)
                                ? Objects.equals(e.getId(), rootId)
                                : Objects.equals(e.getOrgLevel(), rootLevel
                        )
                )
                .map(e -> {
                    OrgVo vo = new OrgVo();
                    BeanUtil.copyProperties(e, vo);
                    return vo;
                }).collect(Collectors.toList());
        iterator(list, result);
        return result;
    }

    public void iterator(List<Org> list, List<OrgVo> result) {
        result.forEach(e -> {
            List<OrgVo> children = list.stream()
                    .filter(sub -> Objects.equals(e.getId(), sub.getOrgId()))
                    .map(map -> {
                        OrgVo vo = new OrgVo();
                        BeanUtil.copyProperties(map, vo);
                        return vo;
                    }).collect(Collectors.toList());
            if (!CollUtil.isEmpty(children)) {
                iterator(list, children);
                e.setChildren(children);
            }
        });
    }
}
