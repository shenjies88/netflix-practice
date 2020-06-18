package com.shenjies88.eurekaclient;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


/**
 * @author shenjies88
 * @since 2020/6/18-9:46 AM
 */
@Component
public class MyEurekaServerClientFallbackFactory implements FallbackFactory<MyEurekaServerClient> {

    @Override
    public MyEurekaServerClient create(Throwable throwable) {
        return new MyEurekaServerClient() {
            @Override
            public String hello() throws InterruptedException {
                return "服务熔断";
            }

            @Override
            public List<String> serviceUrl() {
                return Collections.emptyList();
            }
        };
    }
}
