package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx002 {

	public static void main(String[] args) {
		// 출력내용 : 숫자 한개를 입력받아 
		// 양수라면 양수  , 음수라면 음수  , 0이라면 zero를 출력하는 프로그램을 작성하시오.
		
		// 변수
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		// 입력
		System.out.print("숫자를 입력하세요. > ");
		num = sc.nextInt();
		
		// 처리/출력
		if(num > 0) { System.out.println("양수");}
		else if (num < 0) {System.out.println("음수");}
		else if (num == 0) {System.out.println("zero");}
		
		
		
		// 삼항연산자 조건 ? true 결과 : false 결과
		// 조건이 여러개일 경우 조건? true 결과를 추가로 입력
		// 조건? 참 : 조건? 참 : 거짓
		System.out.println(num > 0? "양수": num < 0? "음수" : "zero");
		

	}

}
