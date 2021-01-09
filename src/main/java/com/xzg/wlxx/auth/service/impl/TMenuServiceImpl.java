package com.xzg.wlxx.auth.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.auth.domain.TMenu;
import com.xzg.wlxx.auth.mapper.TMenuMapper;
import com.xzg.wlxx.auth.service.ITMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-06
 */
@Service
public class TMenuServiceImpl extends ServiceImpl<TMenuMapper, TMenu> implements ITMenuService {
    @Autowired
    private TMenuMapper tMenuMapper;

    @Override
    public String select() {
        return tMenuMapper.select();
    }
}
