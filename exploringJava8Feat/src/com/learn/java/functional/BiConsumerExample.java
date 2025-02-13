package com.learn.java.functional;

import java.util.List;
import java.util.function.BiConsumer;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class BiConsumerExample {

	static private BiConsumer<Double, Double> multiply = (a, b) -> System.out.println("Multiplication  is: " + (a*b));
	static private BiConsumer<Double, Double> division = (a, b) -> System.out.println("Division is: " + (a/b));
	static private BiConsumer<String, String> concat = (a, b) -> System.out.println("a: " + a + " b: " + b);
	
	public static void nameAndActivities() {
		
		BiConsumer<String, List<String>> biConsumer = 
				(name, activities) -> System.out.println(name + " : " + activities);
		
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		studentList.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
	}
	
	public static void main(String[] args) {
		concat.accept("java8", "is great");
		
		multiply.andThen(division).accept(10.0, 5.0);
		
		nameAndActivities();
	}
	
	
}
