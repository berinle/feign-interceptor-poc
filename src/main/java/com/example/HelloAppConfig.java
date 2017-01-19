package com.example;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class HelloAppConfig extends WebMvcConfigurerAdapter {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new HeaderInterceptor()).addPathPatterns("/**");
  }

  @Bean
  public RequestInterceptor requestIdFeignInterceptor() {
    return new RequestIdFeignInterceptor();
  }
}
