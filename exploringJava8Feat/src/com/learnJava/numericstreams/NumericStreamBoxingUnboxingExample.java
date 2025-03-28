package com.learnJava.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnboxingExample {

	public static List<Integer> boxing() {

		return IntStream.rangeClosed(1, 10).boxed() // Stream<Integer>
				// all the elements will be passed one by one to get to the result as the
				// collection.
				.collect(Collectors.toList());

	}

	public static int unBoxing(List<Integer> integerList) {

		int sum = integerList.stream().mapToInt(Integer::intValue).sum();
		return sum;

	}

	public static void main(String[] args) {

		List<Integer> integerList = boxing();
		System.out.println("Converting PrimitiveStream to List : " + integerList);

		System.out.println("Sum using Unboding : " + unBoxing(integerList));

	}
}
