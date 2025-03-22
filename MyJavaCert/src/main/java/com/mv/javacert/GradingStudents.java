package com.mv.javacert;

import java.util.ArrayList;
import java.util.List;

public class GradingStudents {

	public static List<Integer> gradingStudents(List<Integer> grades) {
		// Write your code here
		List<Integer> result = new ArrayList<>();
		for (Integer grade : grades) {
			if (grade < 38) {
				result.add(grade);
				continue;
			}

			if (grade % 5 == 0) {
				result.add(grade);
				continue;
			}

			int quotient = grade / 5;
			int ceil5 = (quotient + 1) * 5;
			if (ceil5 - grade <= 2) {
				result.add(ceil5);
				continue;
			}
			result.add(grade);
		}
		return result;
	}

	}
