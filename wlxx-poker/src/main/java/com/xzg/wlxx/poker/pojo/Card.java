package com.xzg.wlxx.poker.pojo;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xzgang0499
 * @date 2022-04-22
 * @since jdk1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String digital;
    private String symbol;



    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
