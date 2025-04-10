package com.mv.javacert;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        Map<Integer, Integer> complementSumMap = new HashMap<>();

        int count = 0;
        for(int n : nums1) {
            for(int m : nums2) {
                int sum = n + m;
                complementSumMap.put(-sum, complementSumMap.getOrDefault(-sum, 0) + 1);
            }
        }

        for(int o: nums3) {
            for(int p : nums4) {
                int sum = o + p;
                if(complementSumMap.containsKey(sum)) {
                    count += complementSumMap.getOrDefault(sum, 0);
                }
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
		int [] nums1 = {1, 2};
		int [] nums2 = {-2, -1};
		int [] nums3 = {- 1, 2};
		int [] nums4 = {0, 2};
		
		System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
	}
}
