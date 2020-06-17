package com.shenjies88.eurekaclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author shenjies88
 */
@Slf4j
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
@RestController
public class EurekaClientApplication {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "helloFallBack")
    @GetMapping("/hello")
    public String hello() {
        return restTemplate.getForEntity("http://eureka-server/hello", String.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "helloFallBackSecond")
    public String helloFallBack() {
        return restTemplate.getForEntity("http://eureka-server/hello", String.class).getBody();
    }

    public String helloFallBackSecond(Throwable e) {
        log.info("异常", e);
        return "两次调用失败，熔断";
    }

    @GetMapping("/")
    public List<String> serviceUrl() {
        return discoveryClient.getServices();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class);
    }
}
