package com.shenjies88.eurekaclient;

import com.shenjies88.eurekacommon.vo.HttpResultVo;
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

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shenjies88
 */
@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.shenjies88.eurekaclient", "com.shenjies88.eurekacommon.config", "com.shenjies88.eurekacommon.exception"})
@RequestMapping("/client")
@RestController
public class EurekaClientApplication {

    @Autowired
    private MyEurekaServerClient myEurekaServerClient;

    @SneakyThrows
    @GetMapping("/hello")
    public HttpResultVo<String> hello() {
        log.info("hello-list请求开始 {}", LocalDateTime.now());
        HttpResultVo<String> resultVo = myEurekaServerClient.hello();
        log.info("hello-list请求结束 {}", LocalDateTime.now());
        return resultVo;
    }


    @GetMapping("/server-list")
    public HttpResultVo<List<String>> serviceList() {
        log.info("server-list请求开始 {}", LocalDateTime.now());
        HttpResultVo<List<String>> resultVo = myEurekaServerClient.serviceUrl();
        log.info("server-list请求结束 {}", LocalDateTime.now());
        return resultVo;
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class);
    }
}
