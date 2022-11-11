package com.xzg.wlxx.org.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.org.entity.po.CompanyPo;
import com.xzg.wlxx.org.mapper.CompanyMapper;
import com.xzg.wlxx.org.service.ICompanyService;
import org.springframework.stereotype.Service;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org.service.impl
 * @date 2022/11/11 15:01
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyPo> implements ICompanyService {
}
