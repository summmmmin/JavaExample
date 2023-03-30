package com.yedam.include;

import java.util.Scanner;

import com.yedam.access.Access;

public class Application02 {
	public static void main(String[] args) {
		Access ac = new Access(); //단축키 ctrl+shift+o
		Scanner sc = new Scanner(System.in);
		
		//public
		ac.free = "public";
		//protected
		ac.parent = "protected";
		//default
		ac.basic = "default";
		//private
		ac.privacy = "private";
	}
}
