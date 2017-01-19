package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	public void test_can_invoke_client() {
      HttpHeaders headers = new HttpHeaders();
      headers.set("x-request-id", "abc");
      HttpEntity<String> entity = new HttpEntity<>(null, headers);
      ResponseEntity<String> response = restTemplate.exchange("/greet", HttpMethod.GET, entity, String.class);
      assertEquals("hello", response.getBody());
    }

}
