package com.yedam.loop;

import java.util.Scanner;

public class hw0328 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문제1) 각 연산식을 대입 연산자 하나로 구성된 연산식으로 수정하세요.
		int val = 0;

		//val = val + 10;
		val += 10;	
		//val = val - 5;		
		val -= 5;
		//val = val * 3;
		val *= 3;		
		//val = val / 5;
		val /= 5;
		
		// 문제2) 변수 val의 값이 양수일 경우엔 변수 값을, 아닐 경우엔 0을 담는 변수를 선언하세요. (단, 삼항연산자를 사용)
		int intResult = (val>0) ? val:0;
		System.out.println(intResult);
		
		/* 문제 3) 다음과 같이 두 개의 정수가 주어졌을 경우 
	  			    두 정 수 중에서 음수가 있다면 'One of a or b is negative number'를,
	  			    만일 그렇지 않다면 'both a and b are zero or more'를 출력하도록 구현하세요. */ 
		int a = 10;
		int b = -8;
		String strResult = "";
		if(a<0 || b<0) {
			strResult = "One of a or b is negative number";
		}else{
			strResult = "both a and b are zero or more";
		}
		System.out.println(strResult);

		// 문제4) 차례대로 x와 y의 값이 주어졌을 때 어느 사분면에 해당되는지 출력하도록 구현하세요.
		// 각 사분면에 해당 하는 x와 y의 값은 아래를 참조하세요.
		// 제1사분면 : x>0, y>0
		// 제2사분면 : x<0, y>0
		// 제3사분면 : x<0, y<0
		// 제4사분면 : x>0, y<0
		// 문제출처, 백준(https://www.acmicpc.net/) 14681번 문제
		int x = -1;
		int y = 3;
		if(x>0 && y>0) {
			System.out.println("제1사분면");
		}else if( x<0 && y>0){
			System.out.println("제2사분면");
		}else if( x<0 && y<0){
			System.out.println("제3사분면");
		}else if( x>0 && y<0){
			System.out.println("제4사분면");
		}

		// 문제5) 연도가 주어졌을 때 해당 년도가 윤년인지를 확인해서 출력하도록 하세요.
		// 윤년은 연도가 4의 배수이면서 100의 배수가 아닐 때 또는 400의 배수일때입니다.
		// 예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이며,
		// 1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아닙니다.
		// HiNT : 이중 IF문 사용
		// 문제출처, 백준(https://www.acmicpc.net/) 2753번 문제
		System.out.println("연도를 입력하세요:");
		int year = sc.nextInt();
		if(year%400 == 0) {
			System.out.println("윤년");
		}else if(year%4 ==0 && year%100!=0) {
			System.out.println("윤년");
		}else {System.out.println("윤년이 아닙니다");}
		
		// 문제6) switch문을 이용하여 가위, 바위, 보 중 하나가 주어졌을 때 사용자 어떤 값을 가져야 이길 수 있는 지를 출력하도록
		// 구현하세요.
		// 예를 들어, 가위가 주어졌을 때 "이기기 위해선 바위를 내야합니다." 라고 출력하도록 하세요.
		// 한 단어를 입력받을 경우 Scanner객체의 next() 함수를 사용하면 됩니다.
		System.out.println("가위바위보 입력:");
		String play = sc.next();
		switch(play) {
		case "가위":
			System.out.println("이기기 위해선 바위를 내야합니다.");
			break;
		case "바위":
			System.out.println("이기기 위해선 보를 내야합니다.");
			break;
		case "보":
			System.out.println("이기기 위해선 가위를 내야합니다.");
			break;
		default:
			System.out.println("가위바위보가 아닙니다.");
			break;
		}
		
		// 문제7) 차례대로 m과 n을 입력받아 m단을 n번째까지 출력하도록 하세요.
		// 예를 들어 2와 3을 입력받았을 경우 아래처럼 출력합니다.
		// 2 X 1 = 2
		// 2 X 2 = 4
		// 2 X 3 = 6
		System.out.println("m:");
		int m = sc.nextInt();
		System.out.println("n:");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println(m+"x"+i+"="+m*i);
		}
		
		//문제 8)
		//	구구단 출력
		// 	첨부파일 확인 후 해당 그림과 같이 구현해 볼 것.
		//	파일명 : gugu.png
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=5; j++) {
				System.out.print(j+"x"+i+"="+j*i+"\t");
			}
			System.out.println();
		}
		
		//p161 7번
		boolean run = true;
		int balance = 0;
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료 ");
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			int slt= sc.nextInt();
			if(slt ==1) {
				System.out.print("예금액>");
				balance += sc.nextInt();
			}else if(slt == 2) {
				System.out.print("출금액>");
				int draw = sc.nextInt();
				if (draw <= balance) {
					balance -= draw;
				}else {
					System.out.println("잔액부족");
				}
			}else if(slt == 3) {
				System.out.print("잔고>" + (balance)+"\n");
			}else if(slt == 4) {
				System.out.println("프로그램 종료");
				break;
			}}
	}
}
