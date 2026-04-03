package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007_4 {

	public static void main(String[] args) {

//		1. 정수를 하나 입력해주세요 > 10
//		2. 정수를 하나 입력해주세요 > 3
//		3. 연산자를 입력해주세요(+,-,*,/) > +
//		> 10+3=13
		
		
				// 변수
				int a = 0, b = 0;
				String result = ""; // 안을 비워도 괜찮다
				char op = '\u0000';
				Scanner sc = new Scanner(System.in);
				
				//result = "" + a + op + b + "="; // 출력파트
				
				
				// 입력
				System.out.println("첫번째 정수를 입력해주세요.> ");
				a = sc.nextInt();
				
				System.out.println("두번째 정수를 입력해주세요.> ");
				b = sc.nextInt();
				
				System.out.println("연산자를 입력해주세요. (+,-,*,/) >");
				op = sc.next().charAt(0);
				
			
		        // ver-4 처리
				
				if (op == '+') { result += (a + b); } // result = result + (a + b);
				else if (op == '-') { result += (a - b); } // result = "" + (a + b); 자료형 맞추기
				else if (op == '*') { result += (a * b); }
				else if (op == '/'){ result += String.format("%.2f", a/(double)b); }


				System.out.println("" + a + op + b + "=" + result); // ""는 숫자를 문자로 표현하기 위해 넣었음
				
					
				
		
		

				
				
	} // end main

} // end class

