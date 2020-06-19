package com.shenjies88.eurekaserver;

import com.shenjies88.eurekacommon.client.EurekaServerClient;
import com.shenjies88.eurekacommon.vo.HttpResultVo;
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
@SpringBootApplication(scanBasePackages = {"com.shenjies88.eurekaserver", "com.shenjies88.eurekacommon.config", "com.shenjies88.eurekacommon.exception"})
public class EurekaServer1Application implements EurekaServerClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public HttpResultVo<String> hello() throws InterruptedException {
        int sleepTime = new Random().nextInt(4000);
        Thread.sleep(sleepTime);
        return HttpResultVo.success("i'am server2");
    }

    @Override
    public HttpResultVo<List<String>> serviceUrl() {
        return HttpResultVo.success(discoveryClient.getServices());
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer1Application.class);
        log.info("服务1启动");
    }
}