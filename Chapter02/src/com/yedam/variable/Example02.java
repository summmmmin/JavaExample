package com.yedam.variable;

public class Example02 {
	public static void main(String[] args) {
		//자동 타입 변환
		char charVal = 'A' + 1;
		System.out.println(charVal);
		int iVar = charVal;
		System.out.println(iVar);
		double dVar = iVar;
		System.out.println(dVar); //66.0
		System.out.println();
		
		//강제 타입 변환
		iVar = (int)dVar; //66
		System.out.println(iVar);
		charVal = (char)iVar; //'B'
		System.out.println(charVal);
		System.out.println();
		
		double dVar2 = 3.144444;
		int iVar2 = (int)dVar2; //3
		System.out.println(iVar2);
		
		//자동 타입 변환을 활용한 연산
		byte result = 10 + 20;
		System.out.println(result);
		
		byte x = 10;
		byte y = 20;
		//byte result2 = x + y; //결과값 int
		int result2 = x + y;
		//강제타입변환
		//byte result2 = (byte)(x + y);
		
		//데이터 타입 크기에 따른 연산
		//long + int = long
		//byte + int = int
		//double + int = double
		
		byte bVar = 10;
		int iVar1 = 100;
		long lVar = 1000;
		long result3 = bVar + iVar1 + lVar;
		System.out.println(result3);
		
		int iVal2 = 1;
		double dVal3 = (double)iVal2/2;
		System.out.println(dVal3);
		
		
	}
}
