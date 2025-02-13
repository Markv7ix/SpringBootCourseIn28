package com.learnJava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamReduceExample2 {

	public static int performMultiplication(List<Integer> intList) {
		return intList.stream()
				// 1, 3, 5, 7
				// a = 1, b = 1 (from stream) => 1
				// a = 1, b = 3 (from stream) => 3
				// a = 3, b = 5 (from stream) => 15
				// a = 15, b = 7 (from stream) => 105
				.reduce(1, (a, b) -> a * b);
	}
	
	public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> intList) {
		return intList.stream()
				// 1, 3, 5, 7
				// a = 1, b = 1 (from stream) => 1
				// a = 1, b = 3 (from stream) => 3
				// a = 3, b = 5 (from stream) => 15
				// a = 15, b = 7 (from stream) => 105
				.reduce((a, b) -> a * b);
	}
	
	public static Optional<Student> getHighestGPASudent() {
		return StudentDataBase.getAllStudents().stream().reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
	}
	
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 3, 5, 7);
		List<Integer> integersVoid = new ArrayList<>();
		
		
//		System.out.println(performMultiplication(integers));
//		Optional<Integer> resultOpt = performMultiplicationWithoutIdentity(integers);
//		Optional<Integer> resultOpt2 = performMultiplicationWithoutIdentity(integersVoid);
//		System.out.println(resultOpt.isPresent() ? resultOpt.get() : "No result found");
//		System.out.println(resultOpt2.isPresent() ? resultOpt2.get() : "No result found");
		
		
		Optional<Student> optStudent = getHighestGPASudent();
		System.out.println(optStudent.isPresent() ? optStudent.get() : "No student found");
	}
}
