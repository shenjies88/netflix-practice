package com.shenjies88.eurekaconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author shenjies88
 * @since 2020/6/19-9:37 AM
 */
@EnableConfigServer
@SpringBootApplication
public class EurekaConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigServerApplication.class);
    }
}
