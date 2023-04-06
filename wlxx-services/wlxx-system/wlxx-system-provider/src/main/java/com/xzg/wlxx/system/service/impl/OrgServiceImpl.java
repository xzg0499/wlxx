package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.core.exception.BusinessException;
import com.xzg.wlxx.system.client.entity.po.Org;
import com.xzg.wlxx.system.client.entity.vo.OrgVo;
import com.xzg.wlxx.system.client.enums.OrgTypeEnum;
import com.xzg.wlxx.system.mapper.OrgMapper;
import com.xzg.wlxx.system.service.IOrgService;
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
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements IOrgService {


    /**
     * 新增组织
     * <p>
     * 1、
     */
    @Override
    public boolean add(Org po) {
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
    public boolean addGroup(Org po) {
        po.setLevels(Org.ROOT);
        return save(po);
    }

    /**
     * 新增公司
     */
    public boolean addCompany(Org po) {
        validateParentId(po);
        return save(po);
    }

    /**
     * 新增部门
     */
    public boolean addDep(Org po) {
        validateParentId(po);
        return save(po);
    }

    public void validateParentId(Org po) {
        if (Objects.isNull(po.getParentId())) {
            throw new BusinessException("上级组织不能为空");
        }
        Org group = getById(po.getParentId());
        if (Objects.isNull(group)) {
            throw new BusinessException("上级组织ID【{}】不存在", po.getParentId());
        }
    }

    @Override
    public boolean edit(Org po) {
        return updateById(po);
    }


    @Override
    public List<OrgVo> get(Long id) {
        List<Org> list = lambdaQuery()
                .orderByDesc(Org::getLevels).list();
        List<OrgVo> vos = new ArrayList<>();
        list.stream().filter(e -> {
                    if (Objects.isNull(id)) {
                        return Objects.equals(Org.ROOT, e.getLevels());
                    } else {
                        return id.equals(e.getId());
                    }
                })
                .forEach(e -> {
                    OrgVo vo = new OrgVo();
                    BeanUtil.copyProperties(e, vo);
                    vos.add(vo);
                });
        assembleCompany(list, vos);
        return vos;
    }

    /**
     * 迭代组装Company
     */
    public List<OrgVo> assembleCompany(List<Org> pos, List<OrgVo> vos) {
        vos.forEach(e -> {
            List<OrgVo> list = pos.stream().filter(p ->
                            Objects.deepEquals(e.getId(), p.getParentId())
                                    && p.getLevels().compareTo(e.getLevels()) >= 0)
                    .map(p -> {
                        OrgVo vo = new OrgVo();
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
