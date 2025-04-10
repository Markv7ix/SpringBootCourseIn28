package com.mv.javacert;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BalancedParentheses {

	public static boolean isParenthesesBalanced(String s) {
		
		Map<String, String> map = new HashMap<>();
		map.put("}", "{");
		map.put("]", "[");
		map.put(")", "(");
		java.util.Stack<String> stack = new java.util.Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			String c = s.substring(i, i + 1);
			
			if(map.containsKey(c)) {
				String opening = map.get(c);
				if(stack.empty()) {
					return false;
				}
				if(!stack.pop().equals(opening)) {
					return false;
				}
			} else {
				stack.push(c);
			}
			
		}
		
		
		return stack.empty();
	}
	
	
	public static void main(String[] args) {
		
		String s = "]{()()()[][[][(())]}[";
		long start = Instant.now().toEpochMilli();
		System.out.println(isParenthesesBalanced(s));
		System.out.println(Instant.now().toEpochMilli() - start + " ms");
	}
}
