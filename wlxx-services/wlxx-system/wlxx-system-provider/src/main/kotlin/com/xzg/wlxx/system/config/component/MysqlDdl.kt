package com.xzg.wlxx.system.config.component

import com.baomidou.mybatisplus.extension.ddl.SimpleDdl
import org.springframework.util.ResourceUtils

//@Component
class MysqlDdl() : SimpleDdl() {

    override fun getSqlFiles(): MutableList<String> {
        val folder = ResourceUtils.getFile("classpath:db")
        val list: MutableList<String> = ArrayList()
        folder.walk().filter { it.isFile }
            .forEach { list.add(it.path) }
        return list
    }
}