package com.example.speedtest.test;

import static org.junit.Assert.assertEquals;

import org.apache.catalina.connector.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.speedtest.rest.SpeedTestRestApi;

/**
 * @author Guruprakash
 *
 * This class has unit test cases for rest api's written in SpeedTestRestApi controller.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value=SpeedTestRestApi.class)
@WithMockUser
public class SpeedtestApplicationTests {

	@Autowired
	private MockMvc mockMvc;
		
	@Test
	public void sayHelloTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/").accept(MediaType.ALL_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "Hello";
		System.out.println(result.getResponse().getContentAsString());
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	
	@Test
	public void getSpeedTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/speedtest").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(Response.SC_FOUND, result.getResponse().getStatus());

	}
}
