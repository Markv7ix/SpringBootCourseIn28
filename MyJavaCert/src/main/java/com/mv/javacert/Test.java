package com.mv.javacert;

public class Test {

	public String apple() {
		try {
			return "Hi";
		} catch (Exception e) {
			return "Error";
		} finally {
			return "Finally";
		}
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.apple());
	}
}
