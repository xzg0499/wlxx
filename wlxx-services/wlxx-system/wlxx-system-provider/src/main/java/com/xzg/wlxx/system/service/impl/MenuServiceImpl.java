package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.common.util.PojoConvertor;
import com.xzg.wlxx.system.client.entity.dto.MenuDto;
import com.xzg.wlxx.system.client.entity.po.MenuPo;
import com.xzg.wlxx.system.client.entity.vo.MenuVo;
import com.xzg.wlxx.system.mapper.MenuMapper;
import com.xzg.wlxx.system.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author XiaoZG
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuPo> implements MenuService {

    @Override
    public boolean addMenu(MenuDto dto) {
        Assert.notBlank(dto.getCode(), "code不能为空");
        Assert.notBlank(dto.getName(), "name不能为空");
        Assert.notBlank(dto.getPath(), "path不能为空");
        return save(dto);
    }

    @Override
    public boolean updateMenu(MenuDto dto) {
        return updateById(dto);
    }

    @Override
    public List<MenuVo> listMenu() {
        var list = lambdaQuery()
                .orderByAsc(MenuPo::getMenuLevel)
                .orderByAsc(MenuPo::getSort)
                .list();
        var result = new ArrayList<MenuVo>();
        result.add(PojoConvertor.toVo(MenuVo.class, list.stream().findFirst().orElse(new MenuPo())));
        iterator(result, list);
        return result;
    }

    private void iterator(List<MenuVo> result, List<MenuPo> list) {
        result.forEach(e -> {
            var children = list.stream().filter(l -> Objects.equals(e.getId(), l.getMenuId()))
                    .map(l -> PojoConvertor.toVo(MenuVo.class, l)).toList();
            if (CollUtil.isNotEmpty(children)) {
                iterator(children, list);
            }
            e.setChildren(children);
        });
    }


}
