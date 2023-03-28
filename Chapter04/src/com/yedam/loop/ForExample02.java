package com.yedam.loop;

public class ForExample02 {

	public static void main(String[] args) {
		// 중첩 반복문
		// 2단 ~ 9단 구구단 출력
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(i + "x"+ j + "="+ (i*j));
			}
		}
		// 공포의 별찍기
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				System.out.print("*");
				}
			System.out.println();
		}
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=5; i>=0; i--) {
			for(int j=i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0; i<5; i++) {
			for(int j=5; j-i>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		//
		
	}

}
