package com.yedam.array;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		// 배열에 담긴 최대, 최소값
		Scanner sc = new Scanner(System.in);
		
		int[] ary;
		int no;
		
		System.out.println("배열의 크기>");
		no = sc.nextInt();
		sc.nextLine(); 
		ary = new int[no];
		
		//배열에 데이터 입력
		for(int i=0; i<ary.length; i++) {
			System.out.println("데이터 입력>");
			ary[i] = Integer.parseInt(sc.nextLine());
		}
		//최대값 구하기
		int max = 0;
		for(int i =0; i<ary.length; i++) {
			if(max < ary[i]) {
				max = ary[i];
			}
		}
		System.out.println("최대값 : " + max);
		
		//최소값 구하기
		int min = ary[0];
		for(int i=0; i<ary.length; i++) {
			if(min > ary[i]) {
				min = ary[i];
			}
		}
		System.out.println("최소값 : " + min);
	}
}