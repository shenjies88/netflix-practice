package com.shenjies88.eurekacommon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author shenjies88
 * @since 2020/6/18-3:19 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResultVo<T> {

    private Integer code;

    private T data;

    private String msg;

    public static <T> HttpResultVo success(T data) {
        return new HttpResultVo(HttpStatus.OK.value(), data, "success");
    }

    public static HttpResultVo success() {
        return new HttpResultVo(HttpStatus.OK.value(), null, "success");
    }

    public static HttpResultVo failure(String msg) {
        return new HttpResultVo(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, msg);
    }

    public static HttpResultVo failure(Integer code, String msg) {
        return new HttpResultVo(code, null, msg);
    }
}
