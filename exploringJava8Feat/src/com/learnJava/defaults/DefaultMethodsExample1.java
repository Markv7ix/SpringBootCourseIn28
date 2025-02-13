package com.learnJava.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodsExample1 {

    public static void main(String[] args) {


        List<String> stringList  = Arrays.asList("Adam", "Jenny", "Alex","Eric","Mike", "Tim", "Becky");

       /* Collections.sort(stringList);

        System.out.println("Sorted list : " +  stringList);
       */

        stringList.sort(Comparator.naturalOrder());

        System.out.println("Sorted list : " +  stringList);

        stringList.sort(Comparator.reverseOrder());

        System.out.println("Reverse Sorted list : " +  stringList);

        System.out.println("Custom sorting");
        stringList.sort( (s1, s2) -> s1.length() > s2.length() ? 1 : -1);
        System.out.println(stringList);
        
        System.out.println("Using Comparator.comparing");
        stringList.sort(Comparator.comparing(s -> s));
        System.out.println(stringList);
        
        
    }
}
