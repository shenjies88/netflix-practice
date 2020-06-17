package com.shenjies88.eurekaclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shenjies88
 * @since 2020/6/17-6:21 PM
 */
@FeignClient("eureka-server")
public interface EurekaServerClient {

    @GetMapping("/hello")
    String hello() throws InterruptedException;
}
