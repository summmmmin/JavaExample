package com.yedam.abs;

public class Cat extends Animal{
	
	public Cat() {
		this.kind = "포유류"; //super.kind = "" 
	}
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("야옹");
	}
	
}
