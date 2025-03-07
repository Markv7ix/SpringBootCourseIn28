package com.mv.ehealth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Interview {
	public static void main(String[] args) {
//		int[] a = new int[] { 2, 5, 6, 7 };
//		int[] b = new int[] { 8, 16, 19, 20 };

		int[] a = new int[] { 2, 4, 6, 7, 10 };
		int[] b = new int[] { 3, 5, 16, 19, 20 };

		// System.out.println(new ArrayList<>());

		Arrays.stream(merge(a, b)).forEach(s -> System.out.print(s + " "));
	}

	public static int[] merge(int[] a, int[] b) {
		int fullLength = a.length + b.length;
		int[] c = new int[a.length + b.length];
		for (int i = 0; i < fullLength; i++) {
			if (i < a.length) {
				c[i] = a[i];
			} else {
				c[i] = b[i - a.length];
			}
		}

		Arrays.stream(c).forEach(s -> System.out.print(s + " "));
	
		System.out.println("\n--");
		int tmp = 0;
		for (int j = 1; j < c.length; j++) {
			for (int i = 0; i < c.length; i++) {
				if (c[i] > c[j]) {
					tmp = c[j];
					c[j] = c[i];
					c[i] = tmp;
				}
			}
		}
		return c;
	}

	
	
	public static int[] bubbleSort(int arr[], int n) {
		if (n == 1) // passes are done
		{
			return arr;
		}

		for (int i = 0; i < n - 1; i++) // iteration through unsorted elements
		{
			if (arr[i] > arr[i + 1]) // check if the elements are in order
			{ // if not, swap them
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}

		bubbleSort(arr, n - 1); // one pass done, proceed to the next
		
		return arr;
	}
}
