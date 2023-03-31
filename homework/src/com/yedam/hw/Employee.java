package com.yedam.hw;

public class Employee {
	String name;
	int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public void getInformation() {
		System.out.println("이름 : "+name);
		System.out.println("연봉 : "+salary);
	}
	
	public void print() {
		System.out.println("수퍼클래스");
	}
}
