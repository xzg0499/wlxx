# 基础镜像 若不存在会从仓库中下载
FROM java:8
#维护者信息
MAINTAINER LC
# 复制打包完成后的jar文件到/home目录下
ADD flower-0.0.1-SNAPSHOT.jar /home/flower-0.0.1-SNAPSHOT.jar
# 挂载/home/file目录到主机
#VOLUME 指向了一个/tmp的目录，由于 Spring Boot 使用内置的Tomcat容器，Tomcat 默认使用/tmp作为工作目录。
#这个命令的效果是：在宿主机的/var/lib/docker目录下创建一个临时文件并把它链接到容器中的/tmp目录
VOLUME /home/file
# 设置时区
RUN echo "Asia/Shanghai" > /etc/timezone
#暴漏8888端口
EXPOSE  8888
#bash方式执行，使flower-0.0.1-SNAPSHOT.jar可访问
# RUN新建立一层，在其基础上执行这些命令，执行结束后，commit这一层的修改，构成新的镜像
RUN bash -c 'touch /home/flower-0.0.1-SNAPSHOT.jar'
# 启动容器时执行
#为了缩短 Tomcat 的启动时间，添加java.security.egd的系统属性指向/dev/urandom作为 ENTRYPOINT
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/flower-0.0.1-SNAPSHOT.jar"]