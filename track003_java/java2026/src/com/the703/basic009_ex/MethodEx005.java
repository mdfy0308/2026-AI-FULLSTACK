package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx005 {
	
	public static int abs(int num) {
		return num<0? num*-1:num;
	}

	public static void main(String[] args) {
		
		int res1=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("절대값을 구하는 프로그램입니다.\n숫자를 입력하세요. > ");
		
		res1=abs(sc.nextInt());
		System.out.println(res1);

	} //

} //
