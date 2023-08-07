package com.xzg.wlxx.flowable;

import org.flowable.ui.admin.repository.ServerConfigRepository;
import org.flowable.ui.admin.service.engine.FlowableClientService;
import org.flowable.ui.common.repository.UuidIdGenerator;
import org.flowable.ui.common.tenant.TenantProvider;
import org.flowable.ui.modeler.repository.ModelHistoryRepository;
import org.flowable.ui.modeler.repository.ModelRelationRepository;
import org.flowable.ui.modeler.repository.ModelRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.flowable
 * @date 2022/11/17 15:37
 */
@SpringBootApplication(proxyBeanMethods = false)
@ComponentScan(nameGenerator = DefaultBeanNameGenerator.class, basePackages = {"org.flowable"}
        , excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {org.flowable.ui.idm.servlet.AppDispatcherServletConfiguration.class
        , org.flowable.ui.modeler.servlet.AppDispatcherServletConfiguration.class, org.flowable.ui.task.servlet.AppDispatcherServletConfiguration.class
        , FlowableClientService.class, ServerConfigRepository.class, UuidIdGenerator.class, ModelRepository.class, TenantProvider.class
        , ModelHistoryRepository.class, ModelRelationRepository.class
}))
public class FlowableApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FlowableApplication.class, args);
    }

    public static class SpringBeanNameGenerator implements BeanNameGenerator {
        @Override
        public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
            return null;
        }
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
