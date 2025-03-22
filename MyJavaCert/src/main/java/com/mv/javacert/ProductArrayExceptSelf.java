package com.mv.javacert;

import java.util.Arrays;

public class ProductArrayExceptSelf {

	public static int [] productExceptSelf(int [] input) {
		int pre = 1;
		int post = 1;
		int [] result = new int[input.length];
		Arrays.fill(result, 1);
		for(int i = 0; i < input.length; i++) {
			result[i] = pre * result[i]; //[1, 1, 2, 6]
			pre = pre * input[i];        // 1, 2, 6, 24
		}
		
		for(int i = input.length - 1; i >= 0; i--) {
			result[i] = post * result[i]; // [24, 12, 8, 6]
			post = post * input[i];       // 4, 12, 24 
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int [] input = {1, 2, 3, 4}; //[24, 12, 8, 6]
		int [] result = productExceptSelf(input);
		System.out.println(Arrays.stream(result).boxed().toList());
	}
}
