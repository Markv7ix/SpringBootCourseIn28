package com.learnJava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

	public static int findMaxValue(List<Integer> list) {
		return list.stream().reduce(0, (x, y) -> x > y ? x : y);
	}
	
	public static Optional<Integer> findMaxValueOptional(List<Integer> list) {
		return list.stream().reduce((x, y) -> x > y ? x : y);
	}
	
	public static int findMinValue(List<Integer> list) {
		return list.stream().reduce(0, (x, y) -> x < y ? x : y);
	}
	
	public static Optional<Integer> findMinValueOptional(List<Integer> list) {
		return list.stream().reduce((x, y) -> x < y ? x : y);
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 6, 7, 8, 9, 10);
		List<Integer> emptyList = new ArrayList<>();
//		System.out.println("Max value : " + findMaxValue(list));
//		Optional<Integer> maxValue = findMaxValueOptional(new ArrayList<>());
//		System.out.println("Max value using Optional : " + (maxValue.isPresent() ? maxValue.get() : "No value found"));
		System.out.println("Min value : " + findMinValue(emptyList));
		Optional<Integer> minValue = findMinValueOptional(emptyList);
		System.out.println("Min value using Optional : " + (minValue.isPresent() ? minValue.get() : "No value found"));
	}
}
