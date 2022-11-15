package com.xzg.wlxx.org.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.org.entity.po.CompanyPo;
import com.xzg.wlxx.org.entity.vo.CompanyVo;

import java.util.List;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org.service
 * @date 2022/11/11 15:00
 */
public interface ICompanyService extends IService<CompanyPo> {

    List<CompanyVo> getAll();
}