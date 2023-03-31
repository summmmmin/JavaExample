package homework;

import java.util.Scanner;

public class exam0331 {

	public static void main(String[] args) {
		// 문제1
		System.out.println("문제1");
		int x = 10;
		double y = 2.0;
		System.out.println("x + y="+(int)(x+y));
		System.out.println("x - y="+(int)(x-y));
		System.out.println("x x y="+(int)(x*y));
		System.out.println("x / y="+(int)(x/y));
		
		
		// 문제2
		//(1)false  (2)true  (3)false
		System.out.println("\n문제2");
		int num1 = 10;
		int num2 = 20;
		boolean result;
		
		result = ((num1 > 10) && (num2 > 10));
		System.out.println(result); 	//false
		result = ((num1 > 10) || (num2 > 10));
		System.out.println(result); 	//true
		System.out.println(!result); 	//false
		
		
		// 문제3
		System.out.println("\n문제3");
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		System.out.println("money=" + money);
		for(int i=0; i<coinUnit.length; i++) {
			int count = 0; //동전개수
			count += money/coinUnit[i];
			money = money % coinUnit[i];
			System.out.print(coinUnit[i]+"원:"+count+"개  ");
		}
		
		
		// 문제4
		System.out.println("\n\n문제4");
		for(int i=2; i<=9; i++) {
			System.out.println(i+"단");
			for(int j=1; j<=i; j++) {
				System.out.println(i+"x"+j+"="+i*j);
			}
		}
		
		
		// 문제5
		System.out.println("\n문제5");
		Scanner sc = new Scanner(System.in);
		int size = 5;		//주사위크기
		int dice[] = null;	//주사위 횟수배열
		boolean run = true;
		while(run) {
			System.out.println("=== 1.주사위 크기 | 2.주사위 굴리기 | 3.결과 보기 | 4.가장 많이 나온 수 | 5.종료 ===");
			System.out.print("메뉴>");
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch(selectNo) {
			case 1:
				System.out.println("주사위 크기 (5~10)>");
				size = Integer.parseInt(sc.nextLine());
				dice = new int[size];	//배열 크기
				break;
			case 2:
				int count = 0;
				while(true) {
					int a = (int) (Math.random() * size +1);
					System.out.println(a);//주사위 굴렸을때 랜덤값
					if(a == 5) {
						dice[a-1] += 1;
						System.out.println("5가 나올때까지 주사위를 "+ (count+1)+"번 굴렸습니다.");
						break;
					}else {
						dice[a-1] += 1;
						count += 1;
					}
				}
				break;
			case 3:
				for(int i=0; i<size; i++) {
					System.out.printf("%d은 %d번 나왔습니다.\n", i+1, dice[i]);
				}
				break;
			case 4:
				int max =dice[0];
				int idx = 0;
				for(int i=0; i<size; i++) {
					if(max< dice[i]) {
						max = dice[i];
						idx = i;
					}
				}
				System.out.println("가장 많이 나온 수는"+(idx+1)+"입니다.");
				break;
			case 5:
				System.out.println("프로그램 종료");
				run = false;
				break;
			}
		}
	}

}
