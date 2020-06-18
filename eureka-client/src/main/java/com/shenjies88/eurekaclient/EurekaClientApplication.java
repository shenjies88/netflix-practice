package com.shenjies88.eurekaclient;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shenjies88
 */
@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RequestMapping("/eureka-client")
@RestController
public class EurekaClientApplication {

    @Autowired
    private MyEurekaServerClient myEurekaServerClient;

    @SneakyThrows
    @GetMapping("/hello")
    public String hello() {
        return myEurekaServerClient.hello();
    }


    @GetMapping("/server-list")
    public List<String> serviceList() {
        return myEurekaServerClient.serviceUrl();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class);
    }
}
