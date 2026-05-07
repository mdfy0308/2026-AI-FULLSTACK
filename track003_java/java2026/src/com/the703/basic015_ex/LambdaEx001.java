package com.the703.basic015_ex;

interface Printer {
	void print(String msg);
}

interface Calculator {
	int add(int a, int b);
}

public class LambdaEx001 {
	public static void main(String[] args) {

		// 익명 객체
		Printer p1 = new Printer() {
			@Override
			public void print(String msg) { System.out.println("Message : " + msg); }
			};
		
		// 람다식
		Printer p2 = msg -> System.out.println("Message : " + msg);
		
		p1.print("Hello World");
		p2.print("Lambda Rocks!");
		
		// 익명 객체
		Calculator c1 = new Calculator() {
			@Override public int add(int a, int b) { return a+b; }
		};
		
		// 람다식
		Calculator c2 = (a, b) -> a+b;
		
		System.out.println("익명객체 결과: " + c1.add(3, 5));
		System.out.println("람다식 결과: " + c2.add(10, 20));

	} //
}// 