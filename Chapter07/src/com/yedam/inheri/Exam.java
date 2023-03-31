package com.yedam.inheri;

public class Exam extends OverrideExam{

	//자식 클래스
	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("자식 클래스의 method1");
		super.method();
		super.method2();
	}

	
}
