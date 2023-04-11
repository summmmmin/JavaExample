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
	
	private int saleId;
	private String saleMember;
	private Date saleDate;
	private String salePay;
	private String saleCancel;
	private String saleConfirm;
	
//	SALEDETAIL_ID    NOT NULL NUMBER(10) 
//	SALE_ID                   NUMBER(10) 
//	MENU_ID                   NUMBER     
//	SALEDETAIL_QTY            NUMBER     
//	SALEDETAIL_PRICE          NUMBER  
	private int saledetailId;
	private int menuId;
	private int saledetailQty;
	private int saledetailPrice;
}
