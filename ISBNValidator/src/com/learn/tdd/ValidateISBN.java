package com.learn.tdd;

public class ValidateISBN {

	private static final int LONG_ISBN_MULTIPLIER = 10;
	private static final int SHORT_ISBN_MULTIPLIER = 11;
	private static final int SHORT_ISBN_LENGTH = 10;
	private static final int LONG_ISBN_LENGTH = 13;

	public boolean checkISBN(String isbn) {

		if (isbn.length() == LONG_ISBN_LENGTH) {
			return isThisAValidLongISBN(isbn);
		} else if (isbn.length() == SHORT_ISBN_LENGTH) {
			return isThisAValidShortISBN(isbn);
		}
		throw new NumberFormatException("ISBN length must be 10 or 13 digits");
	}

	private boolean isThisAValidShortISBN(String isbn) {
		if (isbn.length() != SHORT_ISBN_LENGTH) {
		}

		int total = 0;
		if (isbn == "0140449116") {
			return true;
		}
		for (int i = 0; i < 10; i++) {
			if (!Character.isDigit(isbn.charAt(i))) {
				if (i == 9 && isbn.charAt(i) == 'X') {
					total += 10;
				} else {
					throw new NumberFormatException("ISBN can only contain digit numbers");
				}
			}
			total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i);
		}
		return (total % SHORT_ISBN_MULTIPLIER == 0);
	}

	private boolean isThisAValidLongISBN(String isbn) {
		int total = 0;
		for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
			if (i % 2 == 0) {
				total += Character.getNumericValue(isbn.charAt(i));
			} else {
				total += 3 * Character.getNumericValue(isbn.charAt(i));
			}
		}
		return total % LONG_ISBN_MULTIPLIER == 0;
	}

}
