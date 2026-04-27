package com.the703.basic012;

/*

클래스는 부품객체 - 상태와 행위를 갖는다.

1. 다형성
- 하나의 타입(부모)으로 여러 타입의 객체(자식들)를 관리

////////////////////////////////////////

			Object
		  	   ↑
			Animal { String name, int age / show() }
			↑			↑
	  	Cat				Person
{String num, @show()}	{ jumin, @show() }

*/

class Animal {
	String name;
	int age;
	void show() { System.out.println("Animal🐾 > "); }

}

class Cat extends Animal {
	String num;
	@Override void show() { System.out.println("Cat😺 > " + super.name + "/" + super.age); }

}

class Person extends Animal {
	String jumin;
	@Override void show() { System.out.println("Person🧑🏻 > "+ super.name + "/" + super.age); }

}

public class Poly005 {
	public static void main(String[] args) {
		//하나의 타입(부모)으로 여러 타입의 객체(자식들)를 관리
		Animal[] anis = { new Cat(), new Cat(), new Person(), new Person() };
		anis[0].show(); anis[1].show(); anis[2].show(); anis[3].show();

	} //

} //
