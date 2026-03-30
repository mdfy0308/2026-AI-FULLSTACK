package com.the703.basic003;

import java.util.Scanner;

public class DataTypeEx004 {

	public static void main(String[] args) {
//		파이값을 입력하시오 > _입력받기    3.141592    ( 자료형선택 )
//	     파이값은 **입니다.
		
		// 변수
		float fl = 3.14f; // f 붙이지 않으면 오류남
		double dou;
		Scanner sc = new Scanner(System.in);
				
		// 입력
		System.out.println("파이값을 입력하시오.");
		// fl = sc.nextFloat();
		dou = sc.nextDouble();
		
		// 처리
		// 출력
		System.out.println("파이값은 " + dou + "입니다.");
		System.out.print("파이값은 " + dou + "입니다.\n");
		//System.out.printf("파이값은 %f입니다.\n" , dou); // %. 뒤에 꼭 숫자를 붙일 것
		System.out.printf("파이값은 %.0f입니다.\n" , dou);
		System.out.printf("파이값은 %.1f입니다.\n" , dou); 
		System.out.printf("파이값은 %.2f입니다.\n" , dou);
		System.out.printf("파이값은 %.6f입니다.\n" , dou);
		
		System.out.println(10/3);
		System.out.println(10/3f); // 정수/정수는 정수, 정수/실수는 실수
		System.out.println(10f/3);
		
	}

}
