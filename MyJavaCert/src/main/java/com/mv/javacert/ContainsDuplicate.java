package com.mv.javacert;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static boolean hasDuplicate(int [] array) {
		Set<Integer> noDuplicates = new HashSet<>();
		for(int i = 0; i < array.length; i++) {
			if(noDuplicates.contains(array[i])) {
				return true;
			} else {
				noDuplicates.add(array[i]);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int [] array = {1, 3, 2, 4, 2};
		System.out.println(hasDuplicate(array));
	}
}
