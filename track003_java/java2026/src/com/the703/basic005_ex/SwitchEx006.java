package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx006 {

	public static void main(String[] args) {
//		문자 한 개 입력받아
//		   M이면 "월요일: 공부하는 날"
//		   T이면 "화요일: 운동하는 날"
//		   W이면 "수요일: 독서하는 날"
//		   F이면 "금요일: 영화 보는 날"
//		   S이면 "토요일: 여행 가는 날"
//		   U이면 "일요일: 휴식하는 날"
		
		Scanner sc = new Scanner(System.in);
		char ch = '\u0000';
		
		System.out.print("요일 입력 M, T, W, F, S, U >");
		ch = sc.next().charAt(0);
		
		switch(ch) {
		case 'M': case 'm': System.out.println("월요일: 공부하는 날"); break;
		case 'T': case 't': System.out.println("화요일: 운동하는 날"); break;
		case 'W': case 'w': System.out.println("수요일: 독서하는 날"); break;
		case 'F': case 'f': System.out.println("금요일: 영화 보는 날"); break;
		case 'S': case 's':System.out.println("토요일: 여행 가는 날"); break;
		case 'U': case 'u':System.out.println("일요일: 휴식하는 날"); break;
		}
		

	}

}
