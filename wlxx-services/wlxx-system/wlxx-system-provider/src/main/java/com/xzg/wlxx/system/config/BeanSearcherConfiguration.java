package com.xzg.wlxx.system.config;

import cn.zhxu.bs.BeanMeta;
import cn.zhxu.bs.ParamFilter;
import com.xzg.wlxx.common.base.BasePo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author XiaoZG
 */
@Configuration
public class BeanSearcherConfiguration {

    @Bean
    public ParamFilter myParamFilter() {
        return new ParamFilter() {
            @Override
            public <T> Map<String, Object> doFilter(BeanMeta<T> beanMeta, Map<String, Object> paraMap) {
                // beanMeta 是正在检索的实体类的元信息, paraMap 是当前的检索参数
                // TODO: 这里可以写一些自定义的参数过滤规则
                boolean isSupper = BasePo.class.isAssignableFrom(beanMeta.getBeanClass());
                if (isSupper) {
                    paraMap.put("del", 0);
                }
                return paraMap;      // 返回过滤后的检索参数
            }
        };
    }

}
