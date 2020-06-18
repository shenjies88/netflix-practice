package com.shenjies88.eurekaclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author shenjies88
 * @since 2020/6/18-9:29 AM
 */
@Slf4j
@RestControllerAdvice("com.shenjies88.eurekaclient")
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        log.error("通用异常", e);
        return "服务器繁忙";
    }
}
