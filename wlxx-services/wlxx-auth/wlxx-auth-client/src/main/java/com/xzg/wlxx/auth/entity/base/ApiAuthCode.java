package com.xzg.wlxx.auth.entity.base;

import lombok.Getter;

/**
 * @author XiaoZG
 */
@Getter
public enum ApiAuthCode {
    UN_LOGIN(401, "未登录"),
    LOGOUT_SUCCEED(200, "登出成功"),
    TOKEN_ERROR(500, "access_token 错误"),
    NO_AUTH(403, "您的权限不足"),
    ;

    public final Integer code;
    public final String msg;

    ApiAuthCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static void main(String[] args) {
        System.out.println(ApiAuthCode.UN_LOGIN.code);
    }

}
