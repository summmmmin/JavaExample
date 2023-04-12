package com.yedam.sale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.yedam.member.MemberService;

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
			sale.setSaleMember(MemberService.memberInfo.getMemberId());
			sale.setMenuId(menu);
			sale.setSaledetailQty(qty);
			int result = SaleDAO.getInstance().menuSelec(sale);
			if(result == 1) {
				
			}else {
				System.out.println("선택실패");
			}
		}		
	}
	
	//결제하기
	//선택메뉴출력
	public void getSaleAddList() {
		List<SaleDTO> list = SaleDAO.getInstance().getSaleAddList(MemberService.memberInfo.getMemberId());
		System.out.println("선택한 메뉴:");
		System.out.println("메뉴이름\t|\t수량\t|\t금액");
		int sum=0;
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMenuName()+"\t \t"+list.get(i).getSaledetailQty()+"\t \t"+list.get(i).getSaledetailPrice());
			sum += list.get(i).getSaledetailPrice();
		}
		System.out.println("----------------------------------");
		System.out.println("결제할 금액은 "+sum+"원입니다.");
	}
	//결제선택
	public void saleAdd() {
		System.out.println("1.결제하기 | 2.나가기");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel == 1) {
			SaleDTO sale = new SaleDTO();
			LocalDateTime now = LocalDateTime.now();
			String saleId = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
			sale.setSaleId(saleId);
			sale.setSaleMember(MemberService.memberInfo.getMemberId());
			int result = SaleDAO.getInstance().saleAdd(sale);
			if(result>0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}			
		}else if(sel == 2) {	
		}		
	}
	
	//주문에서 나오면 결제안된 메뉴 삭제
	public void saleDelete() {
		SaleDAO.getInstance().saleDelete(MemberService.memberInfo.getMemberId());
	}
	
	//주문내역(사용자)
	public void getSale() {
		List<SaleDTO> list = SaleDAO.getInstance().getSale(MemberService.memberInfo.getMemberId());
		for(int i=0; i<list.size(); i++) {
			System.out.println("주문번호: "+list.get(i).getSaleId());
			System.out.println("주문일자: "+list.get(i).getSaleDate());
			System.out.println("결제금액 : "+list.get(i).getSum());
			System.out.println("결제상태: "+list.get(i).getSalePay());
			System.out.println("취소상태: "+list.get(i).getSaleCancel());
			System.out.println("접수상태: "+list.get(i).getSaleConfirm());
			List<SaleDTO> list1 = SaleDAO.getInstance().getSaledetail(list.get(i).getSaleId());
			System.out.println();
			System.out.println("메뉴이름\t|\t수량\t|\t가격");
			for(int j=0; j<list1.size(); j++) {
				System.out.println(list1.get(j).getMenuName()+"\t \t"+list1.get(j).getSaledetailQty()+"\t \t"+list1.get(j).getSaledetailPrice());
			}
			System.out.println("_______________________________________________");
		}
	}
	
	//주문내역(관리자)
	public void getSaleList() {
		List<SaleDTO> list = SaleDAO.getInstance().getSaleList();
		for(int i=0; i<list.size(); i++) {
			System.out.println("주문번호: "+list.get(i).getSaleId());
			System.out.println("주문일자: "+list.get(i).getSaleDate());
			System.out.println("주문자: "+list.get(i).getSaleMember());
			System.out.println("결제금액: "+list.get(i).getSum());
			System.out.println("결제: "+list.get(i).getSalePay());
			System.out.println("취소: "+list.get(i).getSaleCancel());
			System.out.println("확인: "+list.get(i).getSaleConfirm());
			List<SaleDTO> list1 = SaleDAO.getInstance().getSaledetail(list.get(i).getSaleId());
			System.out.println();
			System.out.println("메뉴이름\t|\t수량");
			for(int j=0; j<list1.size(); j++) {
				System.out.println(list1.get(j).getMenuName()+"\t \t"+list1.get(j).getSaledetailQty());
			}
			System.out.println("_______________________________________________");
		}		
	}
	
	//주문취소(사용자, 관리자)
	public void saleCancel() {
//		List<SaleDTO> list = SaleDAO.getInstance().getCancelList(MemberService.memberInfo.getMemberId());
//		System.out.println("취소가능한 주문내역");
//		System.out.println();
//		if(list.size()==0) {
//			System.out.println("취소가능한 주문이 없습니다.");
//		}else {
//			for(int i=0; i<list.size(); i++) {
//				System.out.println("주문번호: "+list.get(i).getSaleId());
//				System.out.println("주문일자: "+list.get(i).getSaleDate());
//				System.out.println("결제상태: "+list.get(i).getSalePay());
//				System.out.println("취소상태: "+list.get(i).getSaleCancel());
//				System.out.println("접수확인: "+list.get(i).getSaleConfirm());
//			}			
			SaleDTO sale = new SaleDTO();
			System.out.println("취소할 주문번호를 입력하세요(나가기는 0번)");
			String saleId = sc.nextLine();
			if(saleId.equals(0)) {
				
			}else {
				sale.setSaleId(saleId);
				
				int result=0;
				if(MemberService.memberInfo.getMemberGrade().equals("U")) {
					result = SaleDAO.getInstance().saleCancel(sale);			
				}else if(MemberService.memberInfo.getMemberGrade().equals("M")) {
					result = SaleDAO.getInstance().saleCancelup(sale);
				}
				if(result>0) {
					System.out.println("취소되었습니다");
				}else {
					System.out.println("취소실패");
				}				
			}
//		}
	}
	
	//주문받기(관리자)
	public void saleOrder() {
		SaleDTO sale = new SaleDTO();
		System.out.println("접수할 주문번호를 입력하세요");
		String saleId = sc.nextLine();
		sale.setSaleId(saleId);
		int result = SaleDAO.getInstance().saleOrder(sale);
		if(result>0) {
			System.out.println("접수되었습니다");
		}else {
			System.out.println("접수실패");
		}
	}
	
	//일일매출
	public void getDaySale() {
		System.out.println("1.일일매출 | 2.월매출 | 3.나가기");
		System.out.println("선택> ");
		int menu = Integer.parseInt(sc.next());
		if(menu == 1) {
			SaleDTO sale = SaleDAO.getInstance().getDaySale();
			System.out.println("오늘 매출 : "+sale.getSaleday());			
		}else if(menu == 2) {
			System.out.println("조회할 연도,월을 입력하세요(ex. 23/04)");
			String month = sc.next();
			SaleDTO sale = SaleDAO.getInstance().getMonthSale(month);
			System.out.println("매출 : "+sale.getSalemon());	
		}else if(menu == 3) {
			
		}else {
			System.out.println("잘못입력하였습니다.");
		}
	}
	
	
}
