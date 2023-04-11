package com.yedam.menu;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class MenuDAO extends DAO{
	private static MenuDAO menuDao = null;
	private MenuDAO() {
		
	}
	
	public static MenuDAO getInstance() {
		if(menuDao == null) {
			menuDao = new MenuDAO();
		}
		return menuDao;
	}
	//메뉴조회(전체)
	public List<MenuDTO> getMenuList(){
		List<MenuDTO> list = new ArrayList<>();
		MenuDTO menu = null;
		try {
			conn();
			String sql = "SELECT * FROM menu";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				menu = new MenuDTO();
				
				menu.setMenuId(rs.getInt("menu_id"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuPrice(rs.getInt("menu_price"));
				menu.setMenuExplain(rs.getString("menu_explain"));
				
				list.add(menu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	//메뉴추가
	public int menuAdd(MenuDTO menu) {
		int result = 0;
		try {
			conn();
			String sql = "insert into menu VALUES(MENU_SEQ.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getMenuName());
			pstmt.setInt(2, menu.getMenuPrice());
			pstmt.setString(3, menu.getMenuExplain());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//메뉴수정
	public int menuUpdate(MenuDTO menu, int menuId, int menuNo){
		int result = 0;
		try {
			conn();
			if(menuNo == 1) { //메뉴이름
				String sql = "UPDATE menu SET menu_name=?  where menu_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, menu.getMenuName());			
				pstmt.setInt(2, menuId);
			}else if(menuNo == 2) { //메뉴가격
				String sql = "UPDATE menu SET menu_price=?  where menu_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, menu.getMenuPrice());			
				pstmt.setInt(2, menuId);
			}else if(menuNo == 3) { //메뉴설명
				String sql = "UPDATE menu SET menu_explain=?  where menu_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, menu.getMenuExplain());			
				pstmt.setInt(2, menuId);
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//메뉴삭제
	public int menuDelete(int menuId) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM menu WHERE menu_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, menuId);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
}
