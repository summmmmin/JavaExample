package com.yedam.member;

import java.util.List;
import java.util.Scanner;

public class MemberService {
	Scanner sc= new Scanner(System.in);
	//로그인 정보
	public static MemberDTO memberInfo = null;
	
	//로그인
	public void login() {
		MemberDTO member = new MemberDTO();
		
		System.out.print("ID> ");
		String id = sc.next();
		
		System.out.print("PW> ");
		String pw = sc.next();
		
		member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(pw.equals(member.getMemberPw())) {
				System.out.println(member.getMemberName()+"님 환영합니다");
				memberInfo = member;
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}else {
			System.out.println("아이디가 틀렸습니다.");
		}
	}
	
	//로그아웃
	public void logout() {
		if(memberInfo != null) {
			memberInfo = null;
			System.out.println("로그아웃되었습니다.");
		}
	}
	
	//회원가입
//	public void memberAdd() {
//		MemberDTO member = new MemberDTO();
//		//아이디
//		while(true) {
//			System.out.print("아이디(4자이상)>");
//			String id = sc.next();
//			if(id.length()>=4){
//				while(true) {
//					if(MemberDAO.getInstance().getMemberId(id).getCount() ==0 ) {
//						System.out.print("비밀번호(4자이상)>");
//						String pw = sc.next();
//						if(pw.length()>=4) {
//							while(true) {
//								System.out.print("비밀번호 확인>");
//								String pwcheck = sc.next();
//								if(pwcheck.equals(pw)) {
//									System.out.print("이름>");
//									String name = sc.next();
//									System.out.print("번호>");
//									String phone = sc.next();
//									System.out.print("주소>");
//									String addr = sc.next();
//									
//									member.setMemberId(id);
//									member.setMemberPw(pw);
//									member.setMemberName(name);
//									member.setMemberPhone(phone);
//									member.setMemberAddr(addr);
//									
//									int result = MemberDAO.getInstance().memberAdd(member);
//									if(result == 1) {
//										System.out.println("회원가입 완료");
//									}else {
//										System.out.println("회원가입 실패");
//									}
//									break;
//								}else {
//									System.out.println("비밀번호가 다릅니다.");
//								}
//							}
//							break;
//						}else {
//							System.out.println("4자이상 입력하세요.");
//						}
//						break;
//					}
//				}else {
//					System.out.println("중복하는 아이디입니다. 다시입력하세요.");
//				}break;		
//			}else {
//				System.out.println("4자이상 입력하세요.");
//			}
//			
//		}
//	}
	
//	public void memberAdd() {
//		MemberDTO member = new MemberDTO();
//		while(true) {
//			System.out.print("아이디(4자이상)>");
//			String id = sc.next();
//			if(id.length()>=4){
//				while(true) {
//					if(MemberDAO.getInstance().getMemberId(id).getCount() ==0 ) {
//						System.out.print("비밀번호(4자이상)>");
//						String pw = sc.next();
//						while(true) {
//							if(pw.length()>=4) {
//								while(true) {
//									System.out.print("비밀번호 확인>");
//									String pwcheck = sc.next();
//									if(pwcheck.equals(pw)) {
//										System.out.print("이름>");
//										String name = sc.next();
//										System.out.print("번호>");
//										String phone = sc.next();
//										System.out.print("주소>");
//										String addr = sc.next();
//										
//										member.setMemberId(id);
//										member.setMemberPw(pw);
//										member.setMemberName(name);
//										member.setMemberPhone(phone);
//										member.setMemberAddr(addr);
//										
//										int result = MemberDAO.getInstance().memberAdd(member);
//										if(result == 1) {
//											System.out.println("회원가입 완료");
//										}else {
//											System.out.println("회원가입 실패");
//										}
//										break;
//									}else {
//										System.out.println("비밀번호가 다릅니다.");
//									}
//								}
//								break;
//							}else {
//								System.out.println("4자이상 입력하세요.");
//							}
//						}
//						break;
//					}else {
//						System.out.println("중복하는 아이디입니다. 다시입력하세요.");
//						break;
//					}
//				}
//				break;
//			}else {
//				System.out.println("4자이상 입력하세요.");
//			}
//		}
//	}
	
	public void memberAdd() {
		MemberDTO member = new MemberDTO();
		boolean run = true;
		while(run) {
			System.out.print("아이디(4자이상)>");
			String id = sc.next();
			if(id.length()>=4){
				while(run) {
					if(MemberDAO.getInstance().getMemberId(id).getCount() ==0 ) {
						System.out.print("비밀번호(4자이상)>");
						String pw = sc.next();
						while(run) {
							if(pw.length()>=4) {
								while(run) {
									System.out.print("비밀번호 확인>");
									String pwcheck = sc.next();
									if(pwcheck.equals(pw)) {
										System.out.print("이름>");
										String name = sc.next();
										System.out.print("번호>");
										String phone = sc.next();
										System.out.print("주소>");
										String addr = sc.next();
										
										member.setMemberId(id);
										member.setMemberPw(pw);
										member.setMemberName(name);
										member.setMemberPhone(phone);
										member.setMemberAddr(addr);
										
										int result = MemberDAO.getInstance().memberAdd(member);
										if(result == 1) {
											System.out.println("회원가입 완료");
										}else {
											System.out.println("회원가입 실패");
										}
										run = false;
									}else {
										System.out.println("비밀번호가 다릅니다.");
										break;
									}
								}
								
							}else {
								System.out.println("4자이상 입력하세요.");
								break;
							}
						}
						
					}else {
						System.out.println("중복하는 아이디입니다. 다시입력하세요.");
						break;
					}
				}
			
			}else {
				System.out.println("4자이상 입력하세요.");
			}
		}
	}
	
	//회원정보조회(사용자)
	public void getmember() {
		MemberDTO member = MemberDAO.getInstance().login(memberInfo.getMemberId());
		System.out.println("아이디   : "+member.getMemberId());
		System.out.println("비밀번호 : "+member.getMemberPw());
		System.out.println("이름    : "+member.getMemberName());
		System.out.println("전화번호 : "+member.getMemberPhone());
		System.out.println("주소    : "+member.getMemberAddr());
		System.out.println("-------------------------------------");
	}
	
	//회원정보조회(관리자)
	public void getMemberList() {
		List<MemberDTO> list =MemberDAO.getInstance().getMemberList();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("아이디   : "+list.get(i).getMemberId());
			System.out.println("비밀번호 : "+list.get(i).getMemberPw());
			System.out.println("등급    : "+list.get(i).getMemberGrade());
			System.out.println("이름    : "+list.get(i).getMemberName());
			System.out.println("전화번호 : "+list.get(i).getMemberPhone());
			System.out.println("주소    : "+list.get(i).getMemberAddr());
			System.out.println("-------------------------------------");
		}
	}
	//회원정보 수정
	public void memberUpdate(String memberId, int menuNo) {
		MemberDTO member = new MemberDTO();
		
		int result = 0;
		if(MemberService.memberInfo.getMemberGrade().equals("M")) {
			if(menuNo == 5) {
				System.out.println("등급변경");
				System.out.println("1. 사용자  |  2. 관리자");
				int select = Integer.parseInt(sc.nextLine());
				if(select == 1) {
					member.setMemberGrade("U");
				}else if(select ==2) {
					member.setMemberGrade("M");
				}else {
					System.out.println("변경되지않았습니다");
				}			
			}		
		}
		if(menuNo == 1) {
			System.out.println("새로운 비밀번호를 입력하세요.");
			String pw = sc.next();
			member.setMemberPw(pw);
		}else if(menuNo == 2) {
			System.out.println("변경할 이름을 입력하세요");
			String name = sc.next();
			member.setMemberName(name);
		}else if(menuNo == 3) {
			System.out.println("변경할 번호를 입력하세요");
			String phone = sc.next();
			member.setMemberPhone(phone);
		}else if(menuNo == 4) {
			System.out.println("변경할 주소를 입력하세요");
			String addr = sc.next();
			member.setMemberAddr(addr);
		}
		result = MemberDAO.getInstance().memberUpdate(member, memberId, menuNo);
		if(result > 0) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
	}
	
	//회원탈퇴
	public void memberDelete(String memberId) {
		int result = MemberDAO.getInstance().memberDelete(memberId);
		if(result > 0) {
			System.out.println("정상 탈퇴");
		}else {
			System.out.println("탈퇴 실패");
		}
	}
}
