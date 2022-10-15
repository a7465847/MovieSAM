package helloworld;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import ch.qos.logback.classic.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("unused")
public class AppTest {
//  @Test
//  public void successfulResponse() {
//    App app = new App();
//    APIGatewayProxyResponseEvent result = app.handleRequest(null, null);
//    assertEquals(200, result.getStatusCode().intValue());
//    assertEquals("application/json", result.getHeaders().get("Content-Type"));
//    String content = result.getBody();
//    assertNotNull(content);
//    assertTrue(content.contains("\"message\""));
//    assertTrue(content.contains("\"hello world\""));
//    assertTrue(content.contains("\"location\""));
//  }
  
	@Test
	void testMovieApi() {
		Map<String, Object> map = new HashMap<>();
	    RestTemplate restTemplate = new RestTemplate();
	    String url =  "https://api.themoviedb.org/3/search/movie?api_key={apiKey}&language=zh-TW&query={query}&page=1&include_adult=false";
	    map.put("apiKey", "16adb0520b62e4724d8946faca7e4f8c");
	    map.put("query", "海角七號");

	    ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, map);
	    System.out.println( responseEntity.getBody());
	}
}
