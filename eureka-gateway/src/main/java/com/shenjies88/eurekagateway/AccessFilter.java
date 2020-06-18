package com.shenjies88.eurekagateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shenjies88
 * @since 2020/6/18-3:08 PM
 */
@Slf4j
@Component
public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getHeader("access-token");
        if (accessToken == null) {
            log.warn("access token is empty");
            throw new ZuulException("令牌已失效，请重新登陆", HttpStatus.UNAUTHORIZED.value(), "access token is empty");
        }
        return null;
    }
}