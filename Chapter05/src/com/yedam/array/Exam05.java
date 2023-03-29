package com.yedam.array;

public class Exam05 {

	public static void main(String[] args) {
		// 최대값 인덱스 구하기
		int[] array = {10,50,70,20,30,80,40};		
		int max = array[0];
		int maxIndex = 0;
		//최대값
		for(int i=0; i<array.length; i++) {
			if(max<array[i]) {
				max = array[i];
				maxIndex = i;
			}
		}
		System.out.println("최대값 : "+max);
		System.out.println("인덱스 : " + maxIndex);
		
		
	}
}
