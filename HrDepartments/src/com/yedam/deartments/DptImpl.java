package com.yedam.deartments;

import java.util.List;
import java.util.Scanner;

public class DptImpl {
	Scanner sc = new Scanner(System.in);
	
	//전체 조회
	public void getDepartmentsList() {
		List<DptDTO> list = DptDAO.getInstance().getDepartmentsList();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("부서번호 : "+list.get(i).getDepartmentId());
			System.out.println("부서이름 : "+list.get(i).getDepartmentName());
			System.out.println("메니저번호 : "+list.get(i).getManagerId());
			System.out.println("위치번호 : "+list.get(i).getLocationId());
		}
	}
	
	//단건 조회
	public void getDeparment() {
		System.out.print("조회할 부서>");
		int departmentId = Integer.parseInt(sc.next());
		DptDTO dpt = DptDAO.getInstance().getDeparment(departmentId);
		
		if(dpt == null) {
			System.out.println("해당 부서는 존재하지않습니다");
		}else {
			System.out.println("부서번호 : "+dpt.getDepartmentId());
			System.out.println("부서이름 : "+dpt.getDepartmentName());
			System.out.println("메니저번호 : "+dpt.getManagerId());
			System.out.println("위치번호 : "+dpt.getLocationId());
		}
	}
	
	//추가
	public void dptAdd() {
		DptDTO dpt = new DptDTO();
		
		System.out.print("부서번호>");
		int dptId = Integer.parseInt(sc.next());
		System.out.print("부서이름>");
		String dptName = sc.next();
		
		dpt.setDepartmentId(dptId);
		dpt.setDepartmentName(dptName);
		
		int result = DptDAO.getInstance().dptAdd(dpt);
		
		if(result ==1) {
			System.out.println("데이터 입력 성공");
		}else {
			System.out.println("데이터 입력 실패");
		}
	}
	
	//수정
	public void dptUpdate() {
		DptDTO dpt = new DptDTO();
		System.out.println("부서번호>");
		int dptId = Integer.parseInt(sc.nextLine());
		System.out.print("수정 managerid>");
		int managerId = Integer.parseInt(sc.nextLine());
		
		dpt.setDepartmentId(dptId);
		dpt.setManagerId(managerId);
		
		int result = DptDAO.getInstance().dptUpdate(dpt);
		
		if(result>0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	}
	
	//삭제
	public void dptDelete() {
		System.out.println("삭제 부서>");
		int dptId = Integer.parseInt(sc.nextLine());
		
		int result = DptDAO.getInstance().dptDelete(dptId);
		if(result>0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}
	
}
