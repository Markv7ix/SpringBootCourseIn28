package com.learnJava.streams_terminal;

import com.learnJava.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamsCountingExample {

    public static long count(){
       return  StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>=3.9)
                .collect(Collectors.counting());
    }
    
    public static long count2(){
    	return  StudentDataBase.getAllStudents()
    			.stream()
                .filter(student -> student.getGpa()>=3.9)
    			.count();
    }

    public static void main(String[] args) {

        System.out.println(count());
        System.out.println(count2());
    }
}
