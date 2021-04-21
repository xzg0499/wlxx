package com.xzg.wlxx;

import com.xzg.wlxx.auth.domain.TUser;
import com.xzg.wlxx.framework.model.AjaxResult;
import com.xzg.wlxx.module.entity.TDict;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WlxxApplicationTests {
	@LocalServerPort
	private int port;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private TestRestTemplate restTemplate;

	private static URL baseUrl;

	@BeforeAll
	public void setBaseUrl() throws Exception{
		String url = String.format("http://localhost:%d",port);
		baseUrl = new URL(url);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testHellAuth() throws Exception{
		ResponseEntity<AjaxResult> response = restTemplate.getForEntity(baseUrl.toString()+"/helloAuth", AjaxResult.class);
		System.out.println(response.getBody());
	}

	@Test
	void testSelectAuth(){
		ResponseEntity<AjaxResult> response = restTemplate.postForEntity(baseUrl.toString()+"/query", new TUser(), AjaxResult.class);
		System.out.println(response.getBody());
	}

	@Test
	void testSelectDict(){
		ResponseEntity<AjaxResult> response = restTemplate.postForEntity(baseUrl.toString()+"/dict/query", new TDict(), AjaxResult.class);
		System.out.println(response.getBody());
	}
	@Test
	void testAddict(){
		ResponseEntity<AjaxResult> response = restTemplate.postForEntity(baseUrl.toString()+"/dict/add", new TDict(), AjaxResult.class);
		System.out.println(response.getBody());
	}

}
