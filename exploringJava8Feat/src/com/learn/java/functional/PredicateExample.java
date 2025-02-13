package com.learn.java.functional;

import java.util.function.Predicate;

public class PredicateExample {

	static private Predicate<Integer> isEven = (i) -> i % 2 == 0;
	static private Predicate<Integer> isDivisibleBy5 = (i) -> i % 5 == 0;
	
	
	public static void predicateAnd(int n) {
		System.out.println("PredicateAnd result of " + n + " is: " + isEven.and(isDivisibleBy5).test(n));
	}
	
	public static void predicateOr(int n) {
		System.out.println("PredicateOr result of " + n + " is: " + isEven.or(isDivisibleBy5).test(n));
	}
	
	public static void predicateNegate(int n) {
		System.out.println("PredicateNegate result of " + n + " is: " + isEven.or(isDivisibleBy5).negate().test(n));
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(isEven.test(4));
		
		predicateAnd(4);
		predicateAnd(10);
		predicateAnd(9);
		
		predicateOr(8);
		predicateOr(10);
		
		predicateNegate(8);
		predicateNegate(10);
		predicateNegate(9);
	}
}
