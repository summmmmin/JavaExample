package com.yedam.review;

import java.util.List;
import java.util.Scanner;

import com.yedam.member.MemberService;

public class Review1Service {
	Scanner sc = new Scanner(System.in);
	
	public void getReviewList() {
		List<Review1DTO> list = Review1DAO.getInstance().getReviewList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(i+" | "+list.get(i).getEvaluationTitle());
		}
		System.out.println("1. 글보기 | 2.리뷰작성 | 3.나가기");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel == 1) {
			System.out.println("선택할 글 번호를 입력하세요");
			int no = Integer.parseInt(sc.nextLine());
			Review1DTO review = new Review1DTO();
			review = list.get(no);
			System.out.println(review);
			System.out.println(list.get(no).getEvaluationTitle());
			System.out.println("-----------------------------");
			System.out.println(list.get(no).getOrderId()+" | "+list.get(no).getEvaluationDate()+" | "+list.get(no).getMemberId());
			System.out.println("-----------------------------");
			System.out.println(list.get(no).getEvaluationContent());
			System.out.println();
			if(list.get(no).getMemberId().equals(MemberService.memberInfo.getMemberId())) {
				System.out.println("1. 나가기 | 2.수정 | 3.삭제");
				int selno = Integer.parseInt(sc.nextLine());
				if(selno == 1) {
					
				}else if(selno ==2) {
//					ReviewDTO review = new ReviewDTO();
//					System.out.println("1.제목 수정 | 2.내용 수정 | 3.나가기");
//					int menuNo = Integer.parseInt(sc.nextLine());
//					int result = 0;
//					if(menuNo ==1) {
//						System.out.println("제목입력>");
//						String title = sc.nextLine();
//						review.setEvaluationTitle(title);
////						review.setEvaluationId();
//						ReviewDAO.getInstance().reviewUpdate(review, 1);
//						
//					}else if(menuNo == 2) {
//						System.out.println("내용입력>");
//						String content = sc.nextLine();
//						review.setEvaluationTitle(content);
//						ReviewDAO.getInstance().reviewUpdate(review, 2);
//					}else if(menuNo == 3) {
//						
//					}
				}else if(selno == 3) {
					
				}
			}
		}else if(sel == 2) {
			
		}else if(sel == 3) {
			
		}
	}
}
