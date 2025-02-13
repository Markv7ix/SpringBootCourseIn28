package com.learn.java.lambdas;

import java.util.Comparator;

public class ComparatorLambdaExample {

	public static void main(String[] args) {
		
		/**
		 * Prior Java 8
		 */
		
		Comparator<Integer> comparator = new Comparator<>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		
		System.out.println("Result of the comparator is: " + comparator.compare(5, 3));
		
		/**
		 * Using lambdas
		 */
		Comparator<Integer> comparatorLambda = (o1, o2) -> o1.compareTo(o2);
		System.out.println("Result of comparator using lambda: " + comparatorLambda.compare(5, 3));
		
	}
}
