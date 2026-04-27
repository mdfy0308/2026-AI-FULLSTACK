package com.the703.basic011_ex;

/*
1. 클래스는 부품객체
2. 부품객체는 상태와 행위를 갖는다
3. static(공용) final(재할당/상속X), public(접근) 
4. 부품객체 재사용(extends, 오버로딩, 오버라이딩, 다형성)

Object
 ↑
Papa  	{ int brain / 			sing(이문세 - 붉은 노을) } ※ 생성자 : default, field
 ↑
Son 	{ int money / @Override sing(빅뱅 - 붉은 노을) }
*/

class Papa extends Object{	
	int brain;
	void sing() { System.out.println("이문세 - 붉은 노을"); }
	
	public Papa() { super(); } // 디폴트 생성자
	public Papa(int brain) { super(); this.brain = brain; } //Papa
	
} // end Papa

class Son extends Papa {	
	int money;
	@Override void sing() { 
		System.out.println("빅뱅 - 붉은 노을");
		System.out.println("IQ : " + brain);
		System.out.println("MONEY : " + money);
		}
	// 생성자 오버로딩
	public Son() { super(); } 
	public Son(int brain) { super(brain); }
	// public Son(int money) { this.money = money; } // 위 파라미터 int brain과 자료형이 같음
	public Son(int brain, int money) {
		super(brain);
		this.money = money;
	}
		
}

/////////////////////////////////////

public class ExtendsEx003 {
	public static void main(String[] args) {
		
		Son myson = new Son(148, 100);
		myson.sing();
		
	} //
} //


/*

Son myson = new Son(148, 100); → Papa(brain) this.money = money;
-----------------------------------
[method] Papa.class, Son.class, ExtendsEx003.class
-----------------------------------
[heap]											[stack]
	 #3. Object()		{				} #4.
	 #2. Papa(148)		{brain=148/sing	} #5.
[1번지]#1. Son(148, 100)	{money=100/@sing} #6.	←myson[1번지]
												main
*/