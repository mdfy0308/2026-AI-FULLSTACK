package com.the703.basic014;

class Parent {
	int x = 100;
	void method() { System.out.println("Parent method"); }
}

class Child extends Parent {
	int x = 200;
	void method() { System.out.println("Child method"); }
}

public class Repeat001_oop {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();

		System.out.println("p.x = " + p.x);
		p.method();

		System.out.println("c.x = " + c.x);
		c.method();
	}
}

/*
 * 
 * ## 📝 문제: OOP 개념(1)
 * 
 * 다음 코드를 보고 질문에 답하시오. 
 * Q1. OOP란 무엇인가? 
 * Object Oriented Programming 
 * 객체 지향 프로그래밍
 * 부품객체를 조립해 완성된 프로그램을 만드는 기법
 * 
 * 클래스는 부품객체로 상태(멤버변수)와 행위(멤버메서드)를 갖는다.
 * 
 * Q2. OOP의 핵심 개념은 무엇인가? 캡슐화, 다형성, 상속, 추상화
 * 
 * 캡슐화 : 외부에서 직접 접근하지 못하게 보호
 * 다형성 : 하나의 타입으로 여러개의 타입을 관리
 * 상속	: 클래스의 재사용/재활용
 * 추상화	: 핵심적인 기능을 단순화하는 설계 기법 (abstract vs interface)
 * 
 * Q3. 상속도를 그리시오. 
 * Q4. 각 객체에서 사용할 수 있는 멤버변수와 메서드를 적으시오.
 * Object
 *   ↑
 * Parent {x=100, method()} 
 * 	 ↑ 
 * Child {x=200, @method()}
 * 
 * Q5. Parent p = new Child(); 실행 시 객체 생성, 초기화, 참조값을 설명하시오. 
 * 객체 생성 : new 
 * 초기화 : Child() 
 * 참조값 : p
 
 method (정보, static, final)
 Parent.class, Child.class, Repeat001_oop.class#1
 ----------------------------------------------------------------
 heap											stack
 #4 Child() → Parent() → Object() 호출 순서
 	{x=200, @method()}←{x=100}←{ } 생성 순서
 #3 new		1번지) Parent {x=100, method()} 	← p [1번지] #5
 												[main]#2
 
 * 
 * Q6. Parent 클래스의 멤버변수/메서드의 종류와 메모리 구조를 설명하시오. 
 * Parent { x=100 인스턴스 변수 - heap area - new O - 생성자 - this O 
 * 			method() 인스턴스 메서드 - heap area }
 * 
 * Q7. 출력 결과를 쓰시오. 
 * - p.x의 값은? 100 
 * - p.method() 실행 시 어떤 메서드가 호출되는가? Child의 @method()
 * - c.x의 값은? 200
 * - c.method() 실행 시 어떤 메서드가 호출되는가? Child의 @method()
 * 
 * Q8. @Override 키워드의 의미와 코드에서 오버라이딩된 부분을 설명하시오. 
 * @Override method() 부모의 메서드를 자식 클래스에 맞게 수정해서 사용 가능
 * 상속시 부모클래스의 메서드를 자식클래스에서 재정의
 * Parent의 method()가 Child에서 오버라이딩
 * 
 * Q9. Child c = new Child(); 호출 시 생성자 호출 순서와 객체 생성 순서를 설명하시오.
 * 
 * Child #1			→		Parent	#2					→	Object#3
 * {x=200, @method()}#6	 ←	Parent {x=100, method()}#5 	←	{   	}#4
 * 
 */