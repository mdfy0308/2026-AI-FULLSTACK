package com.the703.basic013;


class Papa { int brain; }
class Mama { int brain; }

//class Son extends Papa, Mama {  } 자바에서의 상속은 단일 상속

interface Animal2 {
	String company = "(주) 메가스터디"; // sf : static final (클래스 변수) method area - new, this X 
	void eat(); // A : abstract {}구현부 없음
}

class Saram implements Animal2{ 

	@Override public void eat() { 
		// company = "kakao"; static final 재할당 불가
		System.out.println( Animal2.company + " 랍스터");
	}
}

class Pig implements Animal2{ 

	@Override public void eat() { 
		System.out.println( Animal2.company + " 냠냠");
	}
}


public class Interface001 {

	public static void main(String[] args) {

		// Animal2 ani = new Animal2(); → 구현부 없음, 실체화 불가
		Animal2[] anis = { new Saram(), new Saram(), new Pig() };
		
		for(Animal2 a : anis) {
			a.eat();
		}

	}

}


/* 속이 빈 점선
	Animal2 {	company = "(주) 메가스터디" / eat()	}
				↑			↑
		Saram{@eat()}	Pig{@eat()}

*/
/*

1. interface
- 개발 코드 변경 없이 객체를 바꿔낄 수 있는 역할

2. abstract(is A:고양이는 동물이다)	vs	interface(can do this)
- interface가 추상화 정도가 더 높다
1) abstract -  인스턴스 변수, 일반 메서드, 추상 메서드를 가질 수 있음
2) interface - 상수(public, static, final) + 추상 메서드(public abstract)	

3. 프로젝트 진행시 interface를 사용하면
다른 구성원들이 각각의 부분을 완성할때까지 기다리지 않고 규약만 정해놓은 뒤 본인 부분만 작성한다.

4. 형식
interface 인터페이스명 {
	상수; 		// public	static	final
	추상메서드; 	// public	abstract - {}, this X
}

class 클래스명 implements 인터페이스명 {}

class 클래스명 extends 클래스명 implements 인터페이스명1, 인터페이스명2 {}
구현력이 없어서 다중 상속이 가능하다

*/