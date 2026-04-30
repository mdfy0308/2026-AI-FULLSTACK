package com.the703.basic014;

import java.util.ArrayList;

/*  1. 클래스는 부품객체 
    2. 멤버변수 / 멤버함수

Q1. 상속도를 그리시오.
Q2. 상속도에서 각 객체에서 사용할 수 있는 멤버변수와 멤버함수를 적으시오.
Q2 상속도
 	Object	#3{										 }#4
 	  ↑	
 	Papa 	#2{ money=10	/ toString(기본속성 생략가능) }#5
 	  ↑	
 	Son 	#1{ 	money=150, car=2 / @toString 	 }#6
*/

class Papa {
	int money = 10;
	
	public Papa() { super(); }
	public Papa(int money) { super(); this.money = money; }
	@Override public String toString() { return "Papa [money=" + money + "]"; }
}

class Son extends Papa {
	int money = 150;
	int car = 2;

	public Son() { super(); }  public Son(int money) { super(money); }  
	public Son(int money, int car) { super(); this.money = money; this.car = car; }
	@Override public String toString() { return "Son [money=" + money + ", car=" + car + "]"; }
	
}

public class Repeat003_oop {
	public static void main(String[] args) {
		
		// Step1 Q3. Papa p1 = new Papa(); 실행 시 메모리 구조와 출력 결과를 설명하시오.
		// →   Papa p1 - 1번지 { money=10/toString } = 1번지 { money=10/toString }
		
		// System.out.println(p1);의 결과는 무엇인가?
		// → Papa [money=10]
		
		Papa p1 = new Papa();  	
		System.out.println(p1);	

		// Step2 Q4. Son s2 = new Son(); 실행 시 메모리 구조와 출력 결과를 설명하시오.
		// →   Son s2(2번지) = { money=150, car=2/@toString }-{ money=10/toString }
		// → 			 2번지 { money=150, car=2/@toString }-{ money=10/toString }
		
		// System.out.println(s2);의 결과는 무엇인가?
		// → Son [money=150, car=2]
		
		Son s2 = new Son(); 
		System.out.println(s2); 

		// Step3 Q5.Son s3 = (Son) new Papa(); 실행 시 어떤 문제가 발생하는가?
		// Son s3 = (Son) new Papa();
		// Son s3 = { money=150, car=2/@toString }-{ money=10/toString }
		//			3번지							  -{ money=10/toString }
		// Type mismatch: cannot convert from Papa to Son
		// 타입캐스팅을 해도 컴파일을 돌리면 문제가 생김

		// Step4 Q6. Papa p4 = new Son(); 실행 시 메모리 구조와 출력 결과를 설명하시오.
		// [money=10 ,toString]
		// s2 = 4번지 Son(){money=150,car=2/toString}- Papa(){money=10/-} @Override
		Papa p4 = new Son(); 
		//Papa p4 =										-{ money=10/toString } 보장
		//		4번지 Son(){ money=150, car=2/@toString }-{ money=10/- }	실제 보장범위
		// 생성자 불러서 초기화()를 진행하고 Son의 변수도 사용할 수 있게 됨
		System.out.println(p4);
		System.out.println(p4.money);
		
		// Step5 Q7. p4에서 Son의 money를 사용하는 방법은?
		System.out.println(((Son)p4).money);
		System.out.println(((Son)p4).car);
		

		// Q8 오버로딩/오버라이딩이란?
		// 오버로딩 : 메서드의 이름을 같게, 알규먼트 자료형과 갯수를 다르게해서 구분 / 비슷한기능
		// 오버라이딩 : 상속시 부모의 메서드를 자식에게 맞게 수정해서 사용
		
		Papa p5 = new Son(); 
		// 1. 부모 = 자식 / 업캐스팅
		Son s5 = (Son) p5; 
		// 2. 자식 = 부모 / 다운캐스팅/ 타입캐스팅필요 / 부모가 자식생성자를 호출한적이 있어야 한다.
		// Son s5 [money=150,car=2/toString]-[money=10/toString ]
		// p5 = 5번지 Son(){money=150,car=2/ toString}- Papa(){money=10 /-}
		
		System.out.println(s5.money); // 150
		System.out.println(((Papa) s5).money); // 10
		System.out.println(((Papa) s5).toString()); // Son [money=150, car=2]

	}
}
