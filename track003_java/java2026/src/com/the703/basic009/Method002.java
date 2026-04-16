package com.the703.basic009;

public class Method002 {
	
	
	// 1.         리턴값 메서드명(파라미터★)
	public static void hello(String name) { // String name = "고양이" 대입
		System.out.println("Hello! " + name);
	}
	
	public static void icecream(int num) {
		System.out.println("아이스크림 " + num +"개");
	}
	
	public static void info(String name, int score) {
		System.out.printf("%s : 최종 %d점\n", name, score);
	}
	
	//////////////////////////////////////////////
	public static void main(String[] args) {
		
		hello("카피바라");
		hello("쿼카");
		
		icecream(1);
		icecream(2);
		
		info("alpha", 10); // alpha 최종 10점
		info("beta", 9);

	}
	//////////////////////////////////////////////

}
