package com.yedam.inheri;

public class Parent {
	//필드
	public String lastName;
	private int money; //상속 막기 private
	//생성자
	
	//메소드
	public void getInfo() {
		System.out.println("우리 가족의 성씨 : "+lastName);
	}
}
