package com.the703.basic010_ex;

// 1. 클래스는 부품객체
// 2. 상태(멤버 변수:인스턴스 변수, 클래스 변수)와 행위(인스턴스 메서드, 클래스 메서드)

class Area1{
	
	
	static double pi = 3.14159; // 클래스 변수
	
	static double rect(int a, int b) { return (double)a*b; } // 클래스 메서드
	// public static 50.0 rect(10, 5) { 사각형의 면적 }
	
	static double triangle(int a, int b) { return (double)a*b/2; }
	
}

public class StaticEx001 {
	
	public static void main(String[] args) {
		  System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
		  System.out.println("사각형의 면적 : " + Area1.rect(10, 5));
		  System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));
		  

	}

}

/*

원의 면적    : 314.159
사각형의 면적 : 50.0
삼각형의 면적 : 25.0

*/