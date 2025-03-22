package com.in28minutes.rest.webservices.restfulwebservices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {

	private String message;
	
	private String user;
}
