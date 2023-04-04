package com.yedam.API;

import java.util.Scanner;

public class example {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		문제 1] 문자열 뒤집기
		//예시 : 입력 > "12345678"  ,출력 > "87654321"
		System.out.print("입력 > ");
		String text = sc.next();
		StringBuilder sb = new StringBuilder();
		for(int i=text.length()-1; i>=0; i--) {
			sb.append(text.charAt(i));
		}
		System.out.println("출력 > "+ sb);
		
//		문제 2] 문자열 개수 세기
		// 입력되는 문자열을 뒤집어 출력하라
		// 알파벳, 숫자, 공백의 갯수
		
		
		

//		문제 3] 문자열 압축
		// 예시 : 입력 >"YYYEEDDDYYYMMMAAA";
//	          	출력 >Y3E2D3Y3M3A3
		System.out.print("입력 > ");
		text = sc.next();
		text += " ";
		int count =0;
		String text1="";
		for(int i=0; i<text.length()-1;i++) {
			if(text.charAt(i) == text.charAt(i+1)) {
				count += 1;				
			}else {
				text1 += text.charAt(i);
				text1 += (count+1);
				count =0;
			}
		}
		System.out.println("출력 > "+ text1);
				
		
		
//		문제 4] 생년월일 입력 후 나이 출력하기(220101 -> 2022년생, 230202 -> 1923년생)
//		        (단, 오늘 날짜 기준으로 생일이 지났으면 +1살, 안 지났으면 +0로 한다.)
//		        (올해 기준 +- 100살까지만 구한다.)
//		     예시) 
//		          입력> 950101 
//		          출력> 29
//		          입력> 001013
//		          출력> 23
		System.out.print("입력 > ");
		String birth = sc.next();
		int year = Integer.parseInt(birth.substring(0,2));
		int day = Integer.parseInt(birth.substring(2));
		int age;
		if(year <23) {
			age = 23-year;
		}else {
			age = 23+100-year;
		}
		if(day <= 0404) {
			age +=1;
		}
		System.out.println(age);		
		
//		문제 5] 중복 문자 갯수 세기
//	         입력> aaabbccceedddd
//	         출력> a 3개, b 2개, c 3개, e 2개, d 4개
		count =0;
		System.out.println(text);
		char compare = text.charAt(0);
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i) == compare) {
				count += 1;
				System.out.println(text.charAt(i)+""+count);
			}
		}
		System.out.println(count);
		System.out.println(compare);
	}

}
