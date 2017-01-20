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

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT, properties = {"logging.level=INFO", "server.port=8080"})
public class DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private HelloClient client;

	@Test
	public void test_bypass_client() {
      HttpHeaders headers = new HttpHeaders();
      headers.set("x-request-id", "abc");
      HttpEntity<String> entity = new HttpEntity<>(null, headers);
      ResponseEntity<String> response = restTemplate.exchange("/greet", HttpMethod.GET, entity, String.class);
      assertEquals("hello", response.getBody());
    }

  @Test
  public void test_through_client() throws Exception {
	 assertEquals("hello", client.hello());
  }

  @Test
  public void test_client_through_controller() throws Exception {
    HttpHeaders headers = new HttpHeaders();
    headers.set("x-request-id", UUID.randomUUID().toString());
    HttpEntity<String> entity = new HttpEntity<>(null, headers);
    ResponseEntity<String> response = restTemplate.exchange("/client", HttpMethod.GET, entity, String.class);
    assertEquals("hello", response.getBody());
  }
}
