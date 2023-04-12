package com.yedam.sale;

import java.sql.Date;

import lombok.Data;
@Data
public class SaleDTO {
//	SALE_ID      NOT NULL NUMBER(10)   
//	SALE_MEMBER           VARCHAR2(15) 
//	SALE_DATE             DATE           
//	SALE_PAY              VARCHAR2(15) 
//	SALE_CANCEL           VARCHAR2(15) 
//	SALE_CONFIRM          VARCHAR2(15) 
	
	private String saleId;
	private Date saleDate;
	private String salePay;
	private String saleCancel;
	private String saleConfirm;
	
//	SALEDETAIL_ID    NOT NULL NUMBER(10)   
//	SALE_ID                   NUMBER(10)   
//	SALE_MEMBER               VARCHAR2(15) 
//	SALEDETAIL_MENU           NUMBER       
//	SALEDETAIL_QTY            NUMBER       
//	SALEDETAIL_PRICE          NUMBER 
	private int saledetailId;
	private String saleMember; //회원아이디
	private int menuId; //메뉴아이디
	private int saledetailQty;
	private int saledetailPrice;
	
	private String menuName; //조인하는 메뉴이름
	private int sum; //총결제금액
	
	private int saleday; //일일매출
	private int salemon; //월매출
}
