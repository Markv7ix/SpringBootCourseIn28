package com.mv.javacert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
        List <Integer> result = new ArrayList<>();
        for(Integer n : grades) {
            if(n % 5 != 0) {
                int t = n / 5;
                int valueToProbe = (t + 1) * 5;
                if(valueToProbe - n < 3) {
                    result.add(valueToProbe);
                } else {
                    result.add(n);
                }
            } else {
                result.add(n);
            }
        }
        
        return result;
    }
	
	public static int [] sort(int [] array) {
		
		for(int i = 0; i < array.length; i++) {
			int tmp = 0;
			for(int j = 1 + i; j < array.length; j++) {
				if(array[i] > array[j]) {
					tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		int [] array = {32, 1, 5, -1, 8, 1};
		
		sort(array);
		
		List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
		System.out.println(list);
		
		System.out.println(4%5);
		
		List<Integer> listInt = Arrays.asList(4, 73, 67, 38, 33);
		System.out.println(gradingStudents(listInt));
	}
}
