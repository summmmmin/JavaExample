package com.yedam.deartments;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class DptDAO extends DAO {
	private static DptDAO dptDao = null;
	
	private DptDAO() {
		
	}
	
	public static DptDAO getInstance() {
		if(dptDao == null) {
			dptDao = new DptDAO();
		}
		return dptDao;
	}
	
	//전체조회
	public List<DptDTO> getDepartmentsList(){
		List<DptDTO> list = new ArrayList<>();
		
		DptDTO dpt = null;
		try {
			conn();
			String sql = "SELECT * FROM departments";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				dpt = new DptDTO();

				dpt.setDepartmentId(rs.getInt("department_id"));
				dpt.setDepartmentName(rs.getString("department_name"));
				dpt.setManagerId(rs.getInt("manager_id"));
				dpt.setLocationId(rs.getInt("location_id"));
				
				list.add(dpt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	//단건조회
	public DptDTO getDeparment(int departmentId) {
		DptDTO dpt = null;
		try {
			conn();
			
			String sql = "SELECT * FROM departments WHERE department_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	departmentId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dpt = new DptDTO();
				
				dpt.setDepartmentId(rs.getInt("department_id"));
				dpt.setDepartmentName(rs.getString("department_name"));
				dpt.setManagerId(rs.getInt("manager_id"));
				dpt.setLocationId(rs.getInt("location_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return dpt;
	}
	//생성
	public int dptAdd(DptDTO dpt) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO departments(department_id, department_name) VALUES (?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dpt.getDepartmentId());
			pstmt.setString(2, dpt.getDepartmentName());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	//수정
	public int dptUpdate(DptDTO dpt) {
		int result =0;
		try {
			conn();
			String sql = "UPDATE departments SET manager_id=? WHERE department_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dpt.getManagerId());
			pstmt.setInt(2, dpt.getDepartmentId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	//삭제
	public int dptDelete(int departmentId) {
		int result =0;
		try {
			conn();
			String sql = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentId);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
