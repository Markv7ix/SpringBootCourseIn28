package com.mv.javacert;

public class BestTimeToBuy {

	public static int maxProfit(int [] prices) {
		
		int min = prices[0];
		int profit = 0;
		
		for(int i = 1; i < prices.length; i++) {
			profit = Math.max(prices[i] - min, profit);
			if(prices[i] < min) {
				min = prices[i];
			}
		}
		
		return profit;
	}
	
	public static void main(String[] args) {
		
		int [] input = {7, 1, 3, 5, 6, 4};
		System.out.println(maxProfit(input));
	}
}
