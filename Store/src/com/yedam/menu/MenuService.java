package com.yedam.menu;

import java.util.List;
import java.util.Scanner;

public class MenuService {
//	메뉴-조회, 추가, 수정, 삭제
	Scanner sc = new Scanner(System.in);
	//조회
	public void getMenuList(){
		List<MenuDTO> list = MenuDAO.getInstance().getMenuList();
		for(int i=0; i<list.size(); i++) {
			System.out.println("메뉴번호 : "+list.get(i).getMenuId());
			System.out.println("메뉴이름 : "+list.get(i).getMenuName());
			System.out.println("메뉴가격 : "+list.get(i).getMenuPrice());
			System.out.println("메뉴설명 : "+list.get(i).getMenuExplain());
			System.out.println("--------------------------------------");
		}
	}
	//추가
	public void menuAdd() {
		MenuDTO menu = new MenuDTO();
		
		System.out.print("메뉴이름> ");
		String menuName = sc.next();
		System.out.print("메뉴가격> ");
		int menuPrice = Integer.parseInt(sc.next());
		System.out.print("메뉴설명> ");
		String menuExplain = sc.next();
		
		menu.setMenuName(menuName);
		menu.setMenuPrice(menuPrice);
		menu.setMenuExplain(menuExplain);
		int result = MenuDAO.getInstance().menuAdd(menu);
		
		if(result == 1) {
			System.out.println("메뉴가 추가되었습니다.");
		}else {
			System.out.println("실패");
		}
	}
	
	//수정
	public void menuUpdate() {
		MenuDTO menu = new MenuDTO();
		int result =0;
		System.out.println("수정할 메뉴번호를 입력하세요");
		int menuId = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 항목을 선택하세요.");
		System.out.println("1.메뉴이름 | 2.메뉴가격 | 3.메뉴설명");
		int menuNo = Integer.parseInt(sc.nextLine());
		if(menuNo == 1) {
			System.out.println("변경할 이름을 입력하세요.");
			String name = sc.nextLine();
			menu.setMenuName(name);
			result = MenuDAO.getInstance().menuUpdate(menu, menuId, menuNo);
		}else if(menuNo == 2) {
			System.out.println("변경할 가격을 입력하세요.");
			int price = Integer.parseInt(sc.nextLine());
			menu.setMenuPrice(price);
			result = MenuDAO.getInstance().menuUpdate(menu, menuId, menuNo);
		}else if(menuNo == 3) {
			System.out.println("변경할 설명을 입력하세요.");
			String explain = sc.nextLine();
			menu.setMenuExplain(explain);
			result = MenuDAO.getInstance().menuUpdate(menu, menuId, menuNo);
		}
		if(result > 0) {
			System.out.println("수정되었습니다.");
		}else {
			System.out.println("수정 실패");
		}
	}
	
	//삭제
	public void menuDelete() {
		System.out.print("삭제할 메뉴번호> ");
		int menuId = Integer.parseInt(sc.next());
		
		int result = MenuDAO.getInstance().menuDelete(menuId);
		if(result > 0) {
			System.out.println("삭제되었습니다.");
		}else {
			System.out.println("삭제 실패");
		}
	}
	
	//주문-메뉴선택
	public void getMenu(){
		List<MenuDTO> list = MenuDAO.getInstance().getMenuList();
		System.out.println("메뉴번호\t|\t메뉴이름\t|\t메뉴가격");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMenuId()+"\t \t"+list.get(i).getMenuName()+"\t \t"+list.get(i).getMenuPrice());
		}
		System.out.println("-------------------------------------------");
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getMenuId()+":"+list.get(i).getMenuName()+"|");
//			if(i%5==4) {
//				System.out.println();
//			}
//		}
	}
}
