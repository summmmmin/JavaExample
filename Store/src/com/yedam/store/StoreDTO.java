package com.yedam.store;

import lombok.Data;

@Data
public class StoreDTO {
	//가게정보
//	STORE_NAME  NOT NULL VARCHAR2(40) 
//	STORE_PHONE          VARCHAR2(13) 
//	STORE_ADDR           VARCHAR2(90) 
//	STORE_HOUR           VARCHAR2(20) 
	
	private String storeName;
	private String storePhone;
	private String storeAddr;
	private String storeHour;
	
	
}
