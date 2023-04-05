package com.yedam.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet.JSP");
		set.add("Java");
		set.add("iBatis");
		
		int size = set.size();
		System.out.println("총 객체 수 : "+size);
		
		//반복자를 활용한 HashSet 객체 출력
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t"+element);
		}
		
		set.remove("Java");
		set.remove("JDBC");
		System.out.println();
		//향상된 for문
		for(String temp : set) {
			System.out.println("\t" + temp);
		}
		set.clear();
		System.out.println("총 객체 수 : " + set.size());
		
		if(set.isEmpty()) {
			System.out.println("객체가 존재하지 않음.");
		}
	}

}
