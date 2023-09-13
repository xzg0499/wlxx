package com.xzg.demo

import com.github.jsonzou.jmockdata.MockConfig

class BaseTests {

    companion object {
        var mockConfig = MockConfig.newInstance().excludes(
            "id", "createDate", "createBy", "updateDate", "updateBy"
        )
    }
}