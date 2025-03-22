package com.in28minutes.rest.webservices.restfulwebservices;

import java.net.URISyntaxException;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
public class HelloWorldController {

	private static final String SLOW_SERVICE_TWEETS_URI = "http://localhost:8080/slow-service-tweets";
	private CountriesServices countriesService;

	public HelloWorldController(CountriesServices countriesService) {
		this.countriesService = countriesService;
	}

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		// throw new RuntimeException("Some Error has Happened! Contact Support at
		// ***-***");
		return new HelloWorldBean("Hello World");
	}

	/// hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	@GetMapping(path = "/getCountries")
	public List<String> getCountries() throws URISyntaxException {

		return countriesService.getCountries();
	}

	@GetMapping("/tweets-blocking")
	public List<Tweet> getTweetsBlocking() {
		log.info("Starting BLOCKING Controller!");
		final String uri = SLOW_SERVICE_TWEETS_URI;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Tweet>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Tweet>>() {
				});

		List<Tweet> result = response.getBody();
		result.forEach(tweet -> log.info(tweet.toString()));
		log.info("Exiting BLOCKING Controller!");
		return result;
	}

	@GetMapping(value = "/tweets-non-blocking", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tweet> getTweetsNonBlocking() {
		log.info("Starting NON-BLOCKING Controller!");
		Flux<Tweet> tweetFlux = WebClient.create().
				get().uri(SLOW_SERVICE_TWEETS_URI).
				retrieve().bodyToFlux(Tweet.class);

		tweetFlux.subscribe(tweet -> log.info(tweet.toString()));
		log.info("Exiting NON-BLOCKING Controller!");
		return tweetFlux;
	}

}
