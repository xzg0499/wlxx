package com.xzg.wlxx.system.client.feign;

import com.xzg.wlxx.system.client.entity.po.DictPo;
import com.xzg.wlxx.system.client.feign.failback.DictFallback;
import com.xzg.wlxx.web.config.FeignConfiguration;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author XiaoZG
 */
@FeignClient(name = "wlxx-system", contextId = "dictProvider", fallback = DictFallback.class, configuration = FeignConfiguration.class)
public interface DictProvider {

    @GetMapping("findByCode/{code}")
    @Operation(summary = "根据code查找字典")
    List<DictPo> findByCode(@PathVariable(value = "code") String code);
}
