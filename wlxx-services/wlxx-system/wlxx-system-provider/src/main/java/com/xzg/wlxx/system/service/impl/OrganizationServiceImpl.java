package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.po.Organization;
import com.xzg.wlxx.system.client.entity.vo.OrganizationVo;
import com.xzg.wlxx.system.mapper.OrganizationMapper;
import com.xzg.wlxx.system.service.IOrganizationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 组织 服务实现类
 * </p>
 *
 * @author xzgang0499
 * @since 2022-11-11
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {


    @Override
    public boolean add(Organization po) {

        return save(po);
    }

    @Override
    public boolean edit(Organization po) {
        return updateById(po);
    }


    @Override
    public List<OrganizationVo> get(Long id) {
        List<Organization> list = lambdaQuery()
                .orderByDesc(Organization::getLevel).list();
        List<OrganizationVo> vos = new ArrayList<>();
        list.stream().filter(e -> {
                    if (Objects.isNull(id)) {
                        return Objects.deepEquals(Organization.ROOT, e.getLevel());
                    } else {
                        return id.equals(e.getId());
                    }
                })
                .forEach(e -> {
                    OrganizationVo vo = new OrganizationVo();
                    BeanUtil.copyProperties(e, vo);
                    vos.add(vo);
                });
        assembleCompany(list, vos);
        return vos;
    }

    /**
     * 迭代组装Company
     */
    public List<OrganizationVo> assembleCompany(List<Organization> pos, List<OrganizationVo> vos) {
        vos.forEach(e -> {
            List<OrganizationVo> list = pos.stream().filter(p ->
                            Objects.deepEquals(e.getId(), p.getParentOrgId())
                                    && p.getLevel().compareTo(e.getLevel()) >= 0)
                    .map(p -> {
                        OrganizationVo vo = new OrganizationVo();
                        BeanUtil.copyProperties(p, vo);
                        return vo;
                    })
                    .collect(Collectors.toList());
            e.setChildren(list);
            if (!CollectionUtil.isEmpty(list)) {
                assembleCompany(pos, list);
            }
        });

        return vos;
    }
}
