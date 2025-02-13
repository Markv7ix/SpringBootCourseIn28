package com.learn.java.functional;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class PredicateAndConsumerExample {

	static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
	static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;
		
	static BiConsumer<String, List<String>> studentBiConsumer = 
			(name, activities) -> System.out.println(name + " : " + activities);
	
	static BiPredicate<Integer, Double> biPredicate = (grade, gpa) -> grade >= 3 && gpa >= 3.9;
			
	static Consumer<Student> studentConsumer = (s) -> {
//		if(p1.and(p2).test(s)) {
		if(biPredicate.test(s.getGradeLevel(), s.getGpa())) {
			studentBiConsumer.accept(s.getName(), s.getActivities());
		}
	};
	
	private static void printNameAndActivities(List<Student> studentList) {
		studentList.forEach(studentConsumer);
	}
	
	
	public static void main(String[] args) {
		printNameAndActivities(StudentDataBase.getAllStudents());
	}
	
}
