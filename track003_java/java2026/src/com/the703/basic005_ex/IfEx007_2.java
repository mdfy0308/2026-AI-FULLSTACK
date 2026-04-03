package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007_2 {

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
				
				
		        
				// =====================================================================


		        // ver-1, 출력 서식 맞추기 %d 정수, %.2f 실수
//		        if(b == 0 && op =='/') {System.out.println("0으로 나눌 수 없습니다.");}
//		        
//		        	 if(op == '+'){ System.out.println(a + "+" + b + "=" + (a+b)); }
//		        else if(op == '-'){ System.out.println(a + "-" + b + "=" + (a-b)); }
//		        else if(op == '*'){ System.out.println(a + "*" + b + "=" + (a*b)); }
//		        else if(op == '/'){ System.out.println(a + "/" + b + "=" + (a/b)); }
//		        
//		        System.out.printf("%d / %d = %.2f", a, b, a/(double)b);
		        
		        
				// =====================================================================
		        
				
		        // ver-2
				
				if (op == '+') { result = a + b; }
				else if (op == '-') { result = a - b; }
				else if (op == '*') { result = a * b; }
				else { result = (double)a/b; }
//				
//				if (op == '/') { System.out.printf("%d / %d = %.2f", a, b, result ); } 
//				else { System.out.printf("%d %c %d = %d", a, op, b, (int)result); } //%c char
			
				
				
				
				
		
		

				
				
	} // end main

} // end class

