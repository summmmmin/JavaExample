package com.yedam.array;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		// 한 학생의 국어, 영어, 수학 점수를 배열에 담아서 성적 관리
		
		//{국어,영어,수학}
		Scanner sc = new Scanner(System.in);
		
		int[] point = new int[3];
		int sum =0;
		double avg =0;
		//학생의 성적 입력(국어, 영어, 수학)
		for(int i=0; i<point.length; i++) {
			System.out.print("성적입력> ");
			point[i] = sc.nextInt();
		}
		//학생의 점수 총 합계
		for(int i=0; i<point.length; i++) {
			sum += point[i];
		}
		System.out.println("총 합계 : "+sum);
		//학생의 성적 평균
		avg = (double)sum/(double)point.length;
		System.out.println("평균 : "+avg);
		
		
	}

}
