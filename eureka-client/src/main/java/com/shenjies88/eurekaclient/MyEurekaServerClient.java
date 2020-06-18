package com.shenjies88.eurekaclient;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author shenjies88
 * @since 2020/6/17-6:21 PM
 */
@FeignClient(value = "eureka-server", fallbackFactory = MyEurekaServerClientFallbackFactory.class)
public interface MyEurekaServerClient extends com.shenjies88.eurekaserverapi.EurekaServerClient {

}
