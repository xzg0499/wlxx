package com.xzg.wlxx.flowable.controller;

import com.xzg.wlxx.core.base.BaseRes;
import com.xzg.wlxx.core.base.response.RestResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.flowable.controller
 * @date 2022/11/22 11:50
 */
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProcessController {

    private final RuntimeService runtimeService;

    private final TaskService taskService;

    @PostMapping("test")
    public RestResult test() {
        log.info("test");
        //ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //RuntimeService runtimeService = processEngine.getRuntimeService();
        //RepositoryService repositoryService = processEngine.getRepositoryService();
        //TaskService taskService = processEngine.getTaskService();
        //ManagementService managementService = processEngine.getManagementService();
        //IdentityService identityService = processEngine.getIdentityService();
        //HistoryService historyService = processEngine.getHistoryService();
        //FormService formService = processEngine.getFormService();
        //DynamicBpmnService dynamicBpmnService = processEngine.getDynamicBpmnService();
        return BaseRes.failure();
    }

}
