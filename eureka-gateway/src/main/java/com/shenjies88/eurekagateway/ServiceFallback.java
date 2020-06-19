package com.shenjies88.eurekagateway;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.shenjies88.eurekacommon.vo.HttpResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 针对Hystrix熔断
 *
 * @author shenjies88
 * @since 2020/6/19-9:45 AM
 */
@Slf4j
@Component
public class ServiceFallback implements FallbackProvider {

    private static final HttpResultVo RESULT = HttpResultVo.failure("");

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        log.error("网关熔断 ", cause);
        return cause instanceof HystrixTimeoutException ? response(HttpStatus.GATEWAY_TIMEOUT, "下游服务调用超时") : response(HttpStatus.OK, "下游服务器调用失败");
    }

    private ClientHttpResponse response(final HttpStatus status, String message) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
                RESULT.setMsg(message);
                RESULT.setCode(status.value());
                return new ByteArrayInputStream(JSON.toJSONBytes(RESULT));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
