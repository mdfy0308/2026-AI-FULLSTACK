package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

// 생성자(기본 필드), toString, hashCode + equals, setters+getter
class BookDto {
	
	private String title;  
	private String author;
	
	public BookDto() { super();  }
	public BookDto(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "BookDto [title=" + title + ", author=" + author + "]";
	}
		
	public String getTitle() { return title; } 
	public void setTitle(String title) { this.title = title; } 
	public String getAuthor() { return author; } 
	public void setAuthor(String author) { this.author = author; }
	
	@Override
	public int hashCode() {
		return Objects.hash(author, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDto other = (BookDto) obj;
		return Objects.equals(author, other.author) && Objects.equals(title, other.title);
	}

} // BookDTO end


public class MapEx002 {
	public static void main(String[] args) {
		Map<String, BookDto> map = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		String isbn = "";
		
		map.put("978-11111", new BookDto("자바의 완성" , "가길동"));
		map.put("978-22222", new BookDto("파이썬 기초" , "홍길동"));
		map.put("978-33333", new BookDto("자료구조와 알고리즘" , "이순신"));
		
		System.out.println("===============================");
		System.out.println("ISBN      |   TITLE  |   AUTHOR");
		System.out.println("===============================");
		
		for(Entry<String, BookDto> m:map.entrySet()) {
			String key = m.getKey();
			BookDto value = m.getValue();
			System.out.printf("%s | %s | %s\n", key, value.getTitle(), value.getAuthor() );
			System.out.println("------------------------------");
		}

		System.out.print("도서 정보를 제공중입니다.\nISBN을 입력하세요 > ");
		isbn = sc.next();
				
		for(Entry<String, BookDto> m:map.entrySet()) {
			if(isbn.equals(m.getKey())) {
				BookDto value = m.getValue();
				System.out.printf("\n📖선택한 도서 정보: %s / 저자: %s", value.getTitle(), value.getAuthor());
				break;
			}
		}
		
	} //
} //

/*

사용자에게 ISBN을 입력받아 해당하는 값 출력
==============================
ISBN        TITLE        AUTHOR
==============================
978-11111 | 자바의 완성 | 가길동
------------------------------
978-22222 | 파이썬 기초 | 홍길동 
------------------------------
978-33333 | 자료구조와 알고리즘 | 이순신 
------------------------------
도서 정보를 제공중입니다
ISBN을 입력하세요> 978-22222

📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동

*/