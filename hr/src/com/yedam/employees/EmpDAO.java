package com.yedam.employees;


import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class EmpDAO extends DAO{
	//java -> JDBC -> DB -> Employees Table에 접근
	//Employees 조회, 추가, 수정, 삭제(CRUD)
	
	//singleton
	private static EmpDAO empDao = null;
	private EmpDAO() {
		
	}
	
	public static EmpDAO getInstance() {
		if(empDao == null) {
			empDao = new EmpDAO();
		}
		return empDao;
	}

	//CRUD
	//1.전체조회
	//SELECT * FROM employees;
	//EmpDTO 객체 1개 = 1개의 row
	//list => EmpDTO 객체를 담아서 사용 => 전체 row를 조회
	
	public List<EmpDTO> getEmployeesList(){
		//list, set, map
		//list -> 순서
		
		List<EmpDTO> list = new ArrayList<>();
		//list[0] -> 첫번째 row
		//list[1] -> 두번째 row...
		EmpDTO emp = null;
		
		try {
			conn();
			String sql = "SELECT * FROM employees";
			//select문 사용시
			//1. statement => where 조건이 없으면 쓰기 편함.
			//"SELECT * FROM employees where hire_date" + data
			//2. prparedStatement => where 조건이 있어도 쓰기 편함.
			
			stmt = conn.createStatement();
			
			//SQL 실행
			rs = stmt.executeQuery(sql);
			
			//sql 결과 조회
			//ResultSet -> next() - 다음 row가 존재하면 true, 아니면 false
			while(rs.next()) {
				//서로 다른 row를 서로 다른 객체에 저장하기 위해
				emp = new EmpDTO();
				
				emp.setEmployeeId(rs.getInt("employee_id")); //조회된 결과의 컬럼명
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setHireDate(rs.getDate("hire_date"));
				
				/*문자는 문자열로 받아야됨*/
				
				list.add(emp);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return list;
	}

	//2. 단건 조회
	public EmpDTO getEmployee(int employeeId) {
		EmpDTO emp = null;
		try {
			conn();
			
			String sql = "SELECT * FROM employees "
					+ "WHERE employee_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = new EmpDTO();
				
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setHireDate(rs.getDate("hire_date"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		// emp == null ->  rs.next() == false -> 데이터 조회 X
		// emp != null -> rs.next() == true -> 데이터 조회 O
		return emp;
	}
	
	//3. 추가
	public int empAdd(EmpDTO emp) {
		//데이터 입력 후 제대로 들어갔는지 사용하기 위한 용도
		//1행이 입력되었습니다.
		//result = 1;
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO employees"
					+ "(employee_id, last_name, email, hire_date, job_id)"
					+ " VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getEmail());
			pstmt.setDate(4, emp.getHireDate());
			pstmt.setString(5, emp.getJobId());
			
			//DML 사용할 때 쓰는 메소드
			//반환값 1 또는 0
			//1: 데이터 정상 입력
			//0: 데이터 입력 안됨
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//4. 수정
	public int empUpdate(EmpDTO emp) {
		int result = 0;
		try {
			conn();
			String sql = "update employees set salary = ? where employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, emp.getSalary());
			pstmt.setInt(2,  emp.getEmployeeId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	
	//5. 삭제
	public int empDelete(int employeeId) {
		int result = 0;
		try {
			conn();
			
			String sql = "delete from employees where employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
}
