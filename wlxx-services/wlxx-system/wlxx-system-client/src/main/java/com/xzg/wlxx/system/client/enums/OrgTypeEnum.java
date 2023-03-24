package com.xzg.wlxx.system.client.enums;

import lombok.Getter;

/**
 * 组织类型
 *
 * @author xzgan
 * @date 2023/3/24
 */
@Getter
public enum OrgTypeEnum {

    GROUP(1, "集团"),
    COMPANY(2, "公司"),
    DEPARTMENT(3, "部门"),

    ;

    private final Integer code;
    private final String desc;

    OrgTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
