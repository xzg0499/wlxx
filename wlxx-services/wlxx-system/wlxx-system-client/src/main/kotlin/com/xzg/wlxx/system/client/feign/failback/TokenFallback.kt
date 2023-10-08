package com.xzg.wlxx.system.client.feign.failback

import com.xzg.wlxx.system.client.entity.po.TokenPo
import com.xzg.wlxx.system.client.feign.TokenProvider

class TokenFallback : TokenProvider {
    override fun findToken(tokenPo: TokenPo?): TokenPo? {
        return null
    }

    override fun saveOrUpdate(po: TokenPo?): Boolean {
        return false
    }
}
