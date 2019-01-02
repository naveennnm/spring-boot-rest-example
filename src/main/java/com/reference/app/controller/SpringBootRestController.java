package com.reference.app.controller;

/**
 * 
 * @author Naveen
 *
 */
import org.springframework.web.bind.annotation.RestController;

import com.reference.app.entity.Greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class SpringBootRestController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	/**
	 * Get Mapping
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Spring Boot") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/greeting/{id}")
	public Greeting getGreetingWithPathVariable(@PathVariable(value = "id") Integer id) {
		String greetings = "WELCOME";
		return new Greeting(id, String.format(template, greetings));
	}

	/**
	 * Post Mapping
	 * 
	 * @param name
	 * @return
	 */
	@ResponseBody
	@CrossOrigin
	@PostMapping(value = "/postGreeting")
	public Greeting postGreeting(@RequestBody Greeting Greeting) {

		return Greeting;
	}

	/**
	 * Post Mapping
	 * 
	 * @param name
	 * @return
	 */
	@ResponseBody
	@CrossOrigin
	@PutMapping(value = "/putGreeting")
	public ResponseEntity<Greeting> updateEmployee(@PathVariable("id") int id, @RequestBody Greeting greeting) {
		System.out.println(id);
		System.out.println(greeting);
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}
}