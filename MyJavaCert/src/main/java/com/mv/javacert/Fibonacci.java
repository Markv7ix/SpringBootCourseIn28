package com.mv.javacert;

import java.util.List;

public class Fibonacci {
	
	public static int fibonacci(int n) {
		
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		
		int [] prev = {0, 1};
		
		int result = 0;
		for(int i = 2; i <= n; i++) {
			result = prev[0] + prev[1];
			prev[0] = prev[1];
			prev[1] = result;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		List<Integer> numbers =  List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		numbers.stream().forEach(n -> System.out.println("Fibonacci " + n + "= " + fibonacci(n)));
		
	}
	
}
