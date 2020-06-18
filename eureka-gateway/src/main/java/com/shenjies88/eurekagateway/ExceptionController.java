package com.shenjies88.eurekagateway;

import com.shenjies88.eurekacommon.vo.HttpResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author shenjies88
 * @since 2020/6/18-9:29 AM
 */
@Slf4j
@ResponseStatus(HttpStatus.OK)
@RestControllerAdvice("com.shenjies88.eurekagateway")
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public HttpResultVo exceptionHandler(Exception e) {
        log.error("通用异常", e);
        return HttpResultVo.failure("服务器繁忙");
    }
}
