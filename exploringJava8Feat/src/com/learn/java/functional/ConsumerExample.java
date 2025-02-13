package com.learn.java.functional;

import java.util.List;
import java.util.function.Consumer;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class ConsumerExample {
	
	private static List<Student> studentList = StudentDataBase.getAllStudents();
	
	private static Consumer<Student> consumer1 = (s) -> System.out.println(s.toString());
	private static Consumer<Student> consumer2 = (s) -> System.out.println(s.getName());
	private static Consumer<Student> consumer3 = (s) -> System.out.println(s.getActivities());
	
	
	private static void printName() {
		System.out.println("Printing full list");
		studentList.forEach(consumer1);
		
	}
	
	private static void printNameWithCondition() {
		
		System.out.println("Printing with filtering: ------------");
		studentList.forEach(student -> {
			if(student.getGradeLevel() >= 3) {
				 consumer2.andThen(consumer3).accept(student);
			}
		});
		
	}
	
	private static void printNameAndActivities() {
		System.out.println("Priting full list");
		studentList.forEach(consumer3);
	}
	
	public static void main(String[] args) {
		Consumer<String> consumer1 = (s) -> System.out.println(s.toUpperCase());
		
		consumer1.accept("Hola" );
		
		printName();
		printNameAndActivities();
		printNameWithCondition();
	}
}
