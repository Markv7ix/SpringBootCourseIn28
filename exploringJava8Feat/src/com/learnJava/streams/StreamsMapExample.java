package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

public class StreamsMapExample {


    private static List<String> namesUpperCase(List<Student> names){
        List<String> namesUpperCase = names.stream() //Stream<Student>
                .map(Student::getName) //Stream<String>
                .map(String::toUpperCase) // Stream<String> -> UpperCase
                .collect(toList()); // returns List // terminal operation
        return namesUpperCase;
    }

    private static Set<String> namesSetUpperCase(List<Student> students){
        Set<String> namesUpperCase = students.stream() //Stream<Student>
                .map(Student::getName) //Stream<String>
                .map(String::toUpperCase) // Stream<String> -> UpperCase
                .collect(toSet()); // returns List // terminal operation
        return namesUpperCase;
    }

    private static Map<String, Integer>  namesLengthMap(ArrayList<String> names){

        Map<String, Integer> namesLengthMap = names.stream()//Stream<String>
                .collect(toMap(String::toString,String::length)); // returns Map

        return namesLengthMap;
    }

    private static List<String> namesList() {
    	return StudentDataBase.getAllStudents().stream().map(Student::getName).collect(toList());
    }
    
    private static Set<String> namesSet() {
		return StudentDataBase.getAllStudents().stream()
				.map(Student::getName)
				.map(String::toUpperCase)
				.collect(toSet());
    }
    

    public static void main(String[] args) {

//        ArrayList<String> names = new ArrayList<>();
//        names.add("adam");
//        names.add("dan");
//        names.add("jenny");
//
//        System.out.println("namesUpperCase List : " + namesUpperCase(StudentDataBase.getAllStudents()));
//        System.out.println("namesUpperCase Set : " + namesSetUpperCase(StudentDataBase.getAllStudents()));
//        System.out.println("namesLengthMap : " + namesLengthMap(names));

    	System.out.println("namesList : " + namesList());
    	System.out.println("namesList : " + namesSet());
    }

}
