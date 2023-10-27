package com.xzg.wlxx.system.config;

import cn.hutool.core.util.StrUtil;
import cn.zhxu.bs.BeanMeta;
import cn.zhxu.bs.DbMapping;
import cn.zhxu.bs.ParamFilter;
import cn.zhxu.bs.boot.BeanSearcherProperties;
import cn.zhxu.bs.implement.DefaultDbMapping;
import cn.zhxu.bs.util.MapUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
                    Map<String, Object> map = MapUtils.builder()
                            .orderBy("createDate").desc()
                            .field("del", 0)
                            .build();
                    paraMap.putAll(map);
                }
                return paraMap;      // 返回过滤后的检索参数
            }
        };
    }

    /**
     * 兼容 mybatis plus orm 注解
     */
    @Bean
    public DbMapping mybatisPlusMapping(BeanSearcherProperties config) {
        var mapping = new DefaultDbMapping() {

            @Override
            public String toTableName(Class<?> beanClass) {
                // 识别 JPA 的 @Table 注解
                var table = beanClass.getAnnotation(TableName.class);
                if (table != null && StrUtil.isNotBlank(table.value())) {
                    return table.value();
                }
                return super.toTableName(beanClass);
            }

            @Override
            public String toColumnName(BeanField field) {
                // 识别 JPA 的 @Column 注解
                var column = field.getAnnotation(TableField.class);
                if (column != null && StrUtil.isNotBlank(column.value())) {
                    return column.value();
                }
                return super.toColumnName(field);
            }

        };

        BeanSearcherProperties.Sql.DefaultMapping conf = config.getSql().getDefaultMapping();
        mapping.setTablePrefix(conf.getTablePrefix());
        mapping.setUpperCase(conf.isUpperCase());
        mapping.setUnderlineCase(conf.isUnderlineCase());
        mapping.setRedundantSuffixes(conf.getRedundantSuffixes());
        mapping.setIgnoreFields(conf.getIgnoreFields());
        mapping.setDefaultInheritType(conf.getInheritType());
        mapping.setDefaultSortType(conf.getSortType());
        return mapping;
    }

}
