package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamFlatMapExample {

    public static List<String> printStudentActivities() {

        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //<Stream<String>
                .collect(toList());

    }

    public static List<String> printUniqueStudentActivities() {

        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(toList());

    }

    public static long getStudentActivitiesCount() {

        long totalActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();

        return totalActivities;

    }

    public static void main1(String[] args) {


        System.out.println("Student Activities : " + printStudentActivities());
        System.out.println("Unique Student Activities : " + printUniqueStudentActivities());
        System.out.println("Unique Student Activities Count: " + getStudentActivitiesCount());

    }

    public static List<String> printStudentActivites() {
		return StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getActivities)
				.flatMap(List::stream)
				.distinct()
				.sorted()
				.collect(toList());
	}
    
    public static long countStudentActivites() {
    	return StudentDataBase.getAllStudents()
    			.stream()
    			.map(Student::getActivities)
    			.flatMap(List::stream)
    			.distinct()
    			.count();
    }
    
    public static void main(String[] args) {
		System.out.println(printStudentActivites());
		System.out.println(countStudentActivites());
	}
    
}
