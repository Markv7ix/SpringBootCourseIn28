package com.mv.javacert;

public class StringExcercises {

	public static String revertString(String s) {
		char [] array = s.toCharArray();
		char tmp = 0;
		for(int i = 0; i < array.length / 2; i++) {
			tmp = array[array.length - 1 - i];
			array[array.length - 1 - i] = array[i];
			array[i] = tmp;
		}	
		
		return String.valueOf(array);
	}
	
	
	public static void main(String[] args) {
		System.out.println(revertString("Melissa"));
		StringBuilder sb = new StringBuilder("Melissa");
		System.out.println(sb.reverse());
	}
}
