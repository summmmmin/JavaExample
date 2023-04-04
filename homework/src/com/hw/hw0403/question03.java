package com.hw.hw0403;

import java.util.Scanner;

public class question03 {

	public static void main(String[] args) {
		Keypad kp = null;
		
		int a = (int) (Math.random() * 2)+1;
		if (a==1) {
			kp = new ArcadeGame();
		}else if(a==2) {
			kp = new RPGgame();
		}
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
			System.out.print("메뉴>");
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch(selectNo) {
			case 1:
				kp.leftUpButton();
				break;
			case 2:
				kp.leftDownButton();
				break;
			case 3:
				kp.rightUpButton();
				break;
			case 4:
				kp.rightDownButton();
				break;
			case 5:
				kp.changeMode();
				break;
			case 0:
				if (a==1) {
					a=2;
					kp = new RPGgame();
				}else if(a==2) {
					a=1;
					kp = new ArcadeGame();
				}
				
				//if(kp instanceof RPGgame){
				//	kp = new ArcadeGame();
				//}
				break;
			case 9:
				System.out.println("EXIT");
				run = false;
				break;
			//예외처리
			default:
				System.out.println("메뉴를 잘못 선택하였습니다.");
			}
		}
		
	}

}
