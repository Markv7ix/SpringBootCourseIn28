package com.mv.javacert;

import java.time.Instant;

import com.mv.util.Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class PalindromeIndex {

	/*
	 * Complete the 'palindromeIndex' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts STRING s
	 * as parameter.
	 */

	public static int palindromeIndex(String s) {

		if (s.isEmpty() || isPalindrome(s)) {
			return -1;
		}

		for (int index = 0; index < s.length(); index++) {
			String newString = buildStringOmmitingIndex(s, index);
			if (isPalindrome(newString)) {
				return index;
			}
		}

		return -1;
	}

	public static int palindromeIndex2(String s) {
		log.debug("Length: " + s.length() + ": " + s);
		if (s.isEmpty() || isPalindrome(s)) {
			return -1;
		}

		for (int indexToOmmit = 0; indexToOmmit < s.length(); indexToOmmit++) {
			if(isPalindromeWithIndex(s, indexToOmmit)) {
				return indexToOmmit;
			}
		}

		return -1;
	}
	
	public static boolean isPalindromeWithIndex(String s, int index) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if(i == index) {
				i++; //Ommitting index
			}
			if(j == index) {
				j--; //Ommitting index
			}
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
//			log.debug(s.charAt(i) + "==" + s.charAt(j) + " is " + (s.charAt(i) == s.charAt(j)));
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public static String buildStringOmmitingIndex(String s, int index) {

		if (index == 0) {
			return s.substring(1);
		}

		if (index == s.length() - 1) {
			return s.substring(0, s.length() - 1);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0, index));
		sb.append(s.substring(index + 1, s.length()));

		// System.out.println("New string: " + sb.toString());

		return sb.toString();
	}

	public static void main(String[] args) {
		String[] ss = {
//				"baabaabaa",
//				"ababaabaa",
//				"aabbaabaa",
//				"aabababaa",
//				"aabaabbaa",
//				"aabaababa",
//				"aabaabaab",
//			//   01234567890123456789012345	
//				"dabalearrozalleazorraelabad",
//				"quyjjdcgsvvsgcdjjyq", "hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh",
//				"fgnfnidynhxebxxxfmxixhsruldhsaobhlcggchboashdlurshxixmfxxxbexhnydinfngf",
//				"bsyhvwfuesumsehmytqioswvpcbxyolapfywdxeacyuruybhbwxjmrrmjxwbhbyuruycaexdwyfpaloyxbcpwsoiqtymhesmuseufwvhysb",
//				"fvyqxqxynewuebtcuqdwyetyqqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf",
//				"mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm",
//				"fgnfnidynhxebxxxfmxixhsruldhsaobhlcggchboashdlurshxixmfxxxbexhnydinfngf" 
//				Util.loadFromFile("src/main/resources/longpalindrome.txt")
				/*Length: 19: "quyjjdcgsvvsgcdjjyq", 
				/*Length: 53: "hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh",
				/*Length: 71: "fgnfnidynhxebxxxfmxixhsruldhsaobhlcggchboashdlurshxixmfxxxbexhnydinfngf",
				/*Length: 107: "bsyhvwfuesumsehmytqioswvpcbxyolapfywdxeacyuruybhbwxjmrrmjxwbhbyuruycaexdwyfpaloyxbcpwsoiqtymhesmuseufwvhysb",
				/*Length: 81:*/ "fvyqxqxynewuebtcuqdwyetyqqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf",
				/*Length: 105: "mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm",
				/*Length: 59: "tpqknkmbgasitnwqrqasvolmevkasccsakvemlosaqrqwntisagbmknkqpt",
				/*Length: 12: "lhrxvssvxrhl",
				/*Length: 85: "prcoitfiptvcxrvoalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp",
				/*Length: 50: "kjowoemiduaaxasnqghxbxkiccikxbxhgqnsaxaaudimeowojk" */
			};
		long start = Instant.now().toEpochMilli();
//		for (String s : ss) {
//			log.debug("Index found: " + palindromeIndex(s));
//		}
//		log.debug("Batch processed in " + (Instant.now().toEpochMilli() - start) + " ms");
		
//		start = Instant.now().toEpochMilli();
		for (String s : ss) {
			log.debug("Index found: " + palindromeIndex2(s));
		}
		log.debug("Batch processed in " + (Instant.now().toEpochMilli() - start) + " ms");
	}

}

/**
 * public class Solution { public static void main(String[] args) throws
 * IOException { BufferedReader bufferedReader = new BufferedReader(new
 * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
 * BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 * 
 * int q = Integer.parseInt(bufferedReader.readLine().trim());
 * 
 * IntStream.range(0, q).forEach(qItr -> { try { String s =
 * bufferedReader.readLine();
 * 
 * int result = Result.palindromeIndex(s);
 * 
 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine(); }
 * catch (IOException ex) { throw new RuntimeException(ex); } });
 * 
 * bufferedReader.close(); bufferedWriter.close(); } }
 */
