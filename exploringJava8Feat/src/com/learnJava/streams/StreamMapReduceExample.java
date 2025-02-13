package com.learnJava.streams;

import com.learnJava.data.StudentDataBase;
import com.learnJava.data.Student;

public class StreamMapReduceExample {

	private static int numOfNotebooks() {
        return StudentDataBase.getAllStudents().stream()
        		.filter((student) -> student.getGradeLevel() >= 3)
        		.filter((student) -> "female".equals(student.getGender()))
                .map(Student::getNoteBooks)
                .reduce(0,  Integer::sum);
	}
	
	public static void main(String[] args) {
		System.out.println("Number of notebooks: " + numOfNotebooks());
	}
}
