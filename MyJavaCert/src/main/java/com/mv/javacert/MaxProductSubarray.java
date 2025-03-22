package com.mv.javacert;

import java.time.Instant;
import java.util.Arrays;

public class MaxProductSubarray {

	public static int maxProductSubArray(int[] input) {

		int min = input[0];
		int max = input[0];
		int maxProduct = input[0];

		for (int i = 1; i < input.length; i++) {
			int curByMin = min * input[i];
			int curByMax = max * input[i];
			max = Math.max(input[i], Math.max(curByMin, curByMax));
			maxProduct = Math.max(maxProduct, max);
			min = Math.min(input[i], Math.min(curByMin, curByMax));
		}

		System.out.println("MAx: " + max + "  Min: " + min);

		return maxProduct;
	}

	public static void main(String[] args) {

		int[] input = { 5, 3, 1, -2, 0, -5, 8, -3 };
		long start = Instant.now().toEpochMilli();
		System.out.println(maxProductSubArray(input));
		System.out.println(Instant.now().toEpochMilli() - start + " ms");
		
		input = Arrays.asList(2, 3, -2, 4).stream().mapToInt(n -> n).toArray();
		start = Instant.now().toEpochMilli();
		System.out.println(maxProductSubArray(input));
		System.out.println(Instant.now().toEpochMilli() - start + " ms");
	}
}
