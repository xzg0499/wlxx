package com.xzg.wlxx.flowable.demo;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @Author: 肖志刚
 * @Date: 2021/9/2 20:44
 */
public class HolidayRequest {
    public static void main(String[] args) throws ParseException {
        initFlowable();

//        String tmpDateExecuted = "2021-09-02 13:20:37";
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(df.parse((String) tmpDateExecuted));
    }

    public static void initFlowable(){
        //初始化flowable
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://localhost:3306/db_flowable?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true")
                .setJdbcUsername("root")
                .setJdbcPassword("xiao")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE);
        ProcessEngine processEngine = cfg.buildProcessEngine();

        //部署流程
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("flowable\\holiday-request.bpmn20.xml")
                .deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();
        System.out.println("Found process definition : " + processDefinition.getName());


//        Scanner scanner= new Scanner(System.in);
//
//        System.out.println("Who are you?");
//        String employee = scanner.nextLine();
//
//        System.out.println("How many holidays do you want to request?");
//        Integer nrOfHolidays = Integer.valueOf(scanner.nextLine());
//
//        System.out.println("Why do you need them?");
//        String description = scanner.nextLine();
    }
}
