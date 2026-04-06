package com.the703.basic005;

public class Switch001 {

	public static void main(String[] args) {
	
		

		// 1. if(조건문) { 실행 }
		int num = 4;
		String result = "";
		
		if(num == 1) {
			System.out.println("1이다.");
		} else if (num == 2) {
			System.out.println("2이다.");
		} else if (num == 3) {
			System.out.println("3이다.");
		} else { System.out.println("1, 2, 3이 아니다."); }
		
		
		// 2. switch
		/* switch(대상) {
		  조건1 : 처리 break; (처리 후 break)
		  조건2 : 처리 break;
		  default : 조건이 아닐 때
		  } > 맞다, 틀리다가 확실하지 않음
		*/
		
		switch(num) {
		case 1 : result = "1이다."; break; // break가 없으면 전부 출력함
		case 2 : result = "2이다."; break;
		case 3 : result = "3이다."; break;
		default : result = "1, 2, 3이 아니다."; break;
		}
		
		System.out.println(result);


	} // end main

} // end class
