package com.yedam.store;

import com.yedam.common.DAO;

public class StoreDAO extends DAO{
	private static StoreDAO storeDao = null;
	private StoreDAO() {
		
	}
	
	public static StoreDAO getInstance() {
		if(storeDao == null) {
			storeDao = new StoreDAO();
		}
		return storeDao;
	}
	
	//가게정보조회
	public StoreDTO getStore() {
		StoreDTO store = null;
		try {
			conn();
			
			String sql = "SELECT * FROM store";
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				store = new StoreDTO();
				store.setStoreName(rs.getString("store_name"));
				store.setStorePhone(rs.getString("store_phone"));
				store.setStoreAddr(rs.getString("store_addr"));
				store.setStoreHour(rs.getString("store_hour"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return store;
	}
	
	//가게정보수정
	public int storeUpdate(StoreDTO store, int menuNo) {
		int result = 0;
		try {
			conn();
			if(menuNo == 1) {
				String sql = "UPDATE store SET store_name=?  where store_id = 1";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, store.getStoreName());				
			}else if(menuNo == 2) {
				String sql = "UPDATE store SET store_phone=?  where store_id = 1";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, store.getStorePhone());
			}else if(menuNo == 3) {
				String sql = "UPDATE store SET store_addr=?  where store_id = 1";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, store.getStoreAddr());
			}else if(menuNo == 4) {
				String sql = "UPDATE store SET store_hour=?  where store_id = 1";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, store.getStoreHour());
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//가게정보삭제
	public int storeDelete(StoreDTO store, int menuNo) {
		int result = 0;
		try {
			conn();
			if(menuNo == 1) {
				String sql = "UPDATE store SET store_name=' '  where store_id = 1";
				pstmt = conn.prepareStatement(sql);			
			}else if(menuNo == 2) {
				String sql = "UPDATE store SET store_phone=' '  where store_id = 1";
				pstmt = conn.prepareStatement(sql);
			}else if(menuNo == 3) {
				String sql = "UPDATE store SET store_addr=' '  where store_id = 1";
				pstmt = conn.prepareStatement(sql);
			}else if(menuNo == 4) {
				String sql = "UPDATE store SET store_hour=' '  where store_id = 1";
				pstmt = conn.prepareStatement(sql);
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
