package com.learnJava.numericstreams;

import com.learnJava.data.StudentDataBase;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregateExample {

    public static void main(String[] args) {

    	
    	System.out.println("Count : "+ IntStream.rangeClosed(0,0).count());

        int sum = IntStream.rangeClosed(0,0).sum();
        System.out.println("Sum : "+ sum);

        OptionalInt max = IntStream.rangeClosed(0,0).max();
        System.out.println(max.isPresent() ? max.getAsInt() : "Value is not present");

        OptionalLong min = LongStream.rangeClosed(1,50).min();
        System.out.println(min.isPresent() ? min.getAsLong() : "Value is not present");

        OptionalDouble avg = IntStream.rangeClosed(1,50).average();
        System.out.println(avg.isPresent() ? avg.getAsDouble() : "Value is not present");

    }
}
