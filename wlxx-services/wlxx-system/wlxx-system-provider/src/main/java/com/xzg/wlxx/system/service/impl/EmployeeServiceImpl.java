package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.po.Employee;
import com.xzg.wlxx.system.mapper.EmployeeMapper;
import com.xzg.wlxx.system.service.IEmployeeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工 服务实现类
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
