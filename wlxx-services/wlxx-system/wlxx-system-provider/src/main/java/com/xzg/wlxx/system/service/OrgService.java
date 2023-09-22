package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.po.Org;
import com.xzg.wlxx.system.client.entity.vo.OrgVo;

import java.util.List;

public interface OrgService extends IService<Org> {

    Boolean add(Org org);

    List<OrgVo> list4Tree(Long rootId);
}
