package com.modernjava.var;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VarTypeExample {


    //var in the class properties are not allowed.
    //private var x = "abc";



    public static void main(String[] args) {

    	var list = List.of("Adam", "Dylan");
    	
    	for(var a : list) {
    		System.out.println(a);
    	}
    	
    	var map = Map.ofEntries(Map.entry("key1", list), Map.entry("key2", List.of("A", "B")));
    	
    	System.out.println(map);
    	
		map.forEach((var k, var v) -> {
			System.out.println("k:" + k + " - v:" + v);
		});
		
		var transformedName = transform("Adam");
		System.out.println(transformedName);
		
		// var cannot be used in the following scenarios
		// var cannot be used in the method parameters
		// var cannot be used in the method return type
		// var cannot be used in the class fields
		// var cannot be used in the catch block
		
    }

    static String transform(String name) { // var in the function argument is not allowed

        return name.toUpperCase();

    }

}

