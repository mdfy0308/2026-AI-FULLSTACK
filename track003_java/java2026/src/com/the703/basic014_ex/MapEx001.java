package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx001 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new HashMap<>();
		String name = "";
		
		map.put("피구왕", "통키");
		map.put("제빵왕", "김탁구");
		map.put("요리왕", "비룡");
		
		System.out.println(map);
		
		System.out.println("=====================");
		System.out.println("KING\tNAME");
		System.out.println("=====================");
		
		for(Entry<String, String> m : map.entrySet()) {
			System.out.println(m.getKey() +"\t"+ m.getValue());
			System.out.println("---------------------");
		}
		
		System.out.println("KING의 정보를 제공중입니다.");
		System.out.print("이름을 입력하세요. > ");
		name = sc.next();
		
		System.out.println(map.containsKey(name)?
				"👑" + name +": "+ map.get(name) : "찾으시는 왕이 없어요!");
		
		for(Entry<String, String> m : map.entrySet()) {
			if(name.equals(m.getKey())) { 
				System.out.println("👑" + m.getKey() +": "+ m.getValue()); break; 
			}
		}
		
	}
}

/*

2 다음과 같이 문제풀기
2-1. 다음과 같이 출력
2-2. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
==============================
KING   NAME
==============================
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡
---------------------
KING의 정보를 제공중입니다
이름을 입력하세요> 제빵왕

ㅁ제빵왕 : 김탁구

*/