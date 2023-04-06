package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class ExeApp {
	Scanner sc = new Scanner(System.in);
	int menu =0;
	MemberService ms = new MemberService();
	public void run() {
		// 사용할 내용
		exe();
	}
	
	private void exe() {
		boolean run = true;
		String menu = "";
		while(run) {
			//로그인한경우
			if(MemberService.memberInfo != null) {
				System.out.println("1. 회원조회 | 2.회원등록 | 3. 회원탈퇴 | 4.회원수정 | 5.로그아웃");
				System.out.println("메뉴>");
				menu = sc.nextLine();
				switch(menu) {
				case "1":
					ms.getMemberList();
					break;
				case "2":
					ms.memberAdd();
					break;
				case "3":
					ms.memberDelete();
					break;
				case "4":
					ms.memberUpdate();
					break;
				case "5":
					ms.logout();
					break;
				}
			}
			//로그인안한경우
			else if(MemberService.memberInfo == null) {
				System.out.println("1. 로그인 | 2. 종료");
				System.out.println("메뉴>");
				menu = sc.nextLine();
				if(menu.equals("1")) {
					ms.login();
					
				}else {
					System.out.println("종료");
					break;
				}
			}
		}
	}

}
