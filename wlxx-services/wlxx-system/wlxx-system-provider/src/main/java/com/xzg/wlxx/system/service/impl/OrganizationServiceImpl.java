package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.core.exception.BusinessException;
import com.xzg.wlxx.system.client.entity.po.Organization;
import com.xzg.wlxx.system.client.entity.vo.OrganizationVo;
import com.xzg.wlxx.system.client.enums.OrgTypeEnum;
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


    /**
     * 新增组织
     * <p>
     * 1、
     */
    @Override
    public boolean add(Organization po) {
        if (Objects.isNull(po.getLevels())) {
            throw new BusinessException("层级不能为空");
        }
        if (Objects.isNull(po.getOrgType())) {
            throw new BusinessException("组织类型不能为空");
        }
        if (Objects.equals(OrgTypeEnum.GROUP.getCode(), po.getOrgType())) {
            return addGroup(po);
        } else if (Objects.equals(OrgTypeEnum.COMPANY.getCode(), po.getOrgType())) {
            return addCompany(po);
        } else if (Objects.equals(OrgTypeEnum.DEPARTMENT.getCode(), po.getOrgType())) {
            return addDep(po);
        }
        throw new BusinessException("组织类型【{}】不在范围内", po.getOrgType());
    }

    /**
     * 新增集团
     */
    public boolean addGroup(Organization po) {
        po.setLevels(Organization.ROOT);
        return save(po);
    }

    /**
     * 新增公司
     */
    public boolean addCompany(Organization po) {
        validateParentId(po);
        return save(po);
    }

    /**
     * 新增部门
     */
    public boolean addDep(Organization po) {
        validateParentId(po);
        return save(po);
    }

    public void validateParentId(Organization po) {
        if (Objects.isNull(po.getParentId())) {
            throw new BusinessException("上级组织不能为空");
        }
        Organization group = getById(po.getParentId());
        if (Objects.isNull(group)) {
            throw new BusinessException("上级组织ID【{}】不存在", po.getParentId());
        }
    }

    @Override
    public boolean edit(Organization po) {
        return updateById(po);
    }


    @Override
    public List<OrganizationVo> get(Long id) {
        List<Organization> list = lambdaQuery()
                .orderByDesc(Organization::getLevels).list();
        List<OrganizationVo> vos = new ArrayList<>();
        list.stream().filter(e -> {
                    if (Objects.isNull(id)) {
                        return Objects.equals(Organization.ROOT, e.getLevels());
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
                            Objects.deepEquals(e.getId(), p.getParentId())
                                    && p.getLevels().compareTo(e.getLevels()) >= 0)
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
