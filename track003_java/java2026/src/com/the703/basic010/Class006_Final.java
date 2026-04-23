package com.the703.basic010;


//1. final 변경X

//1) 클래스는 부품객체
//2) 클래스(상속:x)는 상태(멤버변수:상수)와 행위(멤버함수)

/* final class : 재사용 하지마 - 상속 X */

class FinalEx extends Object {
	static final String child = "5-5"; // 클래스 변수 - method area
	String name; // 인스턴스 변수 - heap area - new O - 생성자() - this
	
	/* final */ void show() { System.out.println(child + "\t" + name); } // 인스턴스 메서드
}

class FinalExSon extends FinalEx {
	@Override void show() { System.out.println("나한테 맞게 수정"); }
}

// class Test extends Color{    }

public class Class006_Final {
	public static void main(String[] args) {

		System.out.println(FinalEx.child); // static final
		// FinalEx.child = "5-12";
		// The final field FinalEx.child cannot be assigned
	}

}

/***
 * 
 * final (하지 마)
 * 
 * 1) 클래스 ( 상속 X / 재사용 X / extends 사용 못함 ) 
 * 2) 멤버변수 ( 상수 O / 값 변경 X ) 
 * 3) 멤버함수 ( 부모기능 수정 X / @Override 못함 )
 * 
 * 
 */