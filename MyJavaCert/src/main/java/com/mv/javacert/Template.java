package com.mv.javacert;

import java.time.Instant;

public class Template {

	public static int solution(int [] input) {
		
		return 1;
	}
	
	
	public static void main(String[] args) {
		
		int [] input = {};
		long start = Instant.now().toEpochMilli();
		System.out.println(solution(input));
		System.out.println(Instant.now().toEpochMilli() - start + " ms");
	}
}
