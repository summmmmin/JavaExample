package com.hw.hw0404;

import java.util.Scanner;

public class StringGame {
	Scanner sc = new Scanner(System.in);
	public String array[] = {"Orange", "Game", "Phone", "Smart"};
	public int random;
	public String answer;
	public String checkchar;
	public String checkstr;
	
	public StringGame() {
		this.random = (int) (Math.random() * 3);
		this.answer = array[random];
	}
	
	public void setCharData() {
		// TODO Auto-generated method stub
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
		System.out.print("입력>>");
		char input = sc.next().charAt(0);
		for(int i=0; i<this.answer.length(); i++) {
			if(input == this.answer.charAt(i)) {
				System.out.println("문자열을 구성하는 문자입니다.");
				this.checkchar += this.answer.charAt(i);
			}
		}
	}

	public void showCharData() {
		// TODO Auto-generated method stub
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
		System.out.print("입력>>");
		String input = sc.next();
		for(int i=0; i<this.answer.length(); i++) {
			if(input.charAt(i) == this.answer.charAt(i)) {
				this.checkstr += "O";
			}else {
				this.checkstr += "X";
			}
		}
		if(this.checkstr.contains("X")) {
			System.out.println("입력된 문자열의 길이가 정답과 다릅니다.");
		}else {
			System.out.println("정답입니다.");
		}
	}

	public void setStrData() {
		// TODO Auto-generated method stub
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
	}

	public void init() {
		// TODO Auto-generated method stub
		this.random = (int) (Math.random() * 3);
		this.answer = array[random];
	}

}
