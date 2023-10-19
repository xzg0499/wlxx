package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.dto.MenuDto;
import com.xzg.wlxx.system.client.entity.po.MenuPo;
import com.xzg.wlxx.system.client.entity.vo.MenuVo;

import java.util.List;

/**
 * @author XiaoZG
 */
public interface MenuService extends IService<MenuPo> {

    boolean addMenu(MenuDto dto);

    boolean updateMenu(MenuDto dto);

    List<MenuVo> listMenu();

}
