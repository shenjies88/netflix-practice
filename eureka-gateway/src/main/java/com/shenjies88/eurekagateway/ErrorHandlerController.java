package com.shenjies88.eurekagateway;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.shenjies88.eurekacommon.vo.HttpResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenjies88
 */
@Slf4j
@RestController
public class ErrorHandlerController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public HttpResultVo error() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        if (throwable == null) {
            return HttpResultVo.failure(HttpStatus.NOT_FOUND.value(), "路径错误");
        }
        log.error("网关异常", throwable);
        if (throwable instanceof ZuulException) {
            ZuulException exception = (ZuulException) throwable;
            if (HttpStatus.UNAUTHORIZED.value() == exception.nStatusCode) {
                return HttpResultVo.failure(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
            }
        }
        return HttpResultVo.failure("服务器繁忙");
    }
}