package com.mv.javacert;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

class CaesarCipher {

	/*
	 * Complete the 'caesarCipher' function below.
	 *
	 * The function is expected to return a STRING. The function accepts following
	 * parameters: 1. STRING s 2. INTEGER k
	 */

	public static String caesarCipher(String s, int k) {
		// Write your code here
		StringBuilder sb = new StringBuilder();
		Map<Character, Character> codec = generateCode(k);
		for (char c : s.toCharArray()) {
			if (codec.containsKey(c)) {
				sb.append(codec.get(c));
			} else {
				sb.append(c);
			}

		}

		return sb.toString();
	}

	public static Map<Character, Character> generateCode(int k) {
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		k = k % 26;
		Map<Character, Character> codec = new HashMap<>();
		for (int n = 0; n < 2; n++) {
			char[] alphaArray = alpha.toCharArray();
			for (int i = 0; i < alphaArray.length; i++) {
				int codedPos = (i + k) % 26;
				codec.put(alphaArray[i], alphaArray[codedPos]);
			}
			alpha = alpha.toUpperCase();
		}

		return codec;
	}

	public static void main(String[] args) {
		String input = "Always-Look-on-the-Bright-Side-of-Life";
		String output = "Fqbfdx-Qttp-ts-ymj-Gwnlmy-Xnij-tk-Qnkj";
		assertEquals(caesarCipher(input, 5), output);
	}
	
}