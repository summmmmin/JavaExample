package com.yedam.store;

import java.util.Scanner;

public class StoreService {
	Scanner sc = new Scanner(System.in);
	//가게정보조회
	public void getStore() {
		StoreDTO store = StoreDAO.getInstance().getStore();
		
		System.out.println("가게이름 :\t" + store.getStoreName());
		System.out.println("전화번호 :\t"+store.getStorePhone());
		System.out.println("주소    :\t"+store.getStoreAddr());
		System.out.println("영업시간 :\t"+store.getStoreHour());
	}
	//가게정보수정
	public void storeUpdate() {
		StoreDTO store = new StoreDTO();
		System.out.println("1.가게이름 | 2.전화번호 | 3.주소 | 4.영업시간");
		int menuNo = Integer.parseInt(sc.nextLine());
		System.out.print("수정내용>");
		String val = sc.next();
		int result = 0;
		if(menuNo == 1) {
			store.setStoreName(val);
			result = StoreDAO.getInstance().storeUpdate(store, menuNo);
		}else if(menuNo == 2) {
			store.setStorePhone(val);
			result = StoreDAO.getInstance().storeUpdate(store, menuNo);
		}else if(menuNo == 3) {
			store.setStoreAddr(val);
			result = StoreDAO.getInstance().storeUpdate(store, menuNo);
		}else if(menuNo == 4) {
			store.setStoreHour(val);
			result = StoreDAO.getInstance().storeUpdate(store, menuNo);
		}
		if(result > 0) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
	}
	//가게정보삭제
	public void storeDelete() {
		StoreDTO store = new StoreDTO();
		System.out.println("1.가게이름 | 2.전화번호 | 3.주소 | 4.영업시간");
		int menuNo = Integer.parseInt(sc.nextLine());
		int result = 0;
		if(menuNo == 1) {
			result = StoreDAO.getInstance().storeUpdate(store, menuNo);
		}else if(menuNo == 2) {
			result = StoreDAO.getInstance().storeUpdate(store, menuNo);
		}else if(menuNo == 3) {
			result = StoreDAO.getInstance().storeUpdate(store, menuNo);
		}else if(menuNo == 4) {
			result = StoreDAO.getInstance().storeUpdate(store, menuNo);
		}
		if(result > 0) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
	}
}
