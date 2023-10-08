package com.xzg.wlxx.system.config

import cn.zhxu.bs.BeanMeta
import cn.zhxu.bs.ParamFilter
import com.xzg.wlxx.common.base.BasePo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author XiaoZG
 */
@Configuration
class BeanSearcherConfiguration {
    @Bean
    fun myParamFilter(): ParamFilter {
        return object : ParamFilter {
            override fun <T> doFilter(beanMeta: BeanMeta<T>, paraMap: MutableMap<String, Any>): Map<String, Any> {
                // beanMeta 是正在检索的实体类的元信息, paraMap 是当前的检索参数
                // TODO: 这里可以写一些自定义的参数过滤规则
                val isSupper = BasePo::class.java.isAssignableFrom(beanMeta.beanClass)
                if (isSupper) {
                    paraMap["del"] = 0
                }
                return paraMap // 返回过滤后的检索参数
            }
        }
    }
}
