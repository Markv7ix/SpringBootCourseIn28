package com.mv.javacert;

public class FibonacciIterRecur {

	public static int fibonacciIter(int n) {
		
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		
		int [] buffer = {0, 1};
		int result = 0;
		for(int i = 2; i <= n; i++) {
			result = buffer[0] + buffer[1];
			buffer[0] = buffer[1];
			buffer[1] = result;
		}
		
		return result;
	}
	
	public static int fibonacciRecur(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		return fibonacciRecur(n -1) + fibonacciRecur(n - 2);
	}
	
	public static int fibonacci(int n) {
		return fibonacciRecur(n);
	}
	
	public static void main(String[] args) {
		int n = 1;
		System.out.println("Fibonacci(" + n + ")= " + fibonacci(n));
		n = 2;
		System.out.println("Fibonacci(" + n + ")= " + fibonacci(n));
		n = 3;
		System.out.println("Fibonacci(" + n + ")= " + fibonacci(n));
		n = 4;
		System.out.println("Fibonacci(" + n + ")= " + fibonacci(n));
		n = 5;
		System.out.println("Fibonacci(" + n + ")= " + fibonacci(n));
		n = 6;
		System.out.println("Fibonacci(" + n + ")= " + fibonacci(n));
	}
}
