package com.shenjies88.eurekagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author shenjies88
 * @since 2020/6/18-11:19 AM
 */
@EnableZuulProxy
@SpringBootApplication
public class EurekaGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaGatewayApplication.class);
    }
}
