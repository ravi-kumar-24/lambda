package com.predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {
	
	public static Predicate<Employee> getAdultMales(){
		return p-> p.getAge() >=21 && p.getGender().equals("M");
	}
	
	public static Predicate<Employee> getAdultFemales(){
		return p -> p.getAge()>=18 && p.getGender().equals("F");
	}
	
	public static Predicate<Employee> isAgeMoreThan(int age){
		return p -> p.getAge()>age;
	}

	public  static List<Employee> getFilteredEmp(List<Employee> emp, Predicate<Employee> predicate){
		
		return emp.stream().filter(predicate).collect(Collectors.toList());
	}
}
