package com.shenjies88.eurekaserver;

import com.shenjies88.eurekacommon.client.EurekaServerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @author shenjies88
 */
@Slf4j
@RestController
@SpringBootApplication
public class EurekaServer2Application implements EurekaServerClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public String hello() throws InterruptedException {
        int sleepTime = new Random().nextInt(4000);
        Thread.sleep(sleepTime);
        return "i'am server2";
    }

    @Override
    public List<String> serviceUrl() {
        return discoveryClient.getServices();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer2Application.class);
        log.info("服务2启动");
    }
}