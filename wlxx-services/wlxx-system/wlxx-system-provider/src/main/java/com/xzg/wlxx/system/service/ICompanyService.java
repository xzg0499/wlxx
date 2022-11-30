package com.xzg.wlxx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.system.client.entity.po.CompanyPo;
import com.xzg.wlxx.system.client.entity.vo.CompanyVo;

import java.util.List;

/**
 * <p>
 * 公司 服务类
 * </p>
 *
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org.service
 * @date 2022/11/11 15:00
 */
public interface ICompanyService extends IService<CompanyPo> {

    /**
     * 获取所有的企业
     */
    List<CompanyVo> getAll();
}
