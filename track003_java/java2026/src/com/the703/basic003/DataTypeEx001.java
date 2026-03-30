package com.the703.basic003;

import java.util.Scanner;

public class DataTypeEx001 {

	public static void main(String[] args) {
//		1-1.  나이를 입력받을 자료형 선택후  변수명  age로 하시오.  예) 10,20
//	    1-2.  Scanner이용해서 나이 입력받고 출력하시오.
//	  
//	    당신의 나이를 입력하시오 > _입력받기
//	    내 나이는 ** 입니다.
		
		// 변수
		int age = -1;
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("당신의 나이를 입력하시오. >");
		age = sc.nextInt();
		
		// 처리(생략)
		// 출력
		System.out.println("내 나이는 " + age + "살 입니다.");
		System.out.print("내 나이는 " + age + "살 입니다.\n");
		System.out.printf("내 나이는 %d살 입니다.", age);

	}

}
