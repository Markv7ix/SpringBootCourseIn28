package com.in28minutes.rest.webservices.restfulwebservices;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountriesServices {

	@Value("${services.countries.url}")
	private String countriesUrl;
	
	public List<String> getCountries() throws URISyntaxException {
		URI uri = new URI(countriesUrl);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object[]> respEntity= restTemplate.getForEntity(uri, Object[].class);
		Object [] response = respEntity.getBody();
		return Arrays.stream(response).map((o) -> {
			return o instanceof String ? (String) o : o.toString();})
		.collect(Collectors.toList());
	}
}
