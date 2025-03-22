import java.util.*;

/**
 * You are given an integer n. 
 * Return all well-formed parentheses strings that you can generate with n pairs of parentheses.
 
Input: n = 1
 
Output: ["()"]
Copy
 
Input: n = 3
 
Output: ["((()))","(()())","(())()","()(())","()()()"]
Copy
 
You may return the answer in any order.
 
 */
public class Interview {

	private int numOfOpened = 0; //Cannot be greater than n
	private int numToClose = 0;  //Cannot be greater than numOfOpened
	private Random random = new Random();
	
	public String parenthesesGenerator(int n) {
		
		// n = 2
		// (()), ()()
		
		// Input: n = 3
		// Output: ["((()))","(()())","(())()","()(())","()()()"]
		
		// n = 4
		// ()()()(), (())()(), (())((()), (()())(()), ((()))(), (((()))), ...
		
		// Opening parenthesis >= n
		// Closing parenthesis <= opened parenthesis
		
		
		StringBuilder sb = new StringBuilder();
		
		while(numOfOpened < n || numToClose > 0) {
			generateOpening(sb, n);
		}
		
		
		return sb.toString();
		
	}
	
	public List<String> generatePossibleValues(int n, long maxAttempts) {
		List<String> combinationsList = new ArrayList<>();
		Set<String> combinations = new HashSet<>();
		for(int i = 0; i < maxAttempts; i++) {
			resetCounters();
			combinations.add(parenthesesGenerator(n));
		}
		
		for(String str : combinations) {
			combinationsList.add(str);
		}
		
		return combinationsList;
	}
	
	private void generateOpening(StringBuilder strPart, int n) {
		if(numOfOpened < n) {
			numOfOpened++;
			numToClose++;
			strPart.append("(");
		}
		
		if(numOfOpened < n) {
			if(random.nextBoolean()) {
				generateOpening(strPart, n);
			} else if (numToClose > 0) {
				generateClosing(strPart, n);
			}
		}
		
		if(numOfOpened == n && numToClose > 0) {
			generateClosing(strPart, n);
		}
		
	}
	
	private void generateClosing(StringBuilder strPart, int n) {
		if(numToClose > 0) {
			numToClose--;
			strPart.append(")");
		}
	}
	
	private void resetCounters() {
		numOfOpened = 0;
		numToClose = 0;
	}
	
	public static void main(String [] args) {
		
		Interview generator = new Interview();
		List<String> values = generator.generatePossibleValues(5, 100);
		values.forEach(System.out::println);
	}
}
