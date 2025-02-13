package com.modernjava.textblocks;

public class TextBlocks {

	public static String multiLineString() {

		var multiLine = "This is a\n" + "    multiline string\n" + "with newlines inside";

		return multiLine;
	}

	public static String multiLineStringWithTextBlock() {

		var multiLine = """
				This is a
				    multiline string
				with newlines inside""";

		return multiLine;
	}

	public static String multilineStringWithFormat(String name, String address) {

		var multiLine = """
				Name: %s
				Address: %s
				""".formatted(name, address);

		return multiLine;
	}

	public static String sql() {
		return """
				SELECT * FROM EMPLOYEE
				WHERE first_name = 'Mark'
				AND last_name = 'Smith'
				""";
	}

	public static String json() {
		return """
        {
            "name": "Mark",
            "email": "mark@gmail.com"
        }
        """; 
	}

	public static void main(String[] args) {

		System.out.println("multiLineString = " + multiLineString());
		System.out.println("multiLineStringWithTextBlock = " + multiLineStringWithTextBlock());
		System.out.println("multilineStringWithFormat = " + multilineStringWithFormat("Mark", "mark@gmail.com"));
		System.out.println("sql = " + sql());
		System.out.println("json = \n" + json());
	}
}
