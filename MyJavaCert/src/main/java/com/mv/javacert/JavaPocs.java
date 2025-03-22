package com.mv.javacert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.mv.javacert.model.Employee;

public class JavaPocs {

	public static void sortEmployees() {

		Employee e1 = Employee.builder().id(1).name("John").dept("ceo").build();
		Employee e2 = Employee.builder().id(11).name("Anne").dept("sales").build();
		Employee e3 = Employee.builder().id(5).name("Rick").dept("legal").build();
		Employee e4 = Employee.builder().id(4).name("Nick").dept("dev").build();

		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);

		System.out.println("Sorting by id: ");
		employees.stream().sorted().forEach(System.out::println);
		System.out.println("Sorting by name: ");
		employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
		System.out.println("Sorting by dept: ");
		employees.stream().sorted(Comparator.comparing(Employee::getDept)).forEach(System.out::println);
	}

	public static void sortNumberArray() {
		Random random = new Random();
		int[] intArray = random.ints(100, 0, 10000).toArray();

		Arrays.sort(intArray);
		Arrays.stream(intArray).forEach(System.out::println);
	}

	public static void streamTest() {
		String [] array = {"abc", "def", "fgh", "jkl"};
		List<String> listResult = Arrays.stream(array).filter(s -> s.matches("\\w*[aeiou]\\w*")).collect(Collectors.toList());
		listResult.stream().forEach(System.out::println);
	}

	public static void regexTest() {
		String [] s = {"abcdef", "wxyz"};
		
		System.out.println(s[0].matches("\\w*[aeiou]\\w*"));
	}
	
	//HackerRank Challenge #1
    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        int size = arr.size();
        double [] ratio = {0, 0, 0};
        arr.forEach(n -> {
            if(n == 0) { //zeroes
                ratio[0]++; 
            } else if (n < 0) { //negatives
                ratio[1]++;
            } else { // positives
                ratio[2]++;
            }
        });
        for(int i = 0; i < ratio.length; i++) {
            ratio[i] /= size;
        }
        
        for(int i = ratio.length - 1; i >= 0; i--) {
            System.out.println(String.format("%.6f", ratio[i]));
        }

    }

    //HackerRank Challenge #2
    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        long minSum = 0, maxSum = 0;
        for(int ignoredIndex = 0; ignoredIndex < arr.size(); ignoredIndex++) {
            long tmpSum = 0;
            for(int j = 0; j < arr.size(); j++) {
                if(j == ignoredIndex) continue; 
                tmpSum += arr.get(j);
            }
            if(ignoredIndex == 0) { // First round
                minSum = maxSum = tmpSum;
            }
            if(tmpSum < minSum) {
                minSum = tmpSum;
            }
            if(tmpSum > maxSum) {
                maxSum = tmpSum;
            }
        }
        System.out.println(minSum + " " + maxSum);
    }

    public static String timeConversion(String s) {
    // Write your code here
        String [] timeArray = s.split(":");
        int hour = Integer.parseInt(timeArray[0]);
        String minutes = timeArray[1];
        String seconds = timeArray[2].substring(0,2);
        String ampm = timeArray[2].substring(2);
        boolean pmFlag = ampm.equalsIgnoreCase("pm");
        int hour24 = hour;         
        if(hour == 12 && !pmFlag) {
            hour24 = 0;
        } else if (hour != 12 && pmFlag) {
            hour24 = hour + 12;
        }
       
		String militarTime = new StringBuilder().append(hour24 < 10 ? "0" : "").append(hour24).append(":")
				.append(minutes).append(":").append(seconds).toString();
       
       System.out.println(militarTime);
       
        return militarTime;
    }
	
    public static Long streamSum() {
    	
    	List<Long> numberList = List.of(1L, 2L, 3L, 4L, 5L, 6L);
    	
    	Long result = numberList.stream().mapToLong(Long::valueOf).sum();
    	return result;
    }
    
    
	public static void main(String[] args) {
//		sortEmployees();

//		sortNumberArray();
		
//		streamTest();
		
//		regexTest();
		
		System.out.println(7 % 2);
	}
}
