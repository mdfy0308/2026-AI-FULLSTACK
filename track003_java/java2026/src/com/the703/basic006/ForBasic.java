package com.the703.basic006;

public class ForBasic {

	public static void main(String[] args) {
		
		//step1) 줄바꿈 안된 print 1 2 3
		System.out.println("\n■ step 1) 출력1");
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);
	
	
		//step2-1) 반복되는 영역 System.out.print(1);
		//for(초기값; 조건문; 증감문) {빠져나올조건}
		//step2-2) 반복되는 영역 > 변수찾기 System.out.print(1, 2, 3으로 바뀜);
		//step2-3) 패턴찾기 (시작;종료;변화) 시작:1, 종료:3, 증감:+1
		
		System.out.println("\n■ step 2) for");
		for(int i=1; i<=3; i++) { System.out.print(i); }
		
		
		//step3)
		System.out.println("\n■ step 3) for 연습");
		// 패턴 : 시작 1; 종료 10; 변화 1
		for(int i=1; i<=10; i++) { System.out.print(i); } 
		System.out.println();
		
		// 패턴 : 시작 2; 종료 8; 변화 1
		for(int i=2; i<=8; i++) { System.out.print(i); } 
		System.out.println();
		
		// 패턴 : 시작 3; 종료 9; 변화 3
		for(int i=3; i<=9; i=i+3) { System.out.print(i); } 
		System.out.println();
	
		
		// 패턴 : 시작 5; 종료 1; 변화 -2
		for(int i=5; i>=1; i-=2) { System.out.print(i + " "); } 
		System.out.println();
		
		// Hi1 Hi2 Hi3 / 반복 패턴/변수 찾기
		for(int i=1; i<=3; i++) { System.out.print("Hi"+ i + "\t"); } 
		System.out.println();
		
		

	} //

} //
