package com.yedam.exe;

import java.util.Scanner;

import com.yedam.deartments.DptImpl;

public class DepartmentResource {
	
	DptImpl di = new DptImpl();
	Scanner sc = new Scanner(System.in);
	
	public DepartmentResource() {
		run();
	}

	private void run() {
		while (true) {
			System.out.println("1. 전체 조회 | 2. 단건 조회 | 3. 부서 등록 | 4. 메니저 수정 | 5. 삭제 | 99. 종료");
			System.out.println("메뉴>");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				di.getDepartmentsList();
			} else if (menu == 2) {
				di.getDeparment();
			} else if (menu == 3) {
				di.dptAdd();
			} else if(menu == 4) {
				di.dptUpdate();
			} else if(menu == 5) {
				di.dptDelete();
			} else if (menu == 99) {
				System.out.println("end of prog");
				break;
			}
		}
		
	}
}
