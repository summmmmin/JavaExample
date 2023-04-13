package com.yedam.review;

import java.util.List;
import java.util.Scanner;

import com.yedam.member.MemberService;

public class AnswerService {
	Scanner sc = new Scanner(System.in);
	public List<ReviewDTO> list = ReviewDAO.getInstance().getReviewList();
	
	public void getReviewList() {
		list = ReviewDAO.getInstance().getReviewList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(i+" | "+list.get(i).getEvaluationMember()+" | "+list.get(i).getEvaluationDate()+" | "+list.get(i).getOrderId());
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
	}
	
	//답글작성
	public void answerAdd() {
		System.out.println("답글 작성할 글 번호를 입력하세요");
		int no = Integer.parseInt(sc.nextLine());
		if(list.get(no).getAnswerId() == null) {
			ReviewDTO review = new ReviewDTO();
			System.out.println("답글을 작성하세요");
			String content = sc.nextLine();
			review.setEvaluationId(list.get(no).getEvaluationId());
			review.setAnswerContent(content);
			review.setAnswerMember(MemberService.memberInfo.getMemberId());
			int result = ReviewDAO.getInstance().answerAdd(review);
			if(result==1) {
				System.out.println("완료");
			}else {
				System.out.println("실패");
			}
		}else {
			System.out.println("답글 작성이 완료된 글입니다.");
		}
	}
	//답글수정
	public void answerUpdate() {
		System.out.println("수정할 글 번호를 입력하세요");
		int no = Integer.parseInt(sc.nextLine());
		
		System.out.println("내용입력>");
		String content = sc.nextLine();
		
		ReviewDTO review = new ReviewDTO();
		review.setAnswerContent(content);
		review.setAnswerId(list.get(no).getAnswerId());
		int result = ReviewDAO.getInstance().answerUpdate(review);
		if(result > 0) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
	}
	//답글삭제
	public void answerDelete() {
		System.out.println("삭제할 글 번호를 입력하세요");
		int no = Integer.parseInt(sc.next());
		
		ReviewDAO.getInstance().answerDelete(list.get(no).getEvaluationId());
		
	}
	//리뷰삭제
	public void reviewDelete() {
		System.out.println("삭제할 글 번호를 입력하세요");
		int no = Integer.parseInt(sc.next());
		
		ReviewDAO.getInstance().reviewDelete(list.get(no).getEvaluationId());
		
	}
}
