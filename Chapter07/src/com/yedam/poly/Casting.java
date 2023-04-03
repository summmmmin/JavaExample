package com.yedam.poly;

public class Casting {
	
	// 메개변수를 활용한 다형성
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child)parent;
			System.out.println("casting 성공");
		}else {
			System.out.println("casting 실패");
		}
	}
	
	public static void main(String[] args) {
		Parent p1 = new Child();
		method1(p1);
	}
}
