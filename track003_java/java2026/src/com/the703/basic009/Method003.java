package com.the703.basic009;

public class Method003 {

	// 1. 함수구조 리턴과 반환값의 타입이 일치하게
	// public static 리턴값(결과물) 메서드명(파라미터) { 할 일 }
	public static int hello(String name) {
		return 1;
	}
	// public static void hello(String name) { }

	public static String sing() {
		return "용감한 자바전사";
	}

	public static String intro(String name, int level) {
		return name + "님의 레벨은 " + level;
	}

	public static double spell(double num) {
		return num / 2.0;
	}
	
	public static int luck() { return (int)(Math.random()*100+1); }
	
	public static int s(int num) { return num * 100; }

	////////////////////////////////////////////////
	public static void main(String[] args) {
//		hello("aaa");
//		System.out.println(hello("bbb"));

		System.out.println("1. 당신의 이름은? " + sing());
		System.out.println("2. 당신의 소개? " + intro("홍길동", 9));

		// 메서드 안에 메서드를 넣는 것도 가능
		System.out.println("2. 당신의 소개? " + intro(sing(), 10));

		System.out.println("3. 반타작의 저주 > " + spell(9));
		System.out.println("4. 운세 > " + luck()); // 운세 > 100
		
		System.out.println("5. 주식 > " + s(1));
	} //
		////////////////////////////////////////////////

}//