package com.the703.basic003;

import java.util.Scanner;

public class DataTypeEx002 {

	public static void main(String[] args) {
//		좋아하는 수(정수)   입력하시오 > _입력받기
//	    좋아하는 숫자는 ** 입니다.

		// 변수
		int num = -1;
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.println("좋아하는 수(정수)를 입력하시오. >");
		num = sc.nextInt();
		
		// 처리(-)
		// 출력
		System.out.println("좋아하는 숫자는 " + num + "입니다.");
		System.out.print("좋아하는 숫자는 " + num + "입니다.\n");
		System.out.printf("좋아하는 숫자는 %d입니다.\n", num);
	}

}
