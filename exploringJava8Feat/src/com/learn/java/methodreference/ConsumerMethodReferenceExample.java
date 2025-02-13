package com.learn.java.methodreference;

import java.util.function.Consumer;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class ConsumerMethodReferenceExample {

	static Consumer<Student> consumer1 = System.out::println;
	static Consumer<Student> consumer2 = Student::printListOfActivities;
	
	public static void main(String[] args) {
		StudentDataBase.getAllStudents().forEach(consumer1);
		StudentDataBase.getAllStudents().forEach(consumer2);
	}
}
