package com.example;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class RequestIdFeignInterceptor implements RequestInterceptor {

  @Autowired
  ObjectProvider<HttpServletRequest> request;

  @Override
  public void apply(RequestTemplate template) {
    final String header = request.getObject().getHeader("x-request-id");
    template.header("x-request-id", header);
  }
}
