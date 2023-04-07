package com.yedam.customer;

import lombok.Data;

@Data
public class Customer {
//	CUSTOMER_ID    NOT NULL NUMBER       
//	CUSTOMER_PW             VARCHAR2(20) 
//	CUSTOMER_NAME           VARCHAR2(12) 
//	ACCOUNT_ID              NUMBER       
//	CUSTOMER_GRADE          CHAR(1)
	private int customerId;
	private String customerPw;
	private String customerName;
//	private int accountId;
	private String customerGrade;
	
}
