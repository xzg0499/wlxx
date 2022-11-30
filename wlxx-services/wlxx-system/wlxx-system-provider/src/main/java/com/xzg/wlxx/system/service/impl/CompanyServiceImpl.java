package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.po.CompanyPo;
import com.xzg.wlxx.system.client.entity.vo.CompanyVo;
import com.xzg.wlxx.system.mapper.CompanyMapper;
import com.xzg.wlxx.system.service.ICompanyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 公司 服务实现类
 * </p>
 *
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org.service.impl
 * @date 2022/11/11 15:01
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyPo> implements ICompanyService {

    @Override
    public List<CompanyVo> getAll() {
        List<CompanyPo> pos = lambdaQuery().orderByAsc(CompanyPo::getLevel).list();
        List<CompanyVo> vos = new ArrayList<>();
        pos.stream().filter(p -> Objects.deepEquals(0, p.getLevel()))
                .forEach(e -> {
                    CompanyVo vo = new CompanyVo();
                    BeanUtil.copyProperties(e, vo);
                    vos.add(vo);
                });
        assembleCompany(pos, vos);
        return vos;
    }

    /**
     * 迭代组装Company
     */
    public List<CompanyVo> assembleCompany(List<CompanyPo> pos, List<CompanyVo> vos) {

        vos.forEach(e -> {
            List<CompanyVo> list = pos.stream().filter(p -> Objects.deepEquals(e.getId(), p.getParentCompanyId()))
                    .map(p -> {
                        CompanyVo vo = new CompanyVo();
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
