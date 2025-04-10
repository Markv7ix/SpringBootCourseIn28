package com.mv.javacert;

import java.time.Instant;
import java.util.Arrays;

public class FindMissingNumber {

	public static int findMissing(int[] input) {

		
		int n = input.length;
		int expected = n * (n + 1) / 2;
		
		int obtained = Arrays.stream(input).sum();
		
		return expected - obtained;
	}

	public static void main(String[] args) {

		int[] input = {5, 1, 2, 3, 6, 7, 4, 0};
		long start = Instant.now().toEpochMilli();
		System.out.println(findMissing(input));
		System.out.println(Instant.now().toEpochMilli() - start + " ms");
	}
}
