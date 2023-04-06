package com.xzg.wlxx.liteflow.controller;

import cn.hutool.json.JSONUtil;
import com.xzg.wlxx.core.base.ApiResult;
import com.xzg.wlxx.core.base.response.RestApiResult;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.liteflow.controller
 * @date 2022/12/28 9:30
 */
@RestController
public class DemoController {

    @Autowired
    FlowExecutor flowExecutor;

    @GetMapping("test")
    public RestApiResult test() {
        LiteflowResponse resp = flowExecutor.execute2Resp("chain2", "arg");
        return ApiResult.success(JSONUtil.toJsonStr(resp));
    }
}
