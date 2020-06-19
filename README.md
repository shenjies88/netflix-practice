# Spring Cloud Netflix Practice

## 版本
- SpringBoot `2.2.8.RELEASE`
- SpringCloud `Hoxton.SR5`

## 项目说明

- eureka-registration-center 单例注册中心 端口`1111`
- eureka-gateway 服务网关 端口`5555`
- eureka-client 消费者 端口`8080`
- eureka-server1 服务实例1 端口`8081`
- eureka-server2 服务实例2 端口`8082`
- eureka-config-server 配置中心 端口`7001`
- eureka-common 公共定义
- [配置仓库](https://gitee.com/shenjies88/spring-cloud-config-repo.git)
## 使用模块

- eureka
- feign
- ribbon
- hystrix
- zuul
- config-server

## 主要逻辑

- 所有服务注册到eureka注册中心
- 网关作为唯一对外的服务
- 调用关系：`网关->消费者->服务`
- 除了`404`,所有异常均抛出`http200`，异常`code`由自定义业务`code`
- 配置写在 [配置仓库](https://gitee.com/shenjies88/spring-cloud-config-repo.git) 动态更新

## Jar包启动

### 打包

- `mvn install`
- `mvn clean package -DskipTests`

### 启动顺序

- `注册中心`->`配置中心`->`服务`->`消费者`->`网关`

## Docker启动

- `./boot`
- `1打包文件`
- `2启动`

![boot命令示意图](https://s1.ax1x.com/2020/06/18/NeXK39.png)

## 调用例子
- `http://localhost:5555/my-client/client/hello/`
- `http://localhost:5555/my-client/client/server-list`
