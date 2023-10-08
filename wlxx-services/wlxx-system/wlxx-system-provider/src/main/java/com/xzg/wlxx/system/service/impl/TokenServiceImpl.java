package com.xzg.wlxx.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.system.client.entity.po.TokenPo;
import com.xzg.wlxx.system.mapper.TokenMapper;
import com.xzg.wlxx.system.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author XiaoZG
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TokenServiceImpl extends ServiceImpl<TokenMapper, TokenPo> implements TokenService {

}
