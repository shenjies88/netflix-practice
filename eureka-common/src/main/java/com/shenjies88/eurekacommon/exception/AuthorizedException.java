package com.shenjies88.eurekacommon.exception;

/**
 * @author shenjies88
 * @since 2020/6/18-5:56 PM
 */
public class AuthorizedException extends RuntimeException {
    public AuthorizedException(String message) {
        super(message);
    }
}