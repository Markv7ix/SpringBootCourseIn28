package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.model.Tweet;

@RestController
public class HelloWorldController {

	@Autowired
	private InstanceInformationService instanceService;

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		// throw new RuntimeException("Some Error has Happened! Contact Support at
		// ***-***");
		return new HelloWorldBean("Hello World V1 ");
	}

	/// hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	@GetMapping(path = "/hello-world-bean-list")
	public List<HelloWorldBean> helloWorldBeanList() {
		return Collections.nCopies((new Random()).nextInt(1000),
					new HelloWorldBean("Hello World v2 " + instanceService.retrieveInstanceInfo()));
	}
	
	@GetMapping("/slow-service-tweets")
	private List<Tweet> getAllTweets() throws InterruptedException {
	    Thread.sleep(4000L); // delay
	    return Arrays.asList(
	      new Tweet("RestTemplate rules", "@user1"),
	      new Tweet("WebClient is better", "@user2"),
	      new Tweet("OK, both are useful", "@user1"));
	}
}
