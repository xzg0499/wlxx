package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.dto.DictDto;
import com.xzg.wlxx.system.client.entity.po.DictPo;

import java.util.List;

/**
 * @author XiaoZG
 */
public interface DictService extends IService<DictPo> {

    boolean add(DictDto dto);

    List<DictPo> findByCode(String code);

    IPage<DictPo> search(DictDto dto);
}
