package com.xzg.wlxx.system.client.feign.failback;

import com.xzg.wlxx.system.client.entity.po.TokenPo;
import com.xzg.wlxx.system.client.feign.TokenProvider;
import org.springframework.stereotype.Component;

@Component
public class TokenFallback implements TokenProvider {

    @Override
    public TokenPo findToken(TokenPo tokenPo) {
        return null;
    }

    @Override
    public Boolean saveOrUpdate(TokenPo po) {
        return false;
    }
}
