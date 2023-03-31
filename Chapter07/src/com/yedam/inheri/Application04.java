package com.yedam.inheri;

public class Application04 {

	public static void main(String[] args) {
		SuperSonicAirplane sa = new SuperSonicAirplane();
		//sa -> flymode normal 상태로 객체 생성
		
		sa.takeOff();
		
		sa.fly();
		
		sa.flyMode = SuperSonicAirplane.SUPERSONIC;
		
		sa.fly();
		
		sa.flyMode = SuperSonicAirplane.NORMAL;
		
		sa.fly();
		
		sa.land();
		
	}

}
