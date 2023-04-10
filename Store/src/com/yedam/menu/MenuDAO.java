package com.yedam.menu;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class MenuDAO extends DAO{
	private static MenuDAO menuDao = null;
	private MenuDAO() {
		
	}
	
	public static MenuDAO getInstance() {
		if(menuDao != null) {
			menuDao = new MenuDAO();
		}
		return menuDao;
	}
	
	public List<MenuDTO> getMenuList(){
		List<MenuDTO> list = new ArrayList<>();
		
		return list;
	}
}
