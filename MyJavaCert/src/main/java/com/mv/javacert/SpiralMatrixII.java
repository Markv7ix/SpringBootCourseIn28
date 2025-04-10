package com.mv.javacert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralMatrixII {

	public static int[][] generateMatrix(int n) {

		int value = 1;
		int limit = n * n;

		int left = 0, top = 0;
		int right = n;
		int bottom = n;

		int[][] matrix = new int[n][n];

		while (left < right && top < bottom) {

			// Filling top row (L to R)
			for (int j = left; j < right; j++) {
				matrix[top][j] = value++;
			}

			top += 1;

			// Filling right col (T to B)
			for (int i = top; i < bottom; i++) {
				matrix[i][right - 1] = value++;
			}

			right -= 1;

			if (top >= bottom || left >= right) {
				break;
			}

			// Filling bottom row (R to L)
			for (int j = right - 1; j >= left; j--) {
				matrix[bottom - 1][j] = value++;
			}

			bottom -= 1;

			// Filling left col (B to T)
			for (int i = bottom - 1; i >= top; i--) {
				matrix[i][left] = value++;
			}

			left += 1;
		}

		return matrix;
	}
	
	public static void main(String[] args) {
		
		int n = 4;
		int [][] matrix = generateMatrix(n);

		for(int i = 0; i < n; i++) {
			System.out.print("[");
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("]\n");
			
		}
		
	}
}
