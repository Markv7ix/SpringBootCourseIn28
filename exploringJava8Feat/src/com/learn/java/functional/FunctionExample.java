package com.learn.java.functional;

import java.util.function.Function;

public class FunctionExample {

	static Function<String, String> functionUpperCase = (name) -> name.toUpperCase();
	static Function<String, String> functionAddSomeString = (name) -> name.toUpperCase().concat("default");
	
	public static void main(String[] args) {
		System.out.println("Result is: " + functionUpperCase.apply("java8"));
		System.out.println("Result of and then is: " + functionAddSomeString.apply("java8"));
		System.out.println("Result of compose is: " + functionUpperCase.compose(functionAddSomeString).apply("java8"));
	}
}
