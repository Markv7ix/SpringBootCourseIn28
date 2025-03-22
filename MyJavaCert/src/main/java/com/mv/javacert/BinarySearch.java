package com.mv.javacert;

public class BinarySearch {

//	{1, 2, 3, 4, 5, 6}
	public static int binarySearch(int [] array, int dato) {
		
		int inicio = 0;
		int fin = array.length - 1;
		
		while(inicio <= fin) {
			int mitad = (fin + inicio) / 2;
			
			if(array[mitad] == dato) {
				return mitad;
			} else if(dato < array[mitad]) {
				fin = mitad - 1;
			} else {
				inicio = mitad + 1;
			}
		}
		return -1;
	}
	
	// {100, 50, 20, 10}  - 100
	public static int binarySearchInv(int [] array, int dato) {
		
		if(dato > array[0]) {
			return 0;
		}
		if(dato < array[array.length - 1]) {
			return array.length;
		}
		
		int inicio = 0;
		int fin = array.length - 1;
		
		int mitad = 0;
		while(inicio <= fin) {
			
			mitad = (fin + inicio) / 2;
			
			if(dato == array[mitad]) {
				return mitad;
			} else if(dato > array[mitad]) {
				fin = mitad - 1;
			} else {
				if(inicio == fin) {
					return 1;
				}
				inicio = mitad + 1;
			}
		}
		
		return mitad;
	}
	
	public static void main(String[] args) {
//		int [] array = {10, 20, 50, 100, 120};
//		int [] array = {1, 2, 4, 5, 7, 9, 11};
		int [] array = {100, 50, 20, 10};
//		for(int score : array) {
			System.out.println(binarySearchInv(array, 30));
//		}
	}
}
