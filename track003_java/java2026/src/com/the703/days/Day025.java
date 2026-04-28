package com.the703.days;

/*
Q1.다음의 상속도를 그리시오.

		Animal {name / eat(), sleep(), poo() }
			↑							↑	
	  	Cat								Dog
{@eat(), @sleep(), @poo()}		{@eat(), @sleep(), @poo()}

Q2.상속도에서 각각의 클래스에서 사용가능한 멤버변수/멤버함수를 적으시오.
*/

abstract class Animal {
	String name;

	abstract void eat();

	abstract void sleep();

	abstract void poo();
}

class Cat extends Animal { // 구현클래스 - 고양이는 동물이다
	@Override
	void eat() {
		System.out.println(super.name + " 고양이 냠냠!");
	}

	@Override
	void sleep() {
		System.out.println(super.name + " 고양이 수면!");
	}

	@Override
	void poo() {
		System.out.println(super.name + " 고양이 시원");
	}
}

class Dog extends Animal { // 구현클래스 - 강아지는 동물이다
	@Override
	void eat() {
		System.out.println(super.name + " 강아지 냠냠!");
	}

	@Override
	void sleep() {
		System.out.println(super.name + " 강아지 수면!");
	}

	@Override
	void poo() {
		System.out.println(super.name + " 강아지 시원");
	}
}

public class Day025 {
	public static void main(String[] args) {
		//1. abstract  class : 일반클래스 + 설계
		// Animal ani = new Animal();   
		
		// Q3. 이코드에서 오류나는 이유는? 
		// abstract 메서드는 {}구현부가 없으므로 실체화되지 않는다.

		Animal ani = null;
		ani = new Cat();   //Q4.    업캐스팅/다운캐스팅 ? 업캐스팅
		ani.name = "sally";   // ani.eat();
		
		//2. 사용목적
		// 한가지 타입으로 여러 객체를 관리
		Animal [] arr = {new Cat() , new Cat() , new Dog() , new Dog() , };
		int cnt=0;
		
		//Q5.  다음이 출력되게 코드를 작성하시오.
		/*ani1고양이 냠냠!
		ani2고양이 냠냠!
		ani3강아지 냠냠!
		ani4강아지 냠냠!   */
		
		for(Animal a : arr) {
			a.name = "ani" + ++cnt;
			a.eat();
		}
		
		
	}
}
