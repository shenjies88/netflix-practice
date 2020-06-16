package com.shenjies88.registration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author shenjies88
 */
@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class EurekaRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRegistrationApplication.class);
        log.info("注册中心启动");
    }
}