package com.yedam.API;

import java.util.Random;

public class MathExample {
	public static void main(String[] args) {
		// 절댓값
		int v1 = Math.abs(-5);
		System.out.println(v1);
		double v2 = Math.abs(-3.1);
		System.out.println(v2);
		
		//올림
		double v3 = Math.ceil(5.3);
		System.out.println(v3);
		double v4 = Math.ceil(-5.3);
		System.out.println(v4);
		
		//내림
		double v5 = Math.floor(5.3);
		System.out.println(v5);
		double v6 = Math.floor(-5.3);
		System.out.println(v6);
		
		//최대 최소
		int v7 = Math.max(5,  9);
		System.out.println(v7);
		
		int v8 = Math.min(5, 9);
		System.out.println(v8);
		
		//랜덤
		double v9 = Math.random();
		System.out.println(v9);
		
		//rint (짝수는 내림, 올수는 올림)
		double v10 = Math.rint(8.5);
		System.out.println(v10);		
		double v11 = Math.rint(7.5);
		System.out.println(v11);
		double v12 = Math.rint(3.5);
		System.out.println(v12);
		
		//반올림
		double v13 = Math.round(5.4);
		System.out.println(v13);
		
		//Random()
		//시간은 중복이 없으므로 중복되지않는 랜덤값
		Random random = new Random(System.currentTimeMillis());
		System.out.println(random.nextDouble());
		
		
	}

}
