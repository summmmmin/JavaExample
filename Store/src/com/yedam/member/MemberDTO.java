package com.yedam.member;

import lombok.Data;

@Data
public class MemberDTO {
//	MEMBER_ID    NOT NULL VARCHAR2(15) 
//	MEMBER_PW    NOT NULL VARCHAR2(20) 
//	MEMBER_GRADE          CHAR(1)      
//	MEMBER_NAME  NOT NULL VARCHAR2(15) 
//	MEMBER_PHONE NOT NULL VARCHAR2(13) 
//	MEMBER_ADDR           VARCHAR2(90) 
	
	private String memberId;
	private String memberPw;
	private String memberGrade;
	private String memberName;
	private String memberPhone;
	private String memberAddr;
	
	private int count;
}
