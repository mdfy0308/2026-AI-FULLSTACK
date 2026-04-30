package com.the703.basic011;

/*
1. 클래스는 부품객체
2. 부품객체는 상태(멤버변수:클래스(static)/인스턴스)와 행위(멤버함수:클래스(static)/인스턴스)를 가진다.
3. 상속 - 클래스의 재사용

  Object #4. {				} #5. 
	↑
	A 	 #3. {			a=10} #6. 
	↑
	B 	 #2. {			b=20} #7. 		
	↑
	C 	 #1. {			c=30} #8. 			
	------------------------------------------------
	C my = new C();
	------------------------------------------------
	1) extends 상속
	2) is a : A는 Object이다. / B도 Object이다.
	3) 생성자 호출 순서	  : C() → B() → A() → Object()	1 2 3 4
	4) 객체가 생성되는 순서 : Object → A → B → C			5 6 7 8 

*/

class A extends Object { public A() { super(); } int a = 10; }

class B extends A 	   { public B() { super(); } int b = 20; }

class C extends B { 
	public C() { super(); } 
	int c = 30;
	void show() {
		System.out.println(a + "\t" + b + "\t" + c);
	}
}

public class Extends001 {

	public static void main(String[] args) {

		C my = new C(); // 1) new 객체생성 2)C() 초기화 3) my 주소
		my.show();

	}//

}//

/******
 * 
 * 1. 상속이란? 클래스의 재사용 - 새로운 부분만 추가, 수정해서 사용하는 것
 * 
 * 2. super vs sub 부모 자식 상위 하위 parent child super sub
 * 
 * 3. 모든 클래스는 Object 클래스를 상속 (생략된 extends Object...) 
 * 
 * 4. UML 부모 ← 자식 5. 장점 - 빠른
 * 개발, 코드의 중복 제거, 다형성(하나의 타입으로 여러 타입을 관리)
 * 
 * 6. 문법 Class 자식클래스 extends 부모클래스 (O) Class 자식클래스 extends 부모클래스1, 부모클래스2 (X)
 * 
 * 7. 상속시 부모속성을 사용할 수 있는 이유는? - 부모생성자를 호출해서 부모의 인스턴스 변수를 초기화하여 사용 가능하게 만든다.
 * 
 * 8. 오버라이드 - @override - 상속시 부모의 메서드와 동일, 자식클래스에 맞게 수정해서 사용함
 * 
 * 
 */