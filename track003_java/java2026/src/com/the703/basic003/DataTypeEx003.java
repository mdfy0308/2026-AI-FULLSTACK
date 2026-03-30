package com.the703.basic003;

import java.util.Scanner;

public class DataTypeEx003 {

	public static void main(String[] args) {
//		태어난 년도를 입력하세요. >
//		2000
//		당신의 나이는 25살 입니다.
		
		// 변수
		int age = -1;
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.println("태어난 년도를 입력하세요.");
		age = sc.nextInt();
		
		// 처리
		age = 2026 - age;
		
		// 출력
		System.out.println("당신의 나이는 " + age + "살 입니다.");
		System.out.print("당신의 나이는 " + age + "살 입니다.\n");
		System.out.printf("당신의 나이는 %d살 입니다.\n", age);
		
		
		
	}

}
