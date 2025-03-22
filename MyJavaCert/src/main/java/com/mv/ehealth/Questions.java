package com.mv.ehealth;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Questions {

	public static int[] getUnUsedKeysStream(int[] allKeys, int[] usedKeys) {
		return Arrays.stream(allKeys).boxed().filter(n -> Arrays.stream(usedKeys).noneMatch(n::equals)).
		mapToInt(i -> i).toArray();
	}

	//Java 11
	public static int[] getUnUsedKeysList(int[] allKeys, int[] usedKeys) {
		List<Integer> allKeysList = Arrays.stream(allKeys).boxed().collect(Collectors.toList());
		List<Integer> usedKeysList = Arrays.stream(usedKeys).boxed().collect(Collectors.toList());
		allKeysList.removeAll(usedKeysList);
		return allKeysList.stream().mapToInt(i -> (int) i).toArray();
	}
	
	//Java 18
		public static int[] getUnUsedKeysList17(int[] allKeys, int[] usedKeys) {
			List allKeysList = Arrays.asList(allKeys);
			
			List usedKeysList = Arrays.asList(usedKeys);
			allKeysList.removeAll(usedKeysList);
			
			return allKeysList.stream().mapToInt(i -> (int) i).toArray();
		}
	
	public static void main(String[] args) {
		int[] allKeys = { 1, 2, 3, 4, 5 };
		int[] usedKeys = { 1, 3 };
		int[] unUsedKeys = getUnUsedKeysList17(allKeys, usedKeys);
		System.out.println("UnUsed Keys: ");
		for (int key : unUsedKeys) {
			System.out.println(key);
		}
	}
}
