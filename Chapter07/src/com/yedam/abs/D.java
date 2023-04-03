package com.yedam.abs;

import com.yedam.protect.A;
//protected 예제 다른 패키지 실행 상속
public class D extends A {
	public D() {
		super();
		this.field = "부모필드접근";
		this.method();
		super.method();
	}
}
