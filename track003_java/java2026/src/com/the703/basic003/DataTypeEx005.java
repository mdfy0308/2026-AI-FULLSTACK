package com.the703.basic003;

import java.util.Scanner;

public class DataTypeEx005 {

	public static void main(String[] args) {
//		 Scanner 이용해서  성적처리를 입력받고 출력하시오.
//		 국어점수를 입력하시오.  _입력받기    100 
//		 영어점수를 입력하시오.  _입력받기    100 
//		 수학점수를 입력하시오.  _입력받기    99
//		 총점 :  299
//		 평균 :  99.67 
		
		// 변수
		int kor = -1, eng = -1, math = -1, total = -1;
		float avg = 0;
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("국어점수를 입력하시오."); kor = sc.nextInt();
		System.out.print("영어점수를 입력하시오."); eng = sc.nextInt();
		System.out.print("수학점수를 입력하시오."); math = sc.nextInt();
		
		// 처리
		total = kor + eng + math;
		avg = total / 3f; // 정수/실수
		
		// 출력
		System.out.printf("총점 : %d\n평균 : %.2f\n", total, avg);

	}
}
