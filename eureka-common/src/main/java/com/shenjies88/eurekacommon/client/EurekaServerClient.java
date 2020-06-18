package com.shenjies88.eurekacommon.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author shenjies88
 * @since 2020/6/17-6:21 PM
 */
@RequestMapping("/server")
public interface EurekaServerClient {

    /**
     * 测试接口
     *
     * @return hello
     * @throws InterruptedException
     */
    @GetMapping("/hello")
    String hello() throws InterruptedException;

    /**
     * 服务列表
     *
     * @return 服务列表
     */
    @GetMapping("/server-list")
    List<String> serviceUrl();
}
