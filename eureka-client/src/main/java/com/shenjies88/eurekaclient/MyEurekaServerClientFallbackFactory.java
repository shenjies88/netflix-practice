package com.shenjies88.eurekaclient;

import com.shenjies88.eurekacommon.vo.HttpResultVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


/**
 * @author shenjies88
 * @since 2020/6/18-9:46 AM
 */
@Component
public class MyEurekaServerClientFallbackFactory implements FallbackFactory<MyEurekaServerClient> {

    @Override
    public MyEurekaServerClient create(Throwable throwable) {
        return new MyEurekaServerClient() {
            @Override
            public HttpResultVo<String> hello() throws InterruptedException {
                return HttpResultVo.success("服务熔断");
            }

            @Override
            public HttpResultVo serviceUrl() {
                return HttpResultVo.success();
            }
        };
    }
}
