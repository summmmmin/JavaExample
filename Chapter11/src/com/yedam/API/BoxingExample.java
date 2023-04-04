package com.yedam.API;

public class BoxingExample {

	public static void main(String[] args) {
		// Boxing : 기본 타입 -> 객체로 포장
		
		// 사용가능하지만 권장하지 않는다.
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer("100");
		
		Integer obj3 = Integer.valueOf(100);
		Integer obj4 = Integer.valueOf("100");
		
		// unBoxing
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		int value3 = obj3.intValue();
		int value4 = obj4.intValue();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		
		// 자동 박싱
		Integer obj5 = 100;
		System.out.println("value : "+obj5.intValue());
		
		// 대입 시 자동 언박싱
		int value5 = obj5;
		System.out.println("value5 : "+value5);

		// 연산시 자동 언박싱
		int value6 = obj5 + 500;
		System.out.println("value6 : "+value6);
		
		// 포장 값 비교(포장된 박스가 같은지 비교)
		Integer obj6 = 100;
		Integer obj7 = 100;
		
		System.out.println(obj6 == obj7);
		System.out.println(obj6.intValue() == obj7.intValue());
		
		// 형변환(타입변환)
		double value7 = Double.parseDouble("3.014");
		System.out.println(value7);
		
		
		
	}

}
