package com.mv.javacert;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }

        int maxSequence = 1;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        Set<Integer> heads = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
                       
            int prev = nums[i] - 1;
            int next = nums[i] + 1;
            int count = 1;

            if(set.contains(prev)) {
                continue;
            }
            // Its a head
            if(heads.contains(nums[i])) { //Avoid duplicates
                continue;
            }
            heads.add(nums[i]);
            while(set.contains(next)) {
                count ++;
                next++;
            }

            maxSequence = Math.max(maxSequence, count);
        }

        return maxSequence;
    }
    
    public static void main(String[] args) {
		int [] nums = {0,3,7,2,5,8,4,6,0,1};
		
		System.out.println(longestConsecutive(nums));
	}
}
