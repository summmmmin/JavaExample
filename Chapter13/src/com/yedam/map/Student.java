package com.yedam.map;

public class Student {
	public int sno;		//학번
	public String sname;//이름
	
	public Student(int sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	@Override
	public int hashCode() {
		return sno + sname.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student) obj;
			return (sno == std.sno) && (sname.equals(std.sname));
		}
		return false;
	}
}
