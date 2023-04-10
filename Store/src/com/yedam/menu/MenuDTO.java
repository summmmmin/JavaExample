package com.yedam.menu;

import lombok.Data;

@Data
public class MenuDTO {
	//메뉴
//	MENU_ID      NOT NULL NUMBER(2)     
//	MENU_NAME    NOT NULL VARCHAR2(30)  
//	MENU_PRICE            NUMBER(6)     
//	MENU_EXPLAIN          VARCHAR2(500) 
	private int menuId;
	private String menuName;
	private int menuPrice;
	private String menuExplain;
}
