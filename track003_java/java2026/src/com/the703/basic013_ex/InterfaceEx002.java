package com.the703.basic013_ex;

/* 

			Vehicle		{	run()	}		←	Driver
		↑			↑	
	MotorCycle		Car
	{ @run() }	 { @run() }
*/

interface Vehicle {
	public void run();
}

class MotorCycle implements Vehicle {
	@Override
	public void run() {
		System.out.println("오토바이가 달립니다.");
	}

	public void helmet() {
		System.out.println("헬멧을 착용합니다.");
	}
}

class Car implements Vehicle {
	@Override
	public void run() {
		System.out.println("자동차가 달립니다.");
	}
}

class Driver {
	void drive(Vehicle v) { // Vehicle v = car, mo
		if (v instanceof MotorCycle) {
			((MotorCycle) v).helmet();
		}
		// 만약에 모터사이클이라면 helmet() 호출
		v.run(); // 기본 다형성 동작 - override 된 자식 메서드

	}
}

public class InterfaceEx002 {

	public static void main(String[] args) {

		Driver driver = new Driver();

		Car car = new Car();
		MotorCycle mo = new MotorCycle();

		// 리턴값 메서드명(파라미터) { }
		// car, mo 두개의 값을 다 담을 수 있는 자료형 / 부모=자식
		// void drive(Vehicle v)
		driver.drive(car); // 자동차가 달립니다.
		driver.drive(mo); // 오토바이가 달립니다.

	}//

}//

/*
 * 출력 : 자동차가 달립니다. 오토바이가 달립니다.
 * 
 */