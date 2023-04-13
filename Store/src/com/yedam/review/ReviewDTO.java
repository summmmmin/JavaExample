package com.yedam.review;

import java.sql.Date;

import lombok.Data;
@Data
public class ReviewDTO {
//	EVALUATION_ID      NOT NULL NUMBER(10)    
//	ORDER_ID                    VARCHAR2(14)  
//	EVALUATION_DATE             DATE          
//	EVALUATION_MEMBER           VARCHAR2(15)  
//	EVALUATION_CONTENT          VARCHAR2(300) 
	private int evaluationId;
	private String orderId;
	private Date evaluationDate;
	private String evaluationMember;
	private String evaluationContent;
	
//	ANSWER_ID      NOT NULL NUMBER(10)    
//	EVALUATION_ID           NUMBER(10)    
//	ANSWER_MEMBER           VARCHAR2(15)  
//	ANSWER_DATE             DATE          
//	ANSWER_CONTENT          VARCHAR2(300) 
	private String answerId;
	private String answerMember;
	private Date answerDate;
	private String answerContent;
	
	private int count;
}
