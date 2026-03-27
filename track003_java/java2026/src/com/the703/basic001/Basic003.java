package com.the703.basic001;

public class Basic003 {

	public static void main(String[] args) {
		
		//1. System.out.println(); 줄바꿈
		System.out.println("Hello");
		System.out.println("Java");
		
		//2.System.out.print(); 줄바꿈 하지 않음
		System.out.print("줄바꿈을 안 합니다. ");
		System.out.print("옆으로 이어집니다.");
		
		// \t : tab 누른 효과, \n : 줄바꿈 효과
		System.out.print("A\t");
		System.out.print("B\n");
		System.out.print("a\t");
		System.out.print("b\n");

		//3. System.out.printf( "%s%d" , "문자열" , 10 ); 포맷 형식
		// %d 숫자, 정수
		// %s 문자열, "abc"
		System.out.printf("%d 더하기 %d 은 %s\n", 1, 1, "귀요");
		System.out.printf("%s하면 %d원\n", "궁금", 500);
		
		//4. +의 의미
		System.out.println(10+3);
		System.out.println(10+"3");
		System.out.println("10"+3);
		
		System.out.println("10 + 3 = " + (10+3));
		
		
	}

}
