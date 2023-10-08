package com.xzg.wlxx.web.config.mybatisplus.component

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import com.xzg.wlxx.common.log.WlxxLog.Companion.log
import lombok.extern.slf4j.Slf4j
import org.apache.ibatis.reflection.MetaObject
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
@Slf4j
class WlxxMetaObjectHandler : MetaObjectHandler {
    override fun insertFill(metaObject: MetaObject) {
        log.info("auto insert")
        this.strictInsertFill(metaObject, "createDate", LocalDateTime::class.java, LocalDateTime.now())
        this.strictInsertFill(metaObject, "createBy", String::class.java, "xzg")
    }

    override fun updateFill(metaObject: MetaObject) {
        log.info("auto update")
        this.strictUpdateFill(metaObject, "updateDate", LocalDateTime::class.java, LocalDateTime.now())
        this.strictUpdateFill(metaObject, "updateBy", String::class.java, "xzg")
    }
}
