package com.learn.java.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class SupplierExample {

	static Supplier<String> supplier = () -> "java8";
	static Supplier<Student> studentSupplier = () -> new Student("Adam", 2, 3.6, "male",
			Arrays.asList("swimming", "basketball", "volleyball"));
	static Supplier<List<Student>> listSupplier = () -> StudentDataBase.getAllStudents();
	
	public static void main(String[] args) {
		System.out.println("Result is: " + supplier.get());
		System.out.println("Result is: " + studentSupplier.get());
		System.out.println("Result is: " + listSupplier.get());
	}
}
