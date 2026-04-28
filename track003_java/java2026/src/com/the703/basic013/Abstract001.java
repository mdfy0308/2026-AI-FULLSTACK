package com.the703.basic013;

/*

Abstract (is A) : 일반클래스 + 설계
	고양이는(is) 동물이다(A)
	개도(is)	  동물이다(A)
	
	<<abstract>>
	   Animal  { name, age / eat(), sleep(), poo() }
	   ↑	↑
	 Cat | Dog	{ @eat(), @sleep(), @poo() }

	// The type Person must implement the inherited abstract method Animal.sleep()
	// abstract를 사용했다면 무조건 구현해야함 > @override / 강제성을 띤다

*/


abstract class Animal{
	String name; // 인스턴스 변수 - heap area - new O - this 각각
	int age;
	
	abstract void eat(); 	// 추상메서드는 {} 구현부가 없다.
	abstract void poo(); 	// 추상메서드는 추상클래스로 만들어줘야 함.
	abstract void sleep();	// 추상화, 일반화, 설계 : 공통의 속성, 구체적인 내용 없음
	
}

class Cat extends Animal { // 구현클래스 - 고양이는 동물이다
	
	@Override void eat() { System.out.println(super.name + " 고양이 냠냠"); }
	@Override void poo() { System.out.println(super.name + " 고양이 잔다"); }
	@Override void sleep() { System.out.println(super.name + " 고양이 시원~"); }
}

class Dog extends Animal { // 구현클래스 - 강아지는 동물이다
	
	@Override void eat() {  System.out.println(super.name + " 강아지 냠냠");  }
	@Override void poo() {  System.out.println(super.name + " 강아지 잔다");  }
	@Override void sleep() {  System.out.println(super.name + " 강아지 시원~");  }
}

public class Abstract001 {

	public static void main(String[] args) {
		
		//1. abstract : 일반클래스 + 설계
		//Animal ani = new Animal();
		//Cannot instantiate the type Animal
		// new 메모리 빌리고 객체 생성, Animal 초기화? → {} 구현부가 없음
		//abstract void eat(); → 구현부가 없으므로 실체화도 불가
		
		Animal ani = null; // { name, age, eat(), poo(), sleep() } 
		ani = new Cat();   // 부모 = 자식(업캐스팅),
		ani.name = "kitty"; ani.eat();
		
		ani = new Dog();
		ani.name = "alpha"; ani.eat();
		
		//2. 사용목적
		Animal [] arr = { new Cat(), new Cat(), new Dog(), new Dog() };
		int cnt = 0;
		for(Animal a : arr) { a.name = "ani" + ++cnt; a.eat(); }
		// 각각 인스턴스에 이름 / eat() 메서드는 @오버라이드된 내용으로 (최신기능)
		
	}//

}//

/*

1. 추상화(abstract)
- 실체화된 객체들의 공통적인 특성을 추출
- 미완성적인 개념 (new 사용할 수 없음)
- 공통된 빌드와 메서드의 이름을 통일할 목적으로 사용

2. 추상 클래스



*/
