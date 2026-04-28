package com.the703.basic013_ex;

/*
1) 상속도
					Object
  ↑
 Robot {   abstract charge() , move() , speak() }
		↑          ↑               ↑ 
CleaningRobot  SecurityRobot   CookingRobot   
{@charge() ,    {@charge() ,    {@charge() ,
@ move() ,     @move() ,           @move() , 
@ speak() }}         @speak() }}          @speak() }}

2)main */

abstract class Robot {

	String name;
	int level;
	
	public Robot() { super(); }
		
	public Robot(String name, int level) {
		super();
		this.name = name;
		this.level = level;
	}

	abstract void charge();
	abstract void move();
	abstract void speak();

}

class CleaningRobot extends Robot {

	@Override 
	void charge() { System.out.println(super.name + " 청소로봇 충전 중… 배터리 " + super.level + "%"); }

	@Override 
	void move() { System.out.println(super.name + " 청소로봇: 청소 중"); }

	@Override 
	void speak() { System.out.println(super.name + " 청소로봇: 먼지를 제거합니다!"); }

}

class SecurityRobot extends Robot {

	@Override 
	void charge() { System.out.println(super.name + " 경비로봇 태양광 충전 중… 배터리 " + super.level + "%"); }

	@Override 
	void move() { System.out.println(super.name + " 경비로봇: 순찰 중"); }

	@Override 
	void speak() { System.out.println(super.name + " 경비로봇: 이상 없음. 안전 확보!"); }

}

class CookingRobot extends Robot {

	@Override
	void charge() { System.out.println(super.name + " 요리로봇 인덕션 충전 중... 배터리 " + super.level + "%"); }

	@Override 
	void move() { System.out.println(super.name + " 요리로봇: 요리 중"); }

	@Override 
	void speak() { System.out.println(super.name + " 요리로봇: 오늘의 메뉴는 파스타입니다!" ); }

}

public class AbstractEx001 {
	public static void main(String[] args) {
		
		// Robot robot = new Robot(); 
		// Q1.why? 오류이유? 
		// abstract 메서드에는 {} 구현부가 없으므로 실체화도 불가
		
		System.out.println("--- 로봇 배열 시뮬레이션 ---");
		Robot[] bots = { new CleaningRobot(), new SecurityRobot(), new CookingRobot() };
		int[] levels = { 50, 70, 95 };
		int cnt = 0;
		for(Robot a : bots) { 
			a.level = levels[cnt];
			a.name = "Robo" + ++cnt;
			a.charge();
			a.move();
			a.speak();
		}
	}//
}//

/*
 * 
 * 출력화면 : --- 로봇 배열 시뮬레이션 --- 
 * Robo1 청소로봇 충전 중... 배터리 50% 
 * Robo1 청소로봇: 먼지를 제거합니다!
 * Robo2 경비로봇 태양광 충전 중... 배터리 70% 
 * Robo2 경비로봇: 이상 없음. 안전 확보!
 * Robo3 요리로봇 인덕션 충전 중... 배터리 95% 
 * Robo3 요리로봇: 오늘의 메뉴는 파스타입니다!
 * 
 */