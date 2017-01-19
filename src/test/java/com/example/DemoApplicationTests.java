package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "feign.hystrix.enabled=false")
public class DemoApplicationTests {

	@Autowired private HelloClient client;

	@Test
	public void test_can_invoke_client() {
	  assertEquals("hello", client.hello());
	}

}
