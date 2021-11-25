```shell
# 停止所有的容器
docker stop $(docker ps -a -q)
# 移除所有的容器
docker stop $(docker ps -a -q)
docker container prune
```
