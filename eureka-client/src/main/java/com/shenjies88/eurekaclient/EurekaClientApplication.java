package com.shenjies88.eurekaclient;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shenjies88
 */
@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private EurekaServerClient eurekaServerClient;

    @SneakyThrows
    @GetMapping("/hello")
    public String hello() {
        return eurekaServerClient.hello();
    }


    @GetMapping("/")
    public List<String> serviceUrl() {
        return discoveryClient.getServices();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class);
    }
}
