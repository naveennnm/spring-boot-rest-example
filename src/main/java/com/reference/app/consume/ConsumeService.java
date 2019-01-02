package com.reference.app.consume;

import org.springframework.web.client.RestTemplate;

import com.reference.app.entity.Greeting;

/**
 * 
 * @author Naveen
 *
 */
public class ConsumeService {

	public static final String REST_SERVICE_URI = "http://localhost:8080/";

	public static void testServiceGetDefaultValue() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(REST_SERVICE_URI + "greeting", String.class);
		System.out.println(response + " - testServiceGetDefaultValue");
	}

	public static void testServiceGetParamValue(String parmVal) {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(REST_SERVICE_URI + "greeting?name=" + parmVal, String.class);
		System.out.println(response + " - testServiceGetParamValue");
	}

	public static void testServiceGetPathValue() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(REST_SERVICE_URI + "greeting/{id}", String.class, 200);
		System.out.println(response + " - testServiceGetPathValue");
	}

	public static void testServicePost() {
		RestTemplate restTemplate = new RestTemplate();
		Greeting greeting = new Greeting();
		greeting.setId(011);
		greeting.setContent("WELCOME");
		System.out.println(greeting + "**********************");
		greeting = restTemplate.postForObject(REST_SERVICE_URI + "postGreeting", greeting, Greeting.class);
		System.out.println(greeting);
	}

	public static void testServicePut() {
		RestTemplate restTemplate = new RestTemplate();
		Greeting greeting = new Greeting();
		greeting.setId(011);
		greeting.setContent("WELCOME");
		restTemplate.put(REST_SERVICE_URI + "postGreeting", greeting);
	}

	public static void testServiceDelete(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "postGreeting" + id);
	}

	public static void main(String args[]) {
		ConsumeService.testServiceGetDefaultValue();
		ConsumeService.testServiceGetParamValue("USER ONE");
		ConsumeService.testServiceGetPathValue();
		ConsumeService.testServicePost();
		ConsumeService.testServicePut();
	}

}
