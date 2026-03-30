package com.the703.basic003;

public class DataType001 {

	public static void main(String[] args) {
		
		// 1. 자바의 자료형 분류(기본형 / 참조형)
		// 2. 기본형 : 값
		// 2-1. 논리형 : Boolean - true/false
		boolean bl = true;
		System.out.println("1. 논리 : " + bl);
		
		// 2-2. 정수형 : byte - short - ★int - long(L) / 1, 2, 3 / (1-2-4-8)
		byte  by = 1; short sh = 2; int    i = 4; long   l = 8L; // ctrl+alt+j 한 줄로 정리
		System.out.println("2. 정수 : byte - short - int★ - long");
		
		int hap = by + 1; // byte(1) + int(4) 단위가 다를 때 큰 단위을 작은 단위에 담을 수 없음
		
		// 2-3. 실수형 : float(f) - ★double / 3.14 / (4-8)
		float fl = 3.14f; //f를 붙이지 않으면 double로 인식해서 오류가 난다.
		double dou = 3.14;
		
		float fp1 = 1.0000001f; // 0을 6개 + 1 = 7개
		float fp2 = 1.00000001f; // 0을 6개 + 1 = 8개
		float fp3 = 1.11111111f; // 8개
		
		// 3. 참조형 : 주소값
		// 3-1. 

	}

}
