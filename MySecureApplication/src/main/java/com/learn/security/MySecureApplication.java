package com.learn.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.learn.security"})
public class MySecureApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySecureApplication.class, args);
	}

}
