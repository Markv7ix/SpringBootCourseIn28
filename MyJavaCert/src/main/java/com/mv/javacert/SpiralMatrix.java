package com.mv.javacert;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();

		int left = 0, right = matrix[0].length;
		int top = 0, bottom = matrix.length;

		while (left < right && top < bottom) {

			// Scanning top row (L to R)
			for (int i = left; i < right; i++) {
				result.add(matrix[top][i]);
			}

			top += 1;

			// Scanning right column (T to B)
			for (int i = top; i < bottom; i++) {
				result.add(matrix[i][right - 1]);
			}

			right -= 1;

			if (left >= right || top >= bottom) {
				break;
			}

			// Scanning bottom row (R to L)
			for (int i = right - 1; i >= left; i--) {
				result.add(matrix[bottom - 1][i]);
			}

			bottom -= 1;

			// Scanning left col (B to T)
			for (int i = bottom - 1; i >= top; i--) {
				result.add(matrix[i][left]);
			}

			left += 1;

		}

		return result;
	}

	
	public static void main(String[] args) {
		int [] []  matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		List<Integer> result = spiralOrder(matrix);
		System.out.println(result);
	}
}
