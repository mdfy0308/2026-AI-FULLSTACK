package com.the703.basic004;

public class Casting001 {

	public static void main(String[] args) {
		//1. 자료형(기본/참조)
		//2. 기본형(논리/정수/실수) boolean - true/false
		//	 정수형 : byte 1 < short 2 < int★ 4 < long 8(L)
		//   실수형 : float 4f < double★ 8
		//3. boolean을 제외한 7개의 기본형은 서로 형변환이 가능함
		// #1. 형변환 - 자동타입변환 (boolean 빼고)
		byte by = 1; short sh = 2; int in = 4; long lo = 8l;
		
		float fl = 3.14f; double dou = 3.14; 
		
		boolean bl = true;
		
		sh = by; // 정수형(2) - 정수형(1)
		in = by; // 정수형(4) - 정수형(1)
		lo = by; // 정수형(8) - 정수형(1)
		// lo = fl; 정수형(8) - 실수형(4), 타입이 다름+실수가 정수보다 큼
		fl = lo; // 실수형(4) - 정수형(8)
		// in = bl; 정수형(4) - 논리형(1), 타입이 다름
		
		by = -128;
		by = 0;
		//by = 128; // byte : -128~127
		// 1) bit : 1 0 (2개) < 1 0 1 0 (4개) 8bit = 1byte
		// 2(1)	4(2)	8(3)	16(4)	32(5)	64(6) 128(7)	256(8)
		// 2) 양수음수 -128~(128-1: 0을 포함)
		
		// #2. 형변환 - 강제타입변환 > 큰타입을 작은 타입으로 쪼갠다 > 데이터 누수 있음
		by = (byte) in; // 정수(1) - 정수(4)
		
		int in2 = (int) 1.2;
		float fl2 = (float) 1.2;
		System.out.println(in2 + "\t");
		
		//Q1) System.out.println(  1.5 + 2.7 ); 형변환이용해서 3으로 나오게 만들기
		System.out.println( (int)1.5 + (int)2.7 );
		
	}

}
