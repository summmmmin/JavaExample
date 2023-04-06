package com.yedam.member;

import java.util.List;
import java.util.Scanner;

public class MemberService {
	//impl = service
	//로그인이 되어있나 안되어있나
	//로그인은 메뉴를 이동할때마다 그 로그인 정보가 남아있어야한다.
	//정적멤버(static)
	//1. login
	//login 성공
	//login -> id/pw입력 -> 정보 조회 성공 ->로그인
	//로그인 -> 정적필드에게 로그인한 정보를 입력
	//login 실패
	//정보 조회 실패 -> 정적필드에 데이터 넣지않음
	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);
	public void login() {
		//id입력
		System.out.println("ID>");
		String id = sc.nextLine();
		
		System.out.println("PW>");
		String pw = sc.nextLine();
		
		//1. member == null(id가 없다)
		//2. member != null(회원정보가 있다)
		Member member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(member.getPw().equals(pw)) {
				System.out.println("정상 로그인 되었습니다.");
				System.out.println(member.getName()+"님 환영합니다.");
				memberInfo = member;
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
			
		} else {
			System.out.println("아이디가 존재하지 않습니다.");
		}
	}
	
	public void logout() {
		memberInfo = null;
		System.out.println("로그아웃성공");
	}
	
	//전체 조회
	public void getMemberList() {
		List<Member> list = MemberDAO.getInstance().getMemberList();
		
		for(Member member : list) {
			System.out.println("ID : " + member.getId());
			System.out.println("PW : " + member.getPw());
			System.out.println("NM : " + member.getName());
		} 
	}
	
	//회원 등록
	public void memberAdd() {
		String id = "";
		while(true) {
			System.out.println("ID>");
			id = sc.nextLine();
			Member member = MemberDAO.getInstance().login(id);
			if(member == null) {
				System.out.println("회원 가입 가능");
				break;
			} else {
				System.out.println("ID 중복, 재입력");
			}
		}
		
		System.out.println("PW>");
		String pw = sc.nextLine();
		System.out.println("이름>");
		String name = sc.nextLine();
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		
		int result = MemberDAO.getInstance().memberAdd(member);
		
		if(result == 1) {
			System.out.println("회원 등록 성공");
		}else {
			System.out.println("회원 등록 실패");
		}
	}
	
	//회원 수정
	//login 되어있는 정보를 수정하는지 -> 실시간으로 로그인된 정보도 바꿔야함.
	//login 안되어있는 정보를 수정하는지
	public void memberUpdate() {
		System.out.println("ID>");
		String id = sc.nextLine();
		System.out.println("PW>");
		String pw = sc.nextLine();
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		int result = MemberDAO.getInstance().memberUpdate(member);
		
		if(result > 0) {
			//DB에 업데이트성공시
			//실시간으로 로그인된 정보도 바꿔야한다.
			if(id.equals(memberInfo.getId())) {
				memberInfo = MemberDAO.getInstance().login(id);
			}
		}else {
			System.out.println("PW 변경 실패");
		}
	}
	
	
	//회원 삭제
	public void memberDelete() {
		System.out.println("삭제 ID>");
		String id = sc.nextLine();
		
		int result = MemberDAO.getInstance().memberDelete(id);
		
		if(result>0) {
			if(id.equals(memberInfo.getId())) {
				memberInfo = null;
				
			}
		}else {
			System.out.println("삭제 완료");
		}
	}
}
