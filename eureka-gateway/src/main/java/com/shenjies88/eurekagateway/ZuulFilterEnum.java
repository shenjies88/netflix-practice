package com.shenjies88.eurekagateway;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author shenjies88
 * @since 2020/6/18-3:09 PM
 */
@Getter
@AllArgsConstructor
public enum ZuulFilterEnum {

    /**
     * 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等
     */
    PRE("pre"),

    /**
     * 这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务
     */
    ROUTING("routing"),

    /**
     * 这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等
     */
    POST("post"),

    /**
     * 在其他阶段发生错误时执行该过滤器
     */
    ERROR("error");

    private final String type;
}
