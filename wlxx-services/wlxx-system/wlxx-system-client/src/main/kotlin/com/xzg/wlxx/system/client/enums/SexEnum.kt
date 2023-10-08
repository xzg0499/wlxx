package com.xzg.wlxx.system.client.enums

import com.baomidou.mybatisplus.annotation.EnumValue
import com.fasterxml.jackson.annotation.JsonValue

enum class SexEnum(@field:EnumValue private val code: Int?, @field:JsonValue private val desc: String?) {
    MAIL(0, "男"),
    FEMALE(1, "女"),
    NULL(null, null)
}
