package com.learn.java.functional;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class FunctionStudentExample {

	static Function<List<Student>, Map<String, Double>> studentFunction = (list) -> {
		Map<String, Double> studentGradeMap = new java.util.HashMap<>();
		
		list.forEach(student -> {
			if(PredicateStudentExample.p1.test(student)) {
				studentGradeMap.put(student.getName(), student.getGpa());
			}
		});
		
		return studentGradeMap;
	};

	public static void main(String[] args) {
		System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));
	}
}
