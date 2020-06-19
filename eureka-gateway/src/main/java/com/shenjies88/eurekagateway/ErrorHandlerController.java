package com.shenjies88.eurekagateway;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.shenjies88.eurekacommon.vo.HttpResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 针对业务异常
 *
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
    public ResponseEntity<HttpResultVo> error() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        if (throwable == null) {
            return new ResponseEntity(HttpResultVo.failure(HttpStatus.NOT_FOUND.value(), "网关路径错误"), HttpStatus.NOT_FOUND);
        }
        log.error("网关异常", throwable);
        if (throwable instanceof ZuulException) {
            ZuulException exception = (ZuulException) throwable;
            if (HttpStatus.UNAUTHORIZED.value() == exception.nStatusCode) {
                return new ResponseEntity(HttpResultVo.failure(HttpStatus.UNAUTHORIZED.value(), exception.getMessage()), HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpResultVo.failure("网关服务器繁忙"), HttpStatus.OK);
    }
}