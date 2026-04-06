package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx007 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int avg = 0;
		String result = "";
		
		System.out.print("평균 입력 > ");
		avg = sc.nextInt();
		
		
	//	평균 한 개 입력받아
	//    90~100점대면 수 9~10
	//    80~90점(90점미만)대면  우
	//    70~80점(80점미만)대면  미
	//    60~70점(70점미만)대면  양
	//    나머지 가
		
		switch (avg/10) {
		case 9:case 10: result = "수"; break;
		case 8 : result = "우"; break;
		case 7 : result = "미"; break;
		case 6 : result = "양"; break;
		default: result = "가"; break;
		}
		
		System.out.println(result);
	
	
	 
	
	
	} //
	

} //
