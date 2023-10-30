package com.xzg.wlxx.system.client.feign.failback;

import com.xzg.wlxx.system.client.entity.po.DictPo;
import com.xzg.wlxx.system.client.feign.DictProvider;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author XiaoZG
 */
@Component
public class DictFallback implements DictProvider {
    @Override
    public List<DictPo> findByCode(String code) {
        return List.of();
    }
}
