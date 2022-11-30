package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.po.DepartmentPo;
import com.xzg.wlxx.system.mapper.DepartmentMapper;
import com.xzg.wlxx.system.service.IDepartmentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author xzgan
 * @since 2022-11-12
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, DepartmentPo> implements IDepartmentService {

}
