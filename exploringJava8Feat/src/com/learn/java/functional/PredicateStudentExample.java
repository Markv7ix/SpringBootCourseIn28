package com.learn.java.functional;

import java.util.function.Predicate;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class PredicateStudentExample {

	static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
	static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

	static private void filterStudentsByGradeLevel() {
		System.out.println("filterStudentsByGradeLevel: ");
		StudentDataBase.getAllStudents().forEach(student -> {
			if (p1.test(student)) {
				System.out.println(student);
			}
		});
	}

	static private void filterStudentsByGPA() {
		System.out.println("filterStudentsByGPA: ");
		StudentDataBase.getAllStudents().forEach(student -> {
			if (p2.test(student)) {
				System.out.println(student);
			}
		});
	}
	
	static private void filterStudents() {
		System.out.println("filterStudents: ");
		StudentDataBase.getAllStudents().forEach(student -> {
			if (p1.or(p2).negate().test(student)) {
				System.out.println(student);
			}
		});
	}
	
	public static void main(String[] args) {
		filterStudentsByGradeLevel();
		filterStudentsByGPA();
		filterStudents();
	}
}
