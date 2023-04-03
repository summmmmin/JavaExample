package com.hw.hw0403;

public class question01 {
	public static void main(String[] args) {
		Keypad kp;
		
		kp = new RPGgame();		
		
		kp.leftUpButton();
		kp.rightUpButton();
		kp.changeMode();
		kp.rightUpButton();
		kp.rightDownButton();
		kp.leftDownButton();
		kp.changeMode();
		kp.rightDownButton();
		
		System.out.println("==================");
		
		ArcadeGame arcade = new ArcadeGame();
		Keypad kp2 = arcade;
		
		kp2.leftUpButton();
		kp2.rightUpButton();
		kp2.leftDownButton();
		kp2.changeMode();
		kp2.rightUpButton();
		kp2.leftUpButton();
		kp2.rightDownButton();
		
	}
}
