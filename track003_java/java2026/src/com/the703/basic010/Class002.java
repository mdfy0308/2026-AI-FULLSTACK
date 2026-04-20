package com.the703.basic010;

// 1. 클래스는 부품객체
// 2. 클래스는 상태(멤버변수)와 행위(멤버함수)

class FishBB {
	// 멤버 변수
	String bread;
	int cream;

	// 멤버 함수
	void show() {
		System.out.println(bread + "가루에 크림 " + cream + "스푼이 들어간 빵");
	}
}

public class Class002 {

	public static void main(String[] args) {

		FishBB my1 = new FishBB();
		// 1. new(1번지, 객체 생성)
		// 2. FishBB() 초기화
		// 3. my1 주소 = 1번지

		my1.bread = "아몬드";
		my1.cream = 3;
		my1.show();

	}//
}//

//////////////////////////////////////////////////////
/*
 * [RUNTIME DATA AREA]
 * ------------------------------------------------------------ [METHOD:정보]
 * FishBB.class(설계도) / Class002.class #1)
 * ------------------------------------------------------------ [HEAP:동적] |
 * [STACK:지역] 1번지 : FishBB{bread=null, cream=0, show()} ← my1(1번지) | main #2
 * ------------------------------------------------------------
 */
//////////////////////////////////////////////////////