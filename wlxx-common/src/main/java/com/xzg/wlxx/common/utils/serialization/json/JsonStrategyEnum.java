package com.xzg.wlxx.common.utils.serialization.json;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/6/9
 */
public enum JsonStrategyEnum {
    NAME_CAMEL_CASE(new JsonKeyCamelCaseStrategy()),
    NAME_LOWER(new JsonKeyLowerStrategy()),
    NAME_UNDER_SCORE_CASE(new JsonKeyUnderScoreCaseStrategy()),
    NAME_UP(new JsonKeyUpStrategy());

    private JsonStrategy strategy;
    JsonStrategyEnum(JsonStrategy strategy){
        this.strategy = strategy;
    }

    public JsonStrategy getStrategy(){
        return this.strategy;
    }
}
