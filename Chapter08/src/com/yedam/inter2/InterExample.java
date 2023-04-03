package com.yedam.inter2;

public class InterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceC ic = new ImplementsC();
		ic.methodA();
		ic.methodB();
		ic.methodC();
		
		InterfaceA ac = new ImplementsC();
		ac.methodA();
		
		InterfaceB bc = new ImplementsC();
		bc.methodB();
	}

}
