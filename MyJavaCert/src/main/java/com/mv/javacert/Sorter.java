package com.mv.javacert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {

	public static void bubbleSort(int [] array) {
		
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				int tmp = 0;
				if(array[i] > array[j]) {
					tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		int [] test = {6, 4 ,3, 1, 9, 0, -1};
		bubbleSort(test);
		List<Integer> intList = Arrays.stream(test).boxed().collect(Collectors.toList());
		System.out.println(intList);
	}

}
