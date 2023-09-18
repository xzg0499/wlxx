package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.po.Org;
import com.xzg.wlxx.system.client.entity.vo.OrgVo;
import com.xzg.wlxx.system.mapper.OrgMapper;
import com.xzg.wlxx.system.service.OrgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements OrgService {
    @Override
    public Boolean insertOrUpdate(Org org) {
        return null;
    }

    @Override
    public List<OrgVo> list4Tree() {
        return null;
    }
}
