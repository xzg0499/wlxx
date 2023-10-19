package com.xzg.wlxx.system.client.entity.vo;

import com.xzg.wlxx.system.client.entity.po.MenuPo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author XiaoZG
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuVo extends MenuPo {
    private List<MenuVo> children;
}
