package com.shenjies88.eurekagateway;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.shenjies88.eurekacommon.vo.HttpResultVo;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenjies88
 */
@RestController
public class ErrorHandlerController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public HttpResultVo error() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulException exception = (ZuulException) ctx.getThrowable();
        if (HttpStatus.UNAUTHORIZED.value() == exception.nStatusCode) {
            return HttpResultVo.failure(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
        } else {
            return HttpResultVo.failure("服务器繁忙");
        }
    }
}