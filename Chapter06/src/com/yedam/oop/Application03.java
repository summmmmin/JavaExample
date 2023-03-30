package com.yedam.oop;

public class Application03 {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		//메소드 호출0
		cal.sum(10, 20);
		
		int result = cal.sum3(new int[] {1,2,3,4,5,6,76,87,9});
		System.out.println("sum3 : "+result);
		
		result = cal.sum4(1,2,3,4,5,6,7,8,9,9);
		System.out.println("sum4 : " + result);
		
		Bycle bycle = new Bycle();
		bycle.setGas(5);
		boolean gasState = bycle.isLeftGas();
		
		if(gasState) {
			System.out.println("출발");
			bycle.run();
		}
		if(bycle.isLeftGas()) {
			System.out.println("gas 주입 필요 없음");
		}else {
			System.out.println("gas 주입 필요");
		}
		
		double result2 = cal.avg();
		System.out.println("평균 : "+result2);
		
		double result3 = cal.areaRectangle(10);
		double result4 = cal.areaRectangle(10, 20);
		System.out.println("정사각형 넓이 : "+ result3);
		System.out.println("직사각형 넓이 : "+ result4);
		
		Book java = new Book("혼자 공부하는 자바", "학습서", 
				24000, "한빛미디어", "yedam001");
		Book html = new Book("HTML", "학습서", 
				15000, "길벗", "yedam002");
		Book js = new Book("JavaScript", "학습서", 
				20000, "길벗", "yedam003");
		java.getInfo();
		html.getInfo();
		js.getInfo();
		
		Student std = new Student("김또치", 20230330, 100,46,54);
		std.getInfo();
	}	
}
