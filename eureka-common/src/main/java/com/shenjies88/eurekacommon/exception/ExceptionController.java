package com.shenjies88.eurekacommon.exception;

import com.shenjies88.eurekacommon.vo.HttpResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shenjies88
 * @since 2020/6/18-9:29 AM
 */
@Slf4j
@ResponseStatus(HttpStatus.OK)
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public HttpResultVo httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        log.error("请求方法异常", e);
        return HttpResultVo.failure(HttpStatus.METHOD_NOT_ALLOWED.value(), "请求方法不正确");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public HttpResultVo noHandlerFoundExceptionHandler(NoHandlerFoundException e) {
        log.error("路径错误", e);
        return HttpResultVo.failure(HttpStatus.NOT_FOUND.value(), "路径错误");
    }

    @ExceptionHandler(Exception.class)
    public HttpResultVo exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("通用异常", e);
        return HttpResultVo.failure("服务器繁忙");
    }

}
