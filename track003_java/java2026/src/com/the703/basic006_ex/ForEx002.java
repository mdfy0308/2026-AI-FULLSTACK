package com.the703.basic006_ex;

import java.util.Scanner;

public class ForEx002 {

	public static void main(String[] args) {
		// 사용자에게 단을 입력받아 해당하는 단을 출력해주는 프로그램을 작성하시오. FOR문을 이용하시오.
		// 구구단 1~9단

		//변수
		Scanner sc = new Scanner(System.in);
		int num = -1;
		
		//입력
		System.out.print("단 입력 > ");
		num = sc.nextInt();
		
		//처리+출력
		for(int i=1;i<=9;i++) { 
			System.out.printf("%d * %d = %d\n", num, i, num*i); 
		}
	

	} //

} //
