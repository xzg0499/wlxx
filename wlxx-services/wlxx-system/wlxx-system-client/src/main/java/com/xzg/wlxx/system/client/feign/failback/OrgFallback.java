package com.xzg.wlxx.system.client.feign.failback;

import com.xzg.wlxx.system.client.feign.OrgProvider;

import java.util.HashMap;
import java.util.Map;

public class OrgFallback implements OrgProvider {

    @Override
    public Map<String, Object> test(Map<String, Object> map) {
        return new HashMap<>();
    }
}
