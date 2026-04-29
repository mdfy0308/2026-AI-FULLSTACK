package com.the703.basic014;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//1. 클래스는 부품객체
//2. 상태(멤버변수-클래스/인스턴스 변수)와 행위(멤버함수)

class UserDto {  
	
	//멤버 변수
	private static int cnt = 0; // 클래스 변수 - method area - 공용
	private final int no; 		// final은 수정X
	private String email;		// 인스턴스 변수 - heap area - new - 생성자 - this
	
								
	//멤버 함수					// 기본값 - 명시적 초기화 - 초기화블록 - 생성자
	// alt + shift + s
	public UserDto() { this.no = ++cnt; } // 유저번호 = 값 ; 값 1개 증가 + 값 넣음 
	public UserDto(int no, String email) { super(); this.no = no; this.email = email; }
	public UserDto(String email) {  this(); this.email = email; }
	
	@Override
	public String toString() { return "UserDto [no=" + no + ", email=" + email + "]"; }
	public static int getCnt() { return cnt; }
	public static void setCnt(int cnt) { UserDto.cnt = cnt; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public int getNo() { return no; }
	
	//1. 클래스가 맞는지 확인
	@Override
	public int hashCode() {
		return Objects.hash(email); // 객체들의 값
	}
	
	//2. 객체 안의 값이 같은지 확인
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(email, other.email);
	}
}

public class List002 {
	public static void main(String[] args) {
		// add, get, size, remove, contains
		List<UserDto> users = new ArrayList<>();
		users.add( new UserDto("aaa@gmail.com") ); // 주소값, 이메일을 여기에 넣었다면
		users.add( new UserDto("bbb@gmail.com") );
		
		System.out.println(users);
		System.out.println("1. get > " + users.get(0));
		System.out.println("2. size > " + users.size());
		System.out.println("3. remove > " + users.remove(1));
		System.out.println("4. contains > " + users.contains(new UserDto("aaa@gmail.com"))); //이쪽에도 이메일
		System.out.println("5. contains > " + users.contains(new UserDto("bbb@gmail.com")));
		
		UserDto dto = users.get(0);
		System.out.println("INFO" + (0+1) + " : " + dto.getNo() + "/" + dto.getEmail());
		
		int cnt=0;
		for(UserDto use : users) { 
			System.out.println("INFO" + (cnt++ +1) + " : " + use.getNo() + "/" + use.getEmail());
		}
		
	}//
}//
