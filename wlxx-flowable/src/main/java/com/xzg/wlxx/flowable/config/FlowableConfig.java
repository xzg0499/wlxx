package com.xzg.wlxx.flowable.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.flowable.common.engine.impl.cfg.CommandExecutorImpl;
import org.flowable.common.engine.impl.interceptor.*;
import org.flowable.common.engine.impl.service.CommonEngineServiceImpl;
import org.flowable.common.engine.impl.util.DefaultClockImpl;
import org.flowable.engine.*;
import org.flowable.engine.impl.ProcessEngineImpl;
import org.flowable.engine.impl.RepositoryServiceImpl;
import org.flowable.engine.impl.RuntimeServiceImpl;
import org.flowable.engine.impl.TaskServiceImpl;
import org.flowable.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2021/9/3
 */

@Configurable
@Component
public class FlowableConfig {

    @Bean("processEngineConfigurationImpl")
    public ProcessEngineConfiguration processEngineConfiguration(){
        ProcessEngineConfiguration processEngineConfiguration = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://localhost:3306/db_flowable?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC")
                .setJdbcUsername("root")
                .setJdbcPassword("xiao")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        return processEngineConfiguration;
    }

    @Bean
    public ProcessEngine processEngine(@Qualifier("processEngineConfigurationImpl")ProcessEngineConfiguration processEngineConfiguration){
        return processEngineConfiguration.buildProcessEngine();
    }

    @Bean
    public RepositoryService repositoryService(@Qualifier("processEngine")ProcessEngine processEngine){
        return processEngine.getRepositoryService();
    }

    @Bean("runtimeService")
    public RuntimeService runtimeService(@Qualifier("processEngine")ProcessEngine processEngine){
        return processEngine.getRuntimeService();
    }

    @Bean
    public TaskService taskService(@Qualifier("processEngine")ProcessEngine processEngine){
        return processEngine.getTaskService();
    }

    @Bean
    public HistoryService historyService(@Qualifier("processEngine")ProcessEngine processEngine){
        return processEngine.getHistoryService();
    }

//    @Bean
//    public CommandLineRunner init(@Qualifier("repositoryService")final RepositoryService repositoryService,
//                                  @Qualifier("runtimeService")final RuntimeService runtimeService,
//                                  @Qualifier("taskService")final TaskService taskService) {
//
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... strings) throws Exception {
//                System.out.println("Number of process definitions : "
//                        + repositoryService.createProcessDefinitionQuery().count());
//                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//                runtimeService.startProcessInstanceByKey("holidayRequest");
//                System.out.println("Number of tasks after process start: "
//                        + taskService.createTaskQuery().count());
//            }
//        };
//    }
}
