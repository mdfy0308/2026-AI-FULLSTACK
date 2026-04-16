package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx009 {
	
	public static char lower(char a) {
		return (char)(a + 32);
	}

	public static void main(String[] args) {

		char ch = 'A';
		Scanner sc = new Scanner(System.in);
		System.out.print("소문자 변환프로그램입니다.\n문자 입력> ");
		
		ch = sc.next().charAt(0);
		char res = lower(ch);
		System.out.println(res); 

	} //

} //
