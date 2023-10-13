package com.xzg.wlxx.web.config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import com.xzg.wlxx.common.base.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.Set;

/**
 * @author XiaoZG
 */
@Component
@Slf4j
public class WlxxErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);


        Set<String> strings = errorAttributes.keySet();
        for (String it : strings) {
            Object o = errorAttributes.get(it);
            log.info("key : {} value: {}", it, o);
        }
        var result = ApiResult.builder()
                .code(MapUtil.getInt(errorAttributes, "status"))
                .msg(MapUtil.getStr(errorAttributes, "message", "")
                        + " " + MapUtil.getStr(errorAttributes, "error", "")
                        + " " + MapUtil.getStr(errorAttributes, "path", "")
                )
                .build();

        return BeanUtil.beanToMap(result);
    }
}

