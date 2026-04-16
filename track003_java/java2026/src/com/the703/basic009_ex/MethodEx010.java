package com.the703.basic009_ex;

public class MethodEx010 {
	
	public static void hello(int num) {
		if (num<1) { return; } // 빠져나오는 조건, 1보다 작으면 return; break같다
		System.out.println("Hello" + num); // 출력
		hello(--num); // num을 1 감소시키고 다시 hello 호출
	}
	
	// 재귀함수> 함수 내부에서 자기 자신을 호출하는 함수

	public static void main(String[] args) {

		// 재귀함수를 이용하여 다음 프로그램을 작성하시오.
		// Hello를 5번 출력하시오.
		
		hello(5);

	} //

} // 
