package com.mv.javacert;

class Solution {
	public static final char ZERO_CHAR = '0';
	public static final char NINE_CHAR = '9';
	public static final char A_CHAR = '1';

	public static void main(String[] args) {
		int i = atoi("123");
		System.out.println("I: " + i);
	}

	// Write a function to convert string to number without using Integer.parseInt()
	// method
	private static int atoi(String str) {
		int[] arr = new int[1000];
		// validte here its a number
		int cifras = 0;
		for (int i = 0; i < str.length(); i++) {
			
			char charAt = str.charAt(i);
			System.out.println("inside first: " + charAt);
			if (charAt <= NINE_CHAR && charAt >= ZERO_CHAR) {
				int toarray = charAt - ZERO_CHAR;
				arr[i] = toarray;
				System.out.println("inside second: " + toarray);
				cifras++;
			}
		}

		System.out.println("cifras: " + cifras);
		// getting correct value
		int multiplier = 1;
		int sum = 0;
		for (int i = cifras - 1; i >= 0; i--) {
			sum = sum + (arr[i] * multiplier);
			System.out.println("sum: " + sum);
			multiplier = multiplier * 10;
			System.out.println("multi: " + multiplier);
		}
		return sum;
	}
}
