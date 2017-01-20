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
@SpringBootTest(webEnvironment = RANDOM_PORT, properties = {"logging.level=INFO"})
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

}
