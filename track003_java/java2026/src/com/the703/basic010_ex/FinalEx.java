package com.the703.basic010_ex;

// 다음코드에서 오류나는 부분을 찾아 주석달고 이유를 적으시오.

class User002 {
	final String nation = "Korea"; // 상수, 명시
	final String jumin; // 상수
	String name;

	public User002() {
		jumin = "00000"; // 값을 넣어줌
	}

	public User002(String jumin, String name) {
		this.jumin = jumin;
		this.name = name;
	}
}

public class FinalEx {
	public static void main(String[] args) {
		User002 user1 = new User002("123456-1234567", "아이유");
		System.out.println(user1);

		//user1.nation = "USA";  → final 상수 값 재할당 불가
		//user1.jumin = "123123-1234321"; → final 상수 값 재할당 불가
		
		user1.name = "IU";
		System.out.println(user1);
	}
}