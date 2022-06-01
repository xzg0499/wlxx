# wlxx

## 待办清单
- [ ] 微服务分布式，怎么处理事务？
- [ ] framework模块怎么打包？
- [ ] 引入flowable流程引擎
- [ ] 整合nacos作为微服务框架
- [ ] 考虑选择security或者shiro授权框架
- [ ] 用单元测试代替测试脚本，来实现业务接口
- [ ] easyexcel读写excel：`com.alibaba:com.alibaba
- [ ] gradle多模块依赖问题，待优化解决
- [x] gradle跟idea编译输出目录不一致
  - 解决办法：采用bootJar的方式打包，并采用gradle编译，最后把没有sprint boot启动的模块过滤掉
- [ ] 采用cglib搭理实现三方接口请求，并做接口补偿

## idae
### 待办标记
1. TODO 待办
2. FIXME 待完善

## mybatis-plus
1. mybatis-plus sql加载优先级：xml > SqlProvider > crudsql
2. xml、SqlProvider、crudsql允许出现同名的sql，优先级高的有效

## gradle
### 打包spring boot使用bootJar指令打包
### gradle多模块依赖问题，待优化解决
> 需要各个模块单独依赖到common包，并且provideer又需要单独依赖到client

## 阿里云服务器（47.110.139.158）配置记录
### 分布式微服务
### Jenkins自动化发布平台
### rancher自动化构建平台、负载均衡平台
### MySQL数据库
### Redis缓存
### RabbiMQ消息队列

## idea 问题记录
> idea command line is too long
> 修改`.idea\workspace.xml`目录文件
> 在`<component name=“PropertiesComponent”>`中添加`<property name="dynamic.classpath" value="true"/>`


# 丧心病狂，又开始重构了