package com.mv.javacert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindNumberDistincColorAmongBalls {
	
	public static int[] queryResults(int limit, int[][] queries) {

		int[] colorQuery = new int[queries.length];

		Map<Integer, Integer> queryStore = new HashMap<>();
		Map<Integer, Integer> colorFreq = new HashMap<>();

		for (int i = 0; i < queries.length; i++) {

            int ball = queries[i][0];
            int newColor = queries[i][1];
            if(queryStore.containsKey(ball)) {                
                int prevColor = queryStore.get(ball);
                int f = colorFreq.getOrDefault(prevColor, 0);
                if(f >= 2) {
                    colorFreq.put(prevColor, f - 1);
                } else {
                    colorFreq.remove(prevColor);
                }
            } 
            queryStore.put(ball, newColor);
            colorFreq.put(newColor, colorFreq.getOrDefault(newColor, 0) + 1);

            colorQuery[i] = colorFreq.keySet().size();
		}

		return colorQuery;
	}
	
	public static void main(String[] args) {
//		int [][] input = {{0,2},{1,10},{0,10},{0,3},{1,5}};
		int [][] input = {{0,1},{1,4},{1,1},{1,4},{1,1}};
		int [] result = queryResults(1, input);
		List<Integer> resList = Arrays.stream(result).boxed().collect(Collectors.toList());
		System.out.println(resList);
	}
}
