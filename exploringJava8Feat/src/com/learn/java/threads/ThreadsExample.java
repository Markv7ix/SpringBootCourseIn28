package com.learn.java.threads;

import java.util.Random;
import java.util.function.BiFunction;

public class ThreadsExample {

	public static Random random = new Random();
	public static BiFunction<String, Integer, MyRunnable> runnableGeneratorFunction = MyRunnable::new;
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(runnableGeneratorFunction.apply("Alpha", 1));
		Thread t2 = new Thread(runnableGeneratorFunction.apply("Beta", 2));
		Thread t3 = new Thread(runnableGeneratorFunction.apply("Gamma", 3));
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}

class MyRunnable implements Runnable {
	
	String name;
	int id;
	
	public MyRunnable(String name, int process) {
		this.name = name;
		this.id = process;
		
	}
	
	public void run() {
		System.out.println("Running process: " + name + "  id: " + id);
		
		try {
			Thread.sleep(ThreadsExample.random.nextInt(10000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed id: " + id);
	}
}