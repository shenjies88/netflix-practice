package com.shenjies88.eurekaserver1;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shenjies88
 */
@Slf4j
@RestController
@EnableCircuitBreaker
@SpringBootApplication
public class EurekaServer1Application {

    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "helloFallback")
    @RequestMapping("/hello")
    public String hello() {
        return "i'am server1";
    }

    public String helloFallback() {
        return "server1 circuit breaker";
    }

    @RequestMapping("/")
    public List<String> serviceUrl() {
        return discoveryClient.getServices();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer1Application.class);
        log.info("服务1启动");
    }
}