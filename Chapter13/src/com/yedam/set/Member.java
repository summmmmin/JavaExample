package com.yedam.set;

public class Member {
	//필드
	String name;
	int age;
	//생성자
	public Member(String name, int age) {
		this.name = name;
		this.age =age;
	}
	@Override
	public int hashCode() {
		
		return name.hashCode()+age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(member.name.equals(name) && member.age == age) {
				return true;
			}
		}
		return false;
	}
	
}
