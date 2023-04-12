package com.yedam.review;

import java.sql.Date;

import lombok.Data;
@Data
public class ReviewDTO {
//	EVALUATION_ID      NOT NULL NUMBER(10)    
//	ORDER_ID                    VARCHAR2(14)  
//	EVALUATION_DATE             DATE          
//	EVALUATION_TITLE            VARCHAR2(300) 
//	EVALUATION_CONTENT          VARCHAR2(300) 
	
	private int evaluationId;
	private String orderId;
	private Date evaluationDate;
	private String evaluationTitle;
	private String evaluationContent;
	
	private String memberId; //조인할 아이디
}
