package com.yedam.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoApp {
	
	private Scanner sc = new Scanner(System.in);
	int menu =0;
	
	int[] lotto = new int[6];
	List<int[]> list = new ArrayList<>();
	
	
	public LottoApp() {
		run();
	}
	
	private void run() {
		while(menu!=99) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1.로또생성  2.로또조회  99.프로그램 종료");
			menu = Integer.parseInt(sc.next());
				
			switch(menu) {
			case 1:
				makeLotto();
				break;
			case 2:
				showInfo();
				break;
			case 99:
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
	
	private void makeLotto() {
		//1. 입력한 금액만큼 로또번호 생성(1줄당 천원)
		//예) 10000원 -> 6개짜리 번호 10개
		//list에 저장.
		System.out.println("금액 투입>");
		int money = Integer.parseInt(sc.next());
		
		for(int i=0; i<(money/1000);i++) {
			makeNumber();
			list.add(lotto);
		}
	}
	
	private void showInfo() {
		System.out.print("구매한 금액>");
		System.out.println(list.size()*1000 +"원");
		for(int i=0;i<list.size();i++) {
			System.out.println(i+1+"번>");
			for(int j=0; j<6; j++) {
				System.out.print(list.get(i)[j]+" ");				
			}
			System.out.println();
			if(i%5 == 4) {
				System.out.println("====================");
			}
		}
	}
	private void makeNumber() {
		//로또 번호 6개 만들기
		//단, 중복 발생하면 안됨
		//정렬 안해도됨
		//잘되었는지 출력
		lotto = new int[6];
		for(int i=0; i<6; i++) {
			lotto[i]=(int)(Math.random() * 45+1);
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					i = i-1;
				}				
			}
		}
		
//		for(int i=0; i<6; i++) {
//			System.out.print(lotto[i]+" ");
//		}		
	}
	
}
