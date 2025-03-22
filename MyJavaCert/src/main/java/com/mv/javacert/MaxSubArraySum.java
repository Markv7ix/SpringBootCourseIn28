package com.mv.javacert;

import java.time.Instant;

public class MaxSubArraySum {

		public static int solution(int [] input) {
			
			int curSum = 0;
			int maxSum = 0;
			
			for(int i = 0; i < input.length; i++) {
				if(curSum < 0) {
					curSum = 0;
				}
				curSum += input[i];
				maxSum = Math.max(maxSum, curSum);
			}
			
			return maxSum;
		}
		
		
		public static void main(String[] args) {
			
			int [] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
			long start = Instant.now().toEpochMilli();
			System.out.println(solution(input));
			System.out.println(Instant.now().toEpochMilli() - start + " ms");
		}
	}
