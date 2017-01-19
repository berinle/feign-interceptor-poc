package com.example;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderInterceptor extends HandlerInterceptorAdapter {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String header = request.getHeader("x-request-id");
    if (null == header || header.isEmpty()) {
      throw new RuntimeException("'x-request-id' is missing in the request headers");
    }

    return true;
  }
}
