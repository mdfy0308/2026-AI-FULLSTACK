package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {

//		1. 정수를 하나 입력해주세요 > 10
//		2. 정수를 하나 입력해주세요 > 3
//		3. 연산자를 입력해주세요(+,-,*,/) > +
//		> 10+3=13
		
		
		// 변수
		int in1 = 0, in2 = 0;
		char op  = '\u0000';
		
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("첫번째 정수를 입력해주세요.> ");
		in1 = sc.nextInt();
		
		System.out.print("두번째 정수를 입력해주세요.> ");
		in2 = sc.nextInt();
		
		System.out.print("연산자를 입력해주세요. (+,-,*,/) >");
		op = sc.next().charAt(0);
	
		// 처리 / 출력문을 1개로 줄이고 나누기의 경우는 실수로 표현?
		// if(연산자를 입력하면) {정수 연산자 정수 = 결과값이 나와야함};
		
		// if(op == '+') {System.out.println(in1+"+"+in2+"="+(in1+in2));}
		
		

	} // end main

} // end class
