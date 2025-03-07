package com.mv.javacert.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee implements Comparable<Employee> {

	private Integer id;
	
	private String name;
	
	private String dept;
	
	@Override
	public int compareTo(Employee o) {
		return this.getId().compareTo(((Employee) o).getId());
	}
}
