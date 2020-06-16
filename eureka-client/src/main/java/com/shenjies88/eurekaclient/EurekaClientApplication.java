package com.shenjies88.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author shenjies88
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String hello() {
        return restTemplate.getForEntity("http://eureka-server/hello", String.class).getBody();
    }

    @GetMapping("/")
    public List<String> serviceUrl() {
        return discoveryClient.getServices();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class);
    }
}
