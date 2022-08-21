package com.test.toy;

public class Test {

	public static void main(String[] args) {
		
		Student s = new Student();
		
		s.setName("홍길동");
		s.setAge("20");
		s.setAddress("서울시");
		
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getAddress());
		
		System.out.println(s.toString());
	

	}

}
