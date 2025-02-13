package com.learn.java.lambdas;

public class RunnableLambdaExample {

	public static void main(String[] args) {
		
		// Before Java 8
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("Running thread runnable");
			}
		};
		
		Thread t = new Thread(runnable);
		t.start();
		
		// Java 8 Lambda
		Runnable runnableJ8 = () -> {
			System.out.println("Running thread with Lambda");
		};
		
		new Thread(runnableJ8).start();
		
		new Thread(() -> System.out.println("Running thread with lambda 2"));
	}
}
