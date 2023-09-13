package com.xzg.wlxx.system.config.component

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import com.xzg.wlxx.system.base.Slf4j.Companion.logger
import org.apache.ibatis.reflection.MetaObject
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class MyMetaObjectHandler() : MetaObjectHandler {
    override fun insertFill(metaObject: MetaObject?) {
        logger.info("auto insert")
        this.strictInsertFill(metaObject, "createDate", LocalDateTime::class.java, LocalDateTime.now())
        this.strictInsertFill(metaObject, "createBy", String::class.java, "xzg")

    }

    override fun updateFill(metaObject: MetaObject?) {
        logger.info("auto update")
        this.strictUpdateFill(metaObject, "updateDate", LocalDateTime::class.java, LocalDateTime.now())
        this.strictUpdateFill(metaObject, "updateBy", String::class.java, "xzg")
    }

}