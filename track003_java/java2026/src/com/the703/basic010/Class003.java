package com.the703.basic010;

//1. 클래스는 부품객체
//2. 상태/멤버변수와 행위/멤버함수, 기능을 갖는다

class Car31 extends Object {
} // 생성자 Car31() - 1) 컴파일러가 기본 생성자를 자동생성

class Car32 extends Object {
	String color; // alt + shift + s

	public Car32() { super(); } // 기본생성자 2) 생성자를 개발자 수동으로 만들 때 자동생성취소

	public Car32(String color) {
		super();
		this.color = color;
	} // 필드 있는 생성자

	@Override
	public String toString() {
		return "Car32 [color=" + color + "]";
	} // 상태 확인

} // 생성자는 초기화

public class Class003 {

	public static void main(String[] args) {

		Car31 car1 = new Car31(); // new 메모리 빌리고, Car31() 초기화, Car1에 주소
		System.out.println(car1); // 번지
		
		
		Car32 car3 = new Car32("green");
		System.out.println(car3 + "\t" + car3.color);
		
		// Car32 car2 = new Car32( color="white";);
		// System.out.println(car2 + "\t" + car2.color); // new 메모리 빌리고, Car32() 초기화-null, Car2에 주소
		// toString 상태
		
	} //

} //

//////////////////////////////////////////////////////
/*
 * [RUNTIME DATA AREA] ------------------------------------ 
 * [METHOD:정보] Car31.class, Car32.class(toString), Class003.class#1
 * -------------------------------------------------
 * [HEAP:동적] 		    |		  [STACK:지역]
 * 3번지: Car32{ color="red" }		car3[3번지] 
 * 2번지: Car32{ color }				car2[2번지] 
 * 1번지: Car31() 	  ←			    car1[1번지] 
 * 				   					main#2 
 * ------------------------------------------------- */
//////////////////////////////////////////////////////
/// 
/*

1. 생성자 - new 연산자에 의해 호출 [초기화] 담당
2. 기본생성자
- 모든 클래스에 생성자가 반드시 존재
- 생성자 선언을 생략시 : 컴파일러가 자동으로 기본생성자를 추가
- 개발자가 선언시 : 컴파일러가 자동생성을 취소함
- alt + shift + s / superclass, using Fields, toString

3. 형식
class A{
	String name;
	A(){}				// 기본생성자(디폴트 생성자)
	A(String name){}	// 파라미터, 알규먼트가 있는 생성자
}
	리턴값 메서드명(파라미터)
	 X	 클래스명과 동일

*/