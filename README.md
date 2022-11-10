# wlxx

## 待办清单

- [ ] 微服务分布式，怎么处理事务？
- [ ] framework 模块怎么打包？
- [ ] 引入 flowable 流程引擎
- [ ] 整合 nacos 作为微服务框架
- [ ] 考虑选择 security 或者 shiro 授权框架
- [ ] 用单元测试代替测试脚本，来实现业务接口
- [ ] easyexcel 读写 excel：`com.alibaba:com.alibaba
- [ ] gradle 多模块依赖问题，待优化解决
- [x] gradle 跟 idea 编译输出目录不一致
    - 解决办法：采用 bootJar 的方式打包，并采用 gradle 编译，最后把没有 sprint boot 启动的模块过滤掉
- [ ] 采用 cglib 搭理实现三方接口请求，并做接口补偿
- [ ] gradle 不能使用 idea 自动编译功能
- [ ] RxJava 异步编程
- [ ] bean-searcher、fluent-mybatis 框架选择
- [ ] 独立 parent 模块，将所有共用到的外部依赖全部放入此处管理

## idae

### 待办标记

1. TODO 待办
2. FIXME 待完善

## mybatis-plus

1. mybatis-plus sql 加载优先级：xml > SqlProvider > crudsql
2. xml、SqlProvider、crudsql 允许出现同名的 sql，优先级高的有效

## gradle

### 打包 spring boot 使用 bootJar 指令打包

### gradle 多模块依赖问题，待优化解决

> 需要各个模块单独依赖到 common 包，并且 provideer 又需要单独依赖到 client

## 阿里云服务器（47.110.139.158）配置记录

### 分布式微服务

### Jenkins 自动化发布平台

### rancher 自动化构建平台、负载均衡平台

### MySQL 数据库

### Redis 缓存

### RabbiMQ 消息队列

## idea 问题记录

> idea command line is too long
> 修改`.idea\workspace.xml`目录文件
> 在`<component name=“PropertiesComponent”>`中添加`<property name="dynamic.classpath" value="true"/>`

# 丧心病狂，又开始重构了

# docker-compose.yml 文件会自动引入同目录下的`.env`文件的变量信息

# 对象关系

![img.png](/doc/images/img.png)

# 工具

```xml

<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>21.0</version>
</dependency>
```

# 源码包查询日志配置`additional-spring-configuration-metadata.json`