package com.xzg.wlxx.web.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectionException;
import org.springframework.stereotype.Component;

/**
 * @author xzgan
 * @datetime 2022/5/17 14:35
 * @package com.xzg.wlxx.system.handler
 */
@Component
public class WlxxMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            // 没有字段也不会报错
            this.setFieldValByName("createTime", System.currentTimeMillis(), metaObject);
            this.setFieldValByName("creator", 0L, metaObject);
            this.setFieldValByName("deleted", 0, metaObject);
        } catch (ReflectionException e) {
            // 没有字段映射时处理办法
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            this.setFieldValByName("updateTime", System.currentTimeMillis(), metaObject);
            this.setFieldValByName("updater", 0L, metaObject);
        } catch (ReflectionException e) {
            // 没有字段映射时处理办法
            throw new RuntimeException(e);
        }
    }


}
