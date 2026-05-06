package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx003 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String, Map<String, BookDto>> library = new HashMap<>();
		String loc = "", isbn= "";
		
		library.put("서울점", new HashMap<>());
		library.get("서울점").put("978-11111", new BookDto("자바의 완성", "가길동"));
		library.get("서울점").put("978-22222", new BookDto("파이썬 기초", "홍길동"));
		
		library.put("부산점", new HashMap<>());
		library.get("부산점").put("978-33333", new BookDto("자료구조와 알고리즘", "이순신"));
		library.get("부산점").put("978-44444", new BookDto("파이썬 심화", "홍길동"));
		
		
		System.out.println("=== 도서관 전체 목록 ===");
		
		for(String m : library.keySet()) {
			System.out.println("📚 " + m);
			for(Entry<String, BookDto> i:library.get(m).entrySet()) {
				BookDto value = i.getValue();
				System.out.println(i.getKey() +" | "+ value.getTitle()  +" | "+ value.getAuthor());
			}
			System.out.println("---------------------");
		}
		
		System.out.print("지점 이름 입력> ");
		loc = sc.next();
		
		System.out.print("ISBN 입력> ");
		isbn = sc.next();
		
		for(Entry<String, BookDto> i:library.get(loc).entrySet()) {
			String key = i.getKey();
			BookDto value = i.getValue();
			if(isbn.equals(key)) {
				System.out.printf("\n📖 선택한 도서 정보: %s / 저자: %s", value.getTitle(), value.getAuthor());
				break;
			}
		}
				
	}//
}//

/*

### 📌 실행 예시 

=== 도서관 전체 목록 ===
📚 서울점
978-11111 | 자바의 정석 | 남궁성
978-22222 | 파이썬 기초 | 홍길동
---------------------
📚 부산점
978-33333 | 자료구조와 알고리즘 | 이순신
978-44444 | 파이썬 심화 | 홍길동
---------------------
지점 이름 입력> 서울점
ISBN 입력> 978-22222

📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동

- 다음의 데이터 이용할것
    String[][] data = {
        {"서울점", "978-11111", "자바의 완성", "가길동"},
        {"서울점", "978-22222", "파이썬 기초", "홍길동"},
        {"부산점", "978-33333", "자료구조와 알고리즘", "이순신"},
        {"부산점", "978-44444", "파이썬 심화", "홍길동"}
    };   
*/