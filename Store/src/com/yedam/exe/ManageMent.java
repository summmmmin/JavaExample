package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;
import com.yedam.menu.MenuService;
import com.yedam.review.AnswerService;
import com.yedam.review.ReviewService;
import com.yedam.sale.SaleService;
import com.yedam.store.StoreService;

public class ManageMent {
	Scanner sc = new Scanner(System.in);
	int menuNo = 0;
	boolean run = true;
	MemberService member = new MemberService();
	StoreService store = new StoreService();
	MenuService menus = new MenuService();
	SaleService sale = new SaleService();
	ReviewService review = new ReviewService();
	AnswerService answer = new AnswerService();
	public ManageMent() {
		storeJob();
	}

	private void storeJob() {
		while(run) {
			menu();
			if(MemberService.memberInfo.getMemberGrade().equals("U")) {
				switch(menuNo) {
				case 1:
					while(true) {
						System.out.println("1.조회 | 2.수정 | 3.탈퇴 | 4.나가기");
						System.out.println("메뉴선택> ");
						int menu = Integer.parseInt(sc.next());
						if(menu == 1) {
							member.getmember();
						}else if(menu == 2) {
							System.out.println("1.비밀번호 | 2.이름 | 3.전화번호 | 4.주소");
							int menuNo = Integer.parseInt(sc.next());
							member.memberUpdate(MemberService.memberInfo.getMemberId(), menuNo);
						}else if(menu == 3) {
							member.memberDelete(MemberService.memberInfo.getMemberId());
							run = false;
							break;
						}else if(menu == 4) {
							break;
						}
					}
					break;
				case 2:
					menus.getMenuList();
					break;
				case 3:
					while(true) {
						System.out.println("1.메뉴선택 | 2.결제 | 3.주문취소 | 4.주문내역 | 5.나가기");
						System.out.println("메뉴선택> ");
						int menu = Integer.parseInt(sc.next());
						if(menu == 1) {
							menus.getMenu();
							sale.menuSelec();
						}else if(menu == 2) {
							sale.getSaleAddList();
							sale.saleAdd();
						}else if(menu == 3) {
							sale.saleCancel();
						}else if(menu == 4) {
							sale.getSale();
						}else if(menu == 5) {
							sale.saleDelete();
							break;
						}
					}
					break;
				case 4:
					store.getStore();
					break;
				case 5:
					review.getReviewList();
					break;
				case 6:
					member.logout();
					run = false;
					break;
				}
			}else if(MemberService.memberInfo.getMemberGrade().equals("M")) {
				switch(menuNo) {
				case 1:
					while(true) {
						System.out.println("1.조회 | 2.수정 | 3.탈퇴 | 4.나가기");
						System.out.println("메뉴선택> ");
						int menu = Integer.parseInt(sc.next());
						if(menu == 1) {
							member.getMemberList();
						}else if(menu == 2) {
							System.out.print("수정할 회원 아이디>");
							String memberId = sc.next();
							System.out.println("1.비밀번호 | 2.이름 | 3.전화번호 | 4.주소 | 5.등급");
							int menuNo = Integer.parseInt(sc.next());
							member.memberUpdate(memberId, menuNo);
						}else if(menu == 3) {
							System.out.print("탈퇴시킬 회원 아이디> ");
							String memberId = sc.next();
							member.memberDelete(memberId);
						}else if(menu == 4) {
							break;
						}else {
							System.out.println("잘못입력하였습니다.");
						}
					}
					break;
				case 2:
					while(true) {
						System.out.println("1.조회 | 2.접수 | 3.취소 | 4.나가기");
						System.out.println("메뉴선택> ");
						int menu = Integer.parseInt(sc.next());
						if(menu == 1) {
							sale.getSaleList();
						}else if(menu == 2) {
							sale.saleOrder();
						}else if(menu == 3) {
							sale.saleCancel();
						} else if(menu == 4) {
							break;
						}else {
							System.out.println("잘못입력하였습니다.");
						}
					}
					break;
				case 3:
					sale.getDaySale();
					break;
				case 4:
					while(true) {
						System.out.println("1.조회 | 2.추가 | 3.수정 | 4.삭제 | 5.나가기");
						System.out.println("메뉴선택> ");
						int menu = Integer.parseInt(sc.next());
						if(menu == 1) {
							menus.getMenuList();
						}else if(menu == 2) {
							menus.menuAdd();
						}else if(menu == 3) {
							menus.menuUpdate();
						}else if(menu == 4) {
							menus.menuDelete();
						}else if(menu == 5) {
							break;
						}else {
							System.out.println("잘못입력하였습니다.");
						}
					}
					break;
				case 5:
					while(true) {
						System.out.println("1.조회 | 2.수정 | 3.삭제 | 4.나가기");
						System.out.println("메뉴선택> ");
						int menu = Integer.parseInt(sc.next());
						if(menu == 1) {
							store.getStore();
						}else if(menu == 2) {
							store.storeUpdate();
						}else if(menu == 3) {
							store.storeDelete();
						}else if(menu == 4) {
							break;
						}	else {
							System.out.println("잘못입력하였습니다.");
						}					
					}
					break;
				case 6:
					while(true) {
						answer.getReviewList();
						System.out.println("1.답글작성 | 2.답글수정 | 3.답글삭제 | 4.리뷰삭제 | 5.나가기");
						System.out.println("메뉴선택> ");
						int menu = Integer.parseInt(sc.next());
						if(menu == 1) {
							answer.answerAdd();
						}else if(menu ==2) {
							answer.answerUpdate();
						}else if(menu == 3) {
							answer.answerDelete();
						}else if(menu == 4) {
							answer.reviewDelete();
						}else if(menu == 5) {
							break;
						}
					}
					break;
				case 7:
					member.logout();
					run = false;
					break;				
				}
			}
		}
		
	}
	
	private void menu() {
		if(MemberService.memberInfo.getMemberGrade().equals("U")) {
			System.out.println("1.회원정보 | 2.메뉴조회 | 3.주문 | 4.가게정보 | 5.리뷰 | 6.로그아웃");
		}else if(MemberService.memberInfo.getMemberGrade().equals("M")) {
			System.out.println("1.회원관리 | 2.주문정보 | 3.매출 | 4.메뉴 | 5.가게정보 | 6.리뷰 | 7.로그아웃");
		}
		System.out.println("메뉴선택> ");
		menuNo = Integer.parseInt(sc.next());
	}
}
