package com.shenjies88.eurekaclient;

import com.shenjies88.eurekacommon.client.EurekaServerClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author shenjies88
 * @since 2020/6/17-6:21 PM
 */
@FeignClient(value = "eureka-server", fallbackFactory = MyEurekaServerClientFallbackFactory.class)
public interface MyEurekaServerClient extends EurekaServerClient {

}
