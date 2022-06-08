package com.xzg.wlxx.system.client.feign.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzg.wlxx.common.core.base.BaseRes;
import com.xzg.wlxx.common.core.response.Res;
import com.xzg.wlxx.system.client.entity.TDict;
import com.xzg.wlxx.system.client.feign.IDictFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xzgan
 * @date 2022/6/8
 * @since jdk1.8
 */
@Slf4j
@Component
public class DictFeignImpl implements IDictFeign {

    @Override
    public Res<Page<TDict>> queryByPage(TDict dict) throws Exception {
        return BaseRes.failure();
    }
}
