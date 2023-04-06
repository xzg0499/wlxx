package com.xzg.wlxx.flowable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.flowable
 * @date 2022/11/17 15:37
 */
@SpringBootApplication
public class FlowableApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FlowableApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FlowableApplication.class);
    }

    //@Bean
    //public CommandLineRunner init(final RepositoryService repositoryService,
    //                              final RuntimeService runtimeService,
    //                              final TaskService taskService) {
    //
    //    return new CommandLineRunner() {
    //        @Override
    //        public void run(String... strings) throws Exception {
    //            System.out.println("Number of process definitions : "
    //                    + repositoryService.createProcessDefinitionQuery().count());
    //            System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
    //            runtimeService.startProcessInstanceByKey("oneTaskProcess");
    //            System.out.println("Number of tasks after process start: "
    //                    + taskService.createTaskQuery().count());
    //        }
    //    };
    //}
}
