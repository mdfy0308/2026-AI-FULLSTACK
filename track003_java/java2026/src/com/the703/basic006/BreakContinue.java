package com.the703.basic006;

import java.util.Scanner;

public class BreakContinue {

	public static void main(String[] args) {

		
		// ver-0
		// { int a = 1; System.out.println(a); } //영역
		// a=2; // {} 영역 밖에 있음

		// ver-1 for 반복
		//반복      영역 {여기서부터 			여기까지}
		//for(;;){ System.out.println(1); break;}
		
		//ver-2 반복 빠져나오기
		int i=1;
		for(;i<5;i++){
			if(i==3) { break; }
			System.out.println(i);
		}
		
		//////////////////////////////////////////////
		
		// for(초기값;조건;증감) 

		for(i=1;i<5;i++){ 
			if(i==3) { continue; } // skip, 뒤에 오는 실행문을 무시하시오
			System.out.println(i);
		}
		
		int a = -1;
		Scanner sc = new Scanner(System.in);
		
		// ver-3
		for(;;) {
			System.out.println("1 입력 > ");
			a = sc.nextInt();
			if(a == 1) { break; } // 
		}
		
		
		
		
	} //

} //
