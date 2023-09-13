package com.xzg.wlxx.system.entity.enums

import com.baomidou.mybatisplus.annotation.EnumValue
import com.fasterxml.jackson.annotation.JsonValue

enum class SexEnum(
    @EnumValue
    var code: Int?,
    @JsonValue
    var desc: String?
) {

    MAIL(0, "男"),
    FEMALE(1, "女"),
    NULL(null, null),
    ;

}