package com.yedam.loop;

import java.util.Scanner;

public class ForExample01 {

	public static void main(String[] args) {
		int sum = 0;
		sum = sum + 1;
		sum = sum + 2;
		sum = sum + 3;
		sum = sum + 4;
		sum = sum + 5;
		//1~5까지의 합
		System.out.println(sum);
		sum = 0;
		for(int i = 1; i<=5; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
		
		//1~100 사이 짝수, 홀수 구하기
		//짝수 -> 2로 나눴을때 나머지 0
		for(int i=1; i<=100; i++) {
			if(i%2 == 0) {
				System.out.println(i + "는 짝수");
			}else {
				System.out.println(i+ "는 홀수");
			}			
		}
		
		//입력한 숫자에 대한 구구단 출력
		//구구단  2x1 = 2, 2x2 = 4, 2x3 = 6 ...
		for(int i=1; i<10; i++) {
			System.out.println("2 x "+i+"= "+(2*i));
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("구구단 입력>");
		int gugu = sc.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.println(gugu + " x " + i +"= "+(gugu*i));
		}
		
		//입력한 값에 대한 총합, 평균, 최대값, 데이터 받을 개수 스태너 활용해서 데이터 입력
		//총합: 입력받자마자 총합이라는 변수에 누적 합계
		//평균 : 총합 / 데이터입력개수
		//최대값 : 입력한 데이터와 기존에 들어있는 데이터 비교 더 큰 것
		//최소값 : 입력한 데이터와 기존에 들어있는 데이터 비교 더 작은것
		int total = 0;
		double avg = 0;
		int max = 0;
		int min = 0;
		System.out.println("데이터 입력 개수:");
		
		//입력할 데이터 개수 입력 받음
		int count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			System.out.println("데이터 입력:");
			int data = sc.nextInt();
			//총합
			total += data;
			//최대값, 최소값 초기값 설정
			if(i==0) {
				max = data;
				min = data;
			}else {
				if(max < data) {
					max = data;
				}
				if(min > data){
					min = data;
				}
			}
		}
		System.out.println("총합 : " + total);
		System.out.println("평균 : " + (total/(double)count));
		System.out.println("최대값 : " + max + "\n최소값 : " + min);
		
		//up&down
		//임의 랜덤값 (1~100)사이의 하나의 정수를 추출해서
		//5번 안에 해당하는 랜덤값 맞추는 프로그램ㅁ 구현.
		//예) 랜덤값 50
		//입력값:30
		//-> up
		//입력값 :70
		//-> down
		//정답일경우
		//->정답, 몇번의 기회만에 맞추셨습니다.
		//정답을 맞추지 못할경우
		//실패하였습니다.
		
		int randomNo = (int)(Math.random()*100)+1;

		for(int i=1; i<=5; i++) {
			System.out.println("입력값:");
			int data = sc.nextInt();
			if(data < randomNo) {
				System.out.println("up");
			}else if(data > randomNo) {
				System.out.println("down");
			}else if(data == randomNo) {
				System.out.println("정답, " + i + "번의 기회만에 맞추셨습니다,");
				break;
			}
			if(i==5) {
				System.out.println("실패하였습니다.");
				System.out.println("정답은 " + randomNo);
			}
		}
	}
	
}
