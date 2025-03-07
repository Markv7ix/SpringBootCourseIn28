package com.mv.crypto;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHashingFunction {

	private static int COST_FACTOR = 13;

	private static String generateHash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(COST_FACTOR));
	}

	public static boolean verifyHash(String providedPass, String storedHash) {

		return BCrypt.checkpw(providedPass, storedHash);
	}

	public static void main(String[] args) {
		String correctPassword = "My password 1234";
		String hash = generateHash(correctPassword);
		System.out.println("The Hash of " + correctPassword + " : " + hash);

		String incorrectPassword = "My password 12345";

		System.out.println("Comparing password(" + incorrectPassword + ") with hash(" + hash + ") : "
				+ verifyHash(incorrectPassword, hash));
		
		System.out.println("Comparing password(" + correctPassword + ") with hash(" + hash + ") : "
				+ verifyHash(correctPassword, hash));
	}
}
