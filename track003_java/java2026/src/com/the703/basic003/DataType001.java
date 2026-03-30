package com.the703.basic003;

public class DataType001 {

	public static void main(String[] args) {
		
		// 1. 자바의 자료형 분류(기본형 / 참조형)
		// 2. 기본형 : 값
		// 2-1. 논리형 : Boolean - true/false
		boolean bl = true;
		System.out.println("1. 논리 : " + bl);
		
		
		// 2-2. 정수형 : byte - short - ★int - long(L) / 1, 2, 3 / (1-2-4-8)
		byte  by = 1; short sh = 2; int    i = 4; long   lo = 8L; // ctrl+alt+j 한 줄로 정리
		System.out.println("2. 정수 : byte - short - int★ - long");
		
		int hap = by + 1; // byte(1) + int(4) 단위가 다를 때 큰 단위을 작은 단위에 담을 수 없음
		
		
		// 2-3. 실수형 : float(f) - ★double / 3.14 / (4-8)
		// 정수 < 실수
		float fl = 3.14f; //f를 붙이지 않으면 double로 인식해서 오류가 난다.
		double dou = 3.14;
		
		fl = lo; // 실수 > 정수, 4byte + 8byte / %.2f
		
		float fp1 = 1.0000001f; // 0을 6개 + 1 = 7개, → 정확하게 표현 가능
		float fp2 = 1.00000001f; // 0을 6개 + 1 = 8개 → 정밀도 초과시 반올림
		float fp3 = 1.11111111f; // 8개 → 근사값
		
		System.out.println(fp1 + "\t" + fp2 + "\t" + fp3);
		//				1.0000001		1.0		1.1111112
		// 소수점 7자리가 넘어가면 보장되지 않음. 근사치로 출력
		
		
		double dp1 = 1.000000000000001; // 0 14개 + 1 = 15개 → 정확하게 표현 가능
		double dp2 = 1.0000000000000001; // 0 15개 + 1 = 16개 → 정밀도 초과시 반올림
		double dp3 = 1.1111111111111111; // 16개 → 근사값
		
		System.out.println(dp1 + "\t" + dp2 + "\t" + dp3);
		// 1.000000000000001		1.0			1.1111111111111112
		
		
		// 3. 참조형 : 주소값
		String abc = "apple";               // abc = 1000번지["apple"]
		String abc2 = new String("apple"); // abc2 = 2000번지["apple"]
		
		System.out.println(abc);
		System.out.println(abc2);
		
		System.out.println(abc == abc2); // false, 주소값이 다름
		
	}

}
