package com.the703.basic009;

public class Method001 {
	
	//#1. 마법상자(함수, 메서드, funtion) - 원하는 기능을 해주는 box
	//아무데서나 접근 가능한(public)
	//어디서나 사용 가능한(static)
	//			  	결과물(리턴값)	메서드명(파라미터)
	public 	 static 	void 	hello() { // 여기서부터
		
		System.out.println("Hello");
		
	} // 여기까지
	
	public static void line() {
		System.out.println("------------------");		
	}
	
	///////////////////////////////////////////////
	public static void main(String[] args) {
		
		hello(); // 2. 메서드를 호출하면 {} 처리한다
		line();

	} 
	///////////////////////////////////////////////

	
} //
