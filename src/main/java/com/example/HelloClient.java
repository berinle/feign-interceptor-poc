package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("hello")
public interface HelloClient {

  @RequestMapping(value = "/greet", method = RequestMethod.GET)
  String hello();
}
