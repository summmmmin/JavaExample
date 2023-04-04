package com.yedam.API;

public class SystemExample {
	public static void main(String[] args) {
		//System 클래스
		//System.exit(0)
		
//		for(int i=0; i<=10; i++) {
//			System.out.println(i);
//			if(i==5) {
//				System.exit(0); //프로그램 강제종료
//			}
//		}
//		System.out.println("종료");
		
		//현재 시간 읽기
		long time = System.nanoTime();
		
		int sum = 0;
		for(int i=0; i<=1000000; i++) {
			sum += i;
		}
		
		long time2 = System.nanoTime();
		
		System.out.println(time);
		System.out.println(time2);
		System.out.println("1~1000000의 합 : " + sum);
		System.out.println("소요 시간 : "+(time2-time) + "ns 소요");
	
		System.out.println(System.currentTimeMillis());
		
	}
}
