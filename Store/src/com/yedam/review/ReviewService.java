package com.yedam.review;

import java.util.List;
import java.util.Scanner;

import com.yedam.member.MemberService;
import com.yedam.sale.SaleService;

public class ReviewService {
	Scanner sc = new Scanner(System.in);
	public ReviewDTO reviewsel = null;
	
	public void getReviewList() {
		while(true) {
		List<ReviewDTO> list = ReviewDAO.getInstance().getReviewList();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(i+" | "+list.get(i).getEvaluationMember()+" | "+list.get(i).getEvaluationDate()+" | "+list.get(i).getOrderId());
			if(list.get(i).getEvaluationMember().equals(MemberService.memberInfo.getMemberId())) {
				System.out.println("\t \t \t \t수정 | 삭제 ");
			}
			System.out.println(list.get(i).getEvaluationContent());
			if(list.get(i).getAnswerId() != null ) {
				System.out.println("- - - - - - - - - - - - - - - - - - - - -");
				System.out.println("답글");
				System.out.println(list.get(i).getAnswerDate());
				System.out.println(list.get(i).getAnswerContent());				
			}
			System.out.println();
			System.out.println("______________________________________________");
		}
			System.out.println("\n1. 나가기 | 2. 리뷰작성 | 3. 리뷰수정 | 4. 삭제");
			int sel = Integer.parseInt(sc.nextLine());
			if(sel == 1) {
				break;
			}else if(sel == 2) {
				SaleService sale = new SaleService();
				sale.getSalereview();
				System.out.println("리뷰 작성할 주문번호를 입력하세요");
				String order = sc.nextLine();
				ReviewDTO review = ReviewDAO.getInstance().getCount(order);
				if(review.getCount()==0) {
					System.out.println("리뷰를 작성해주세요");
					String content = sc.nextLine();
					review.setOrderId(order);
					review.setEvaluationMember(MemberService.memberInfo.getMemberId());
					review.setEvaluationContent(content);
					
					int result = ReviewDAO.getInstance().reviewAdd(review);
					if(result==1) {
						System.out.println("완료");
					}else {
						System.out.println("실패");
					}
				}else {
					System.out.println("이미 작성한 주문번호입니다.");
				}
				
			}else if(sel == 3) {
				System.out.println("수정할 글 번호를 입력하세요");
				int no = Integer.parseInt(sc.nextLine());
				reviewsel = list.get(no);
				if(reviewsel.getEvaluationMember().equals(MemberService.memberInfo.getMemberId())) {
					ReviewDTO review = new ReviewDTO();
					System.out.println("내용입력>");
					String content = sc.nextLine();
					review.setEvaluationContent(content);
					review.setEvaluationId(reviewsel.getEvaluationId());
					int result = ReviewDAO.getInstance().reviewUpdate(review);
					if(result > 0) {
						System.out.println("수정성공");
					}else {
						System.out.println("수정실패");
					}
				}else {
					System.out.println("다른 사람이 쓴 글입니다.");
				}
				
				
			}else if(sel == 4) {
				System.out.println("삭제할 글 번호를 입력하세요");
				int no = Integer.parseInt(sc.next());
				reviewsel = list.get(no);
				if(reviewsel.getEvaluationMember().equals(MemberService.memberInfo.getMemberId())) {		
					ReviewDAO.getInstance().reviewDelete(reviewsel.getEvaluationId());
				}else {
					System.out.println("다른 사람이 쓴 글입니다.");
				}
				
			}			
		}
		
	}
}
