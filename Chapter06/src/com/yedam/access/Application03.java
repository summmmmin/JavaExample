package com.yedam.access;

public class Application03 {

	public static void main(String[] args) {
		Member obj1 = Member.getInstance(); //member객체 반환
		Member obj2 = Member.getInstance(); //member객체 반환
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj1 == obj2); //true 하나의 객체
		
		obj1.getInfo();
		
		System.out.println(obj2.age);
	}

}
