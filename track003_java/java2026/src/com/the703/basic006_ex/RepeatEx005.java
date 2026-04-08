package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx005 {

	public static void main(String[] args) {

		//변수
		Scanner sc = new Scanner(System.in);
		int a=-1, b=-1, sum= 0;
		
		//입력
		System.out.print("숫자 1 입력 > ");
		a = sc.nextInt();
		
		System.out.print("숫자 2 입력 > ");
		b = sc.nextInt();
		
		//처리
		//만약 a보다 b가 크면, a가 b와 같아질 때까지 a++
		//(a+(a+1)+(a+2)...+b) > ...가 몇개나 들어갈지 모름, 마지막 숫자 전까지 +
		//만약 a보다 b가 작으면, a가 b와 같아질 때까지 a--
		//(a+(a-1)+(a-2)...+b)
		
		// 출력 (a+(a+1)+(a+2)...+b = 합산)
		
		if(a<b) {
			for(;a<=b;a++) {
				System.out.print(a);
				if(a<b) {System.out.print(" + ");}
				sum = sum+a;
				}
			System.out.println(" = " + sum);
		} else if(a>b) {
			for(;a>=b;a--) {
				System.out.print(a);
				if(a>b) {System.out.print(" + ");}
				sum = sum+a;
				}
			System.out.println(" = " + sum);
		}
		
		// 반복문 하나로 줄여보기
			
		
	} //

} // 
