package com.the703.basic015;

//1. 클래스는 부품객체 - 설계도(틀, Can do this!)
//2. 상태 + 행위	  - interface ( public static final / public abstract)

interface Inter1 { void method(); }

class Inter1Impl implements Inter1 {
	@Override
	public void method() {
		System.out.println("Hello");
	}
}

public class Lambda001 {
	public static void main(String[] args) {
		
		//#1. interface 구현객체(자식)
		// 부모 = 자식 (업캐스팅)
		Inter1 i1 = new Inter1Impl();
		i1.method();		
		
		//#2. 익명이너클래스(test 목적, 1번 쓰고 버림, 잘 사용하지 않음)
		Inter1 i21 = new Inter1() {  
			@Override public void method() {
				System.out.println("Hello");
			}
		}; i21.method();
		
		Inter1 i22 = new Inter1() {  
			@Override public void method() {
				System.out.println("Hello");
			}
		}; i22.method();
		
		//#3. lambda
		Inter1 i3 = ()->{	System.out.println("Hello~ :)");	};
		i3.method();

		
	}//
}//


/*

1. Lambda?
- 자바에서 함수적 프로그래밍 지원기법
- 코드 간결하게
- 함수형 인터페이스 : 1개의 추상메서드를 갖는 인터페이스

*/