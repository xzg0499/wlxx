package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.po.OrgPo;
import com.xzg.wlxx.system.client.entity.vo.OrgVo;

import java.util.List;

public interface OrgService extends IService<OrgPo> {

    Boolean add(OrgPo org);

    List<OrgVo> list4Tree(Long rootId);
}
