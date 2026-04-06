package com.the703.basic006;

import java.util.Scanner;

public class ForInfinit {

	public static void main(String[] args) {
		
		// 제어문
		// 조건문: ~라면 if /  switch
		// 반복문: 반복 for / while / do while
		// 제어조건 : break / continue
		
		// { int a=1; } 영역 안에서 지정된 int를
		// a=2; 영역 밖에서까지 사용할 수는 없음
		
		//1. 영역
		// for(;;) { System.out.println("Hello"); }
		
		Scanner sc = new Scanner(System.in);
		int a = -1;
		
		//2. 빠져나올 조건
		
//		for(;;){	
//			System.out.println("Hello");
//			System.out.println("중단하시겠습니까? 0이면 종료");
//			a = sc.nextInt();
//			if(a == 0) break;
//		}
	
		// for(초기값;조건문;증감)
		for(;a!=0;){ // a가 0이 아니라면 여기서부터
			System.out.println("Hello");
			System.out.println("중단하시겠습니까? 0이면 종료");
			a = sc.nextInt();
		} //여기까지 반복함
		

	} // main end

} // class end
