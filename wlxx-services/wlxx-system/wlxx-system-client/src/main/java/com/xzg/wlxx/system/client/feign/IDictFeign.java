package com.xzg.wlxx.system.client.feign;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzg.wlxx.common.core.response.Res;
import com.xzg.wlxx.system.client.entity.TDict;
import com.xzg.wlxx.system.client.feign.config.FeignConfig;
import com.xzg.wlxx.system.client.feign.impl.DictFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xzgan
 * @date 2022/6/8
 * @since jdk1.8
 */
@FeignClient(value = "wlxx-system",contextId = "dict",fallback = DictFeignImpl.class, configuration = FeignConfig.class)
public interface IDictFeign {

    /**
     * FIXME feign接口采用 Page.class类来代替IPage.class
     * @param dict
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/dict/queryByPage",headers = {"Content-Type=application/json;charset=UTF-8"})
    Res<Page<TDict>> queryByPage(@RequestBody TDict dict) throws Exception;
}
