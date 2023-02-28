package com.xzg.wlxx.core.utils;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.Optional;

/**
 * @auth xzgan
 * @datetime 2022/5/15 10:16
 */
public class JsonUtil {

    public static <T extends Object> T getJsonStrByXpath(JSONObject json, String xPath, Class<T> cls) throws Exception {
        String[] keys = xPath.replaceAll("(/[^/]*$)|(^/)", "").split("/");
        String key = xPath.replaceAll("^.*/", "");

        Optional<JSONObject> optional = Optional.ofNullable(json);
        for (String s : keys) {
            if (StrUtil.isBlank(s)) {
                continue;
            }
            if (s.matches(".*\\[\\d\\]")) {
                String iKey = s.replaceAll("(\\[\\d*\\])", "");
                String iIndex = s.replaceAll("(.*\\[)|(\\])", "");
                int index = Integer.parseInt(iIndex);
                optional = optional.flatMap(e -> Optional.ofNullable(e.getJSONArray(iKey)))
                        .flatMap(e -> Optional.ofNullable(e.getJSONObject(index)));
            } else {
                optional = optional.flatMap(e -> Optional.ofNullable(e.getJSONObject(s)));
            }
        }
        // 取末节点值
        Optional<Object> valueOptional = Optional.ofNullable(null);
        if (key.matches(".*\\[\\d\\]")) {
            String iKey = key.replaceAll("(\\[\\d*\\])", "");
            String iIndex = key.replaceAll("(.*\\[)|(\\])", "");
            int index = Integer.parseInt(iIndex);
            valueOptional = optional.flatMap(e -> Optional.ofNullable(e.getJSONArray(iKey)))
                    .flatMap(e -> Optional.ofNullable(e.get(index)));
        } else {
            valueOptional = optional.map(e -> e.get(key));
        }
        if (valueOptional.isPresent()) {
            Object obj = valueOptional.orElse(null);
            if (obj.getClass().equals(cls)) {
                return (T) obj;
            }
        }
        return cls.newInstance();
    }
}
