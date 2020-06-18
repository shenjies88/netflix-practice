# Spring Boot Netflix Practice

## 项目说明

- eureka-client 消费者
- eureka-gateway 服务网关
- eureka-registration-center 单例注册中心
- eureka-server1 服务实例1
- eureka-server2 服务实例2
- eureka-server-api API定义

## 使用模块

- eureka
- feign
- ribbon
- hystrix
- zuul

## 主要逻辑

- 所有服务注册到eureka注册中心
- 网关作为唯一对外的服务
- 调用关系:网关->消费者->服务

## Jar包启动

### 打包

- `mvn install`
- `mvn clean package -DskipTests`

### 启动顺序

![启动顺序图](https://s1.ax1x.com/2020/06/18/Ne2VRe.png)

## Docker启动

- `./boot`
- `1打包文件`
- `2启动`

![boot命令示意图](https://s1.ax1x.com/2020/06/18/NeXK39.png)

## 调用例子
- `http://localhost:5555/my-client/client/hello/`
- `http://localhost:5555/my-client/client/server-list`
