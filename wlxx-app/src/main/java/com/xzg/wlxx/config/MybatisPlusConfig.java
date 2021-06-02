package com.xzg.wlxx.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * mybatis 多数据源配置，自动映射到各自数据源的mapper上面
 * @Author: 肖志刚
 * @Date: 2020/7/6 19:59
 */
@Configuration
//@ConditionalOnClass(value = {SqlSessionFactory.class, SqlSessionFactoryBean.class})
public class MybatisPlusConfig {

//    弃用多数据源配置
//    @Configuration
//    @MapperScan(basePackages = {"com.xzg.wlxx.module.common.mapper"}, sqlSessionFactoryRef = "wlxxSqlSessionFactory")
//    public static class WlxxDatasource{
//        private final DataSource dataSource;
//
//        public WlxxDatasource(@Qualifier("wlxxDatasource") DataSource dataSource) {
//            this.dataSource = dataSource;
//        }
//
//        //创建SqlSessionFactory
//        @Bean
//        public SqlSessionFactory wlxxSqlSessionFactory() throws Exception {
//            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//            factoryBean.setDataSource(dataSource);
//            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                    .getResources("classpath*:/mapper/wlxx/*.xml"));
//            //factoryBean.setConfigLocation(new ClassPathResource("/mapper/mybatis-config.xml"));
//            return factoryBean.getObject();
//        }
//
//        @Bean
//        public SqlSessionTemplate wlxxSqlSessionTemplate() throws Exception {
//            return new SqlSessionTemplate(wlxxSqlSessionFactory());
//        }
//
//        //事务
//        @Bean
//        public PlatformTransactionManager wlxxTransactionManager() {
//            return new DataSourceTransactionManager(dataSource);
//        }
//    }
//
//    @Configuration
//    @MapperScan(basePackages = {"com.xzg.wlxx.user.mapper"}, sqlSessionFactoryRef = "userSqlSessionFactory")
//    public static class UserDatasource{
//        private final DataSource dataSource;
//
//        public UserDatasource(@Qualifier("userDatasource") DataSource dataSource) {
//            this.dataSource = dataSource;
//        }
//
//        @Bean
//        public SqlSessionFactory userSqlSessionFactory() throws Exception {
//            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//            factoryBean.setDataSource(dataSource);
//            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                    .getResources("classpath*:/mapper/user/*.xml"));
//            //factoryBean.setConfigLocation(new ClassPathResource("/mapper/mybatis-config.xml"));
//            return factoryBean.getObject();
//        }
//
//        @Bean
//        public SqlSessionTemplate userSqlSessionTemplate() throws Exception {
//            return new SqlSessionTemplate(userSqlSessionFactory());
//        }
//
//        //事务
//        @Bean
//        public PlatformTransactionManager userTransactionManager() {
//            return new DataSourceTransactionManager(dataSource);
//        }
//    }
//
//    @Configuration
//    @MapperScan(basePackages = {"com.xzg.wlxx.framework.mapper"}, sqlSessionFactoryRef = "frameworkSqlSessionFactory")
//    public static class FrameworkDatasource{
//        private final DataSource dataSource;
//
//        public FrameworkDatasource(@Qualifier("frameworkDatasource") DataSource dataSource) {
//            this.dataSource = dataSource;
//        }
//
//        @Bean
//        public SqlSessionFactory frameworkSqlSessionFactory() throws Exception {
//            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//            factoryBean.setDataSource(dataSource);
//            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                    .getResources("classpath*:/mapper/framework/*.xml"));
//            factoryBean.setTypeAliasesPackage("com.xzg.wlxx.framework.pojo.entity.*");
////            factoryBean.setTypeAliases(TDict.class);
//            //factoryBean.setConfigLocation(new ClassPathResource("/mapper/mybatis-config.xml"));
//            return factoryBean.getObject();
//        }
//
//        @Bean
//        public SqlSessionTemplate frameworkSqlSessionTemplate() throws Exception {
//            return new SqlSessionTemplate(frameworkSqlSessionFactory());
//        }
//
//        //事务
//        @Bean
//        public PlatformTransactionManager frameworkTransactionManager() {
//            return new DataSourceTransactionManager(dataSource);
//        }
//
//
//
//        /*FIXME 分页插件*/
//        @Bean
//        public PaginationInterceptor paginationInterceptor() {
//            PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//            // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
//            // paginationInterceptor.setOverflow(false);
//            // 设置最大单页限制数量，默认 500 条，-1 不受限制
//            // paginationInterceptor.setLimit(500);
//            // 开启 count 的 join 优化,只针对部分 left join
//            paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
//            return paginationInterceptor;
//        }
//    }
}
