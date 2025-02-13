package com.learnJava.streams_terminal;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamsMappingExample {

    public static void main(String[] args) {


        List<String> namesList = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toList())); // this avoids the additional map intermediate operation.

        System.out.println("namesList : " + namesList);

        Set<String> namesSet = StudentDataBase.getAllStudents()
        		.stream()
        		.collect(mapping(Student::getName,toSet())); // this avoids the additional map intermediate operation.
        
        System.out.println("namesSet : " + namesSet);
        
        List<String> namesListSorted = StudentDataBase.getAllStudents()
        		.stream()
        		.map(Student::getName)
        		.sorted()
        		.collect(Collectors.toList()); // this avoids the additional map intermediate operation.
        
        System.out.println("namesListSorted : " + namesListSorted);
    }

}
