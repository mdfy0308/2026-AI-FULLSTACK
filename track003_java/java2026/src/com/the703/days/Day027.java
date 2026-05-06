package com.the703.days;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class UserInfo {
	private  String name; 
	private  int age;
	
	public UserInfo() { super(); }
	public UserInfo(String name) { super(); this.name = name; }
	public UserInfo(String name, int age) { super(); this.name = name; this.age = age; }
	
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + "]";
	}
	public String getName() { return name; } 
	public void setName(String name) { this.name = name; } 
	public int getAge() { return age; } 
	public void setAge(int age) { this.age = age;}
	
	@Override public int hashCode() { return Objects.hash(age, name); } 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		return Objects.equals(name, other.name);
	}
}
 
public class Day027 {
	public static void main(String[] args) { 
		
		//Q2.  ArrayList, HashSet 을 작성하시오.
		// 2. users ArrayList 만들기 
		List<UserInfo> user = new ArrayList<>();
		
		// 3. 다음의 데이터 넣기
		user.add(new UserInfo("아이언맨" , 50));
		user.add(new UserInfo("헐크" , 40));
		user.add(new UserInfo("캡틴" , 120));
		user.add(new UserInfo("캡틴" , 120));
		
		// 4. for+size 이용해서  데이터 출력		
		for(int i=0;i<user.size();i++) { // size 갯수
			UserInfo u = user.get(i);	 // get(번호) 꺼내오기
			System.out.printf("%d %s %d\n", (i+1), u.getName(), u.getAge());
		}
		
		System.out.println();
		
		// 5. sets  HashSet 만들기
		Set<UserInfo> user2 = new HashSet<>();
		
		// 6. 다음의 데이터 넣기
		user2.add(new UserInfo("아이언맨" , 50));
		user2.add(new UserInfo("헐크" , 40));
		user2.add(new UserInfo("캡틴" , 120));
		user2.add(new UserInfo("캡틴" , 120));
		
		// 7. Iterator 이용해서 데이터 출력
		int cnt = 0;
		for(UserInfo u : user2) { System.out.printf("%d %s %d\n", ++cnt, u.getName(), u.getAge()); }

	} //
} //

/*

1. 콜렉션프레임워크
- [ ##1. 배열 ]의 단점을 개선한 클래스 [##2. 객체 ]만 저장가능   
- 저장공간의 크기를 [##3. 동적 ]으로 관리함. → 동적배열

String [] 		arr  = new String[100];	 	→ 자료형, 갯수 고정
List<class> 	list = new ArrayList<>();	→ 내가 원하는 객체(틀), 갯수 무한대

2. 핵심 인터페이스 [##4. 3개 : List, Set, Map]
- 인터페이스를 통해서 틀이 잡혀 있는 방법으로 
  다양한 컬렉션 클래스를 이용함.

List : ##5. 기차   인덱스여부 [ 순서 : O ],  중복허용여부 [ O ], 
	 [ add, get, size, remove, contains ] 

Set  : ##6. 주머니  인덱스여부 [ 순서 : X ],  중복허용여부[ X ], 
	 [ add, 향상된 for/Iterator, size, remove, contains ] 

Map  : ##7. 사전   [ 키:값 ] - 쌍(Entry), 
	 [ put, get(key), size, remove, contains ] 
*/
