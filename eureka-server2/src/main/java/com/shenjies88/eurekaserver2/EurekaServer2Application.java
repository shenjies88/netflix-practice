package com.shenjies88.eurekaserver2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @author shenjies88
 */
@Slf4j
@RestController
@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
public class EurekaServer2Application {

    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "helloFallback")
    @RequestMapping("/hello")
    public String hello() throws InterruptedException {
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);
        return "i'am server2";
    }

    public String helloFallback() {
        return "server2 circuit breaker";
    }

    @RequestMapping("/")
    public List<String> serviceUrl() {
        return discoveryClient.getServices();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer2Application.class);
        log.info("服务2启动");
    }
}