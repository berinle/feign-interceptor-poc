package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

  @Autowired private HelloClient client;

  @GetMapping("/client")
  public String test() {
    System.out.println("ConsumerController.test");
    return client.hello();
  }
}
