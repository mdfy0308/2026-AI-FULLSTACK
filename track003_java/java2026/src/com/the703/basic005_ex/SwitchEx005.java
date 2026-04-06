package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx005 {

	public static void main(String[] args) {
//		숫자한개 입력받아
//	      홀수면 남자
//	      짝수면 여자

		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		System.out.print("숫자 입력 > ");
		num = sc.nextInt();
		
		switch (num%2) {
		case 1: System.out.println("남자"); break;
		case 0: System.out.println("여자"); break;
		}
		
	} // 

} //
