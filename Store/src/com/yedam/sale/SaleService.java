package com.yedam.sale;

import java.util.Scanner;

public class SaleService {
	Scanner sc = new Scanner(System.in);
	//주문
	//메뉴선택, 결제, 추소, 주문내역
	
	//메뉴선택
	public void menuSelec() {
		SaleDTO sale = new SaleDTO();
		while(true) {
			System.out.println("메뉴번호를 입력하세요(종료는 0)");
			int menu = Integer.parseInt(sc.next());
			if(menu == 0) {
				break;
			}
			System.out.println("수량을 입력하세요(종료는 0)");
			int qty = Integer.parseInt(sc.next());
			if(qty == 0) {
				break;
			}
			sale.setMenuId(menu);
			sale.setSaledetailQty(qty);
			int result = SaleDAO.getInstance().menuSelec(sale);
		}		
	}
	
	//주문하기(사용자)
	public void saleAdd() {
		SaleDTO sale = new SaleDTO();
		
		
	}
}
