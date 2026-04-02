package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx005 {

	public static void main(String[] args) {



		// 변수
		Scanner sc = new Scanner(System.in);
		char ch = '\u0000';
		
		// 입력 - 문자한개를 입력받아 
		System.out.print("영문자를 입력하세요. > ");
		ch = sc.next().charAt(0);
				
		// 처리
		// 대문자면 소문자로,  소문자면 대문자로 변경하는 프로그램을 작성하시오.
		// ※  a = 'A' + 32
		if(ch >= 'A' && ch <= 'Z') {ch = (char)(ch + 32);}
		else if (ch >= 'a' && ch <= 'z') {ch = (char)(ch - 32);}
		
		// 출력
		System.out.println(ch);
		
		
		

	} // end main
	 

} // end class
