package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007_1 {

	public static void main(String[] args) {

//		1. 정수를 하나 입력해주세요 > 10
//		2. 정수를 하나 입력해주세요 > 3
//		3. 연산자를 입력해주세요(+,-,*,/) > +
//		> 10+3=13
		
		
				// 변수
				int a = 0, b = 0, result = 0;
				char op = '\u0000';
				Scanner sc = new Scanner(System.in);
				
				// 입력
				System.out.println("첫번째 정수를 입력해주세요.> ");
				a = sc.nextInt();
				
				System.out.println("두번째 정수를 입력해주세요.> ");
				b = sc.nextInt();
				
				System.out.println("연산자를 입력해주세요. (+,-,*,/) >");
				op = sc.next().charAt(0);
				
				
				// 처리 / 중복되는 출력문을 줄여보기
				// 만약 + 라면 10 + 3 = 13
				// if(op == '+'){ a + b = (a+b)); }
				// 만약 - 라면 10 - 3 = 7
				// if(op == '-'){ a - b = (a-b); }	
				// 만약 * 라면 10 * 3 = 30
				// if(op == '*'){ a * b = (a*b); }	
				// 만약 / 라면 10 / 3 = 3.33
				// if(op == '/'){ a / b = (a/b); }	
				
				
				// 풀이 도전
				
				if (op == '+' || op == '-' || op == '*' || op == '/') 
				{ result = (op == '+') ? a + b : (op == '-') ? a - b : (op == '*') ? a * b : (op == '/') ? a / b : 0;}
				
				System.out.printf("%d %c %d = %d\n", a , op , b, result);

		        
		        if(op == '/') { System.out.printf("%d %c %d = %.2f\n", a, op, b, (double)a / b);} 
		        else if (op == '+' || op == '-' || op == '*') 
		        { result = (op == '+') ? a + b : (op == '-') ? a - b : (op == '*') ? a * b : 0;
		          System.out.printf("%d %c %d = %d\n", a , op , b, result); }

				
		
		

				
				
	} // end main

} // end class

