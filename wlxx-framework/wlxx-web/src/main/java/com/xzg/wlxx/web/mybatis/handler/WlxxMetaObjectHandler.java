package com.xzg.wlxx.web.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectionException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
            this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
            this.setFieldValByName("creator", "xzg", metaObject);
            this.setFieldValByName("isDelete", 0, metaObject);
        } catch (ReflectionException e) {
            // 没有字段映射时处理办法
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
            this.setFieldValByName("updater", "xzg", metaObject);
        } catch (ReflectionException e) {
            // 没有字段映射时处理办法
            throw new RuntimeException(e);
        }
    }


}
