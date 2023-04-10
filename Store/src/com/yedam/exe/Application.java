package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class Application {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	
	int menuNo =0;
	public Application() {
		run();
	}
	
	private void run() {
		while(true) {
			System.out.println("1.회원가입 | 2.로그인 | 3.종료");
			System.out.print("메뉴선택> ");
			menuNo = Integer.parseInt(sc.next());
			
			if(menuNo == 1) {
				
			}else if(menuNo == 2) {
				ms.login();
				if(MemberService.memberInfo != null) {
					new ManageMent();
				}
			}else if(menuNo == 3) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
}
