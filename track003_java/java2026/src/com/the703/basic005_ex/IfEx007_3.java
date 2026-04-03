package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007_3 {

	public static void main(String[] args) {

//		1. 정수를 하나 입력해주세요 > 10
//		2. 정수를 하나 입력해주세요 > 3
//		3. 연산자를 입력해주세요(+,-,*,/) > +
//		> 10+3=13
		
		
				// 변수
				int a = 0, b = 0;
				double result = 0;
				char op = '\u0000';
				Scanner sc = new Scanner(System.in);
				
				// 입력
				System.out.println("첫번째 정수를 입력해주세요.> ");
				a = sc.nextInt();
				
				System.out.println("두번째 정수를 입력해주세요.> ");
				b = sc.nextInt();
				
				System.out.println("연산자를 입력해주세요. (+,-,*,/) >");
				op = sc.next().charAt(0);
				
				
		     
				
				if (op == '+') { result = a + b; }
				else if (op == '-') { result = a - b; }
				else if (op == '*') { result = a * b; }
				else { result = (double)a/b; }
		
				System.out.printf("%d %c %d = " + (op == '/'? "%.2f":"%.0f"), a, op, b, result);
				
				
				
				
				
		
		

				
				
	} // end main

} // end class

