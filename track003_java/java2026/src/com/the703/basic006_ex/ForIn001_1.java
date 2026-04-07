package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001_1 {

	public static void main(String[] args) {
		
		//변수
		//자료형 : 기본형/참조형(String)
		//기본형 : 정수 byte 1-short 2-★int 4-long 8 / 실수 float 4-★double 8
		Scanner sc = new Scanner(System.in);
		int kor = -1, eng = -1, math = -1, total= -1;
		double avg= 0.0;
		String stdid="", pass="불합격", sch="X", level="가";		
		
	
		//입력
		// 문자열: next() / 정수형 nextInt() / 실수형 nextDouble() / 문자: next().charAt(0)
		System.out.print("학번 입력 > "); 
		stdid = sc.next();
		
		for(; !(kor>=0 && kor <=100) ;) { // 조건 : 0~100사이의 범위가 아니라면
			System.out.print("국어점수 입력(0~100) > "); 
			kor = sc.nextInt();
		}
		
		for(;;) {
			System.out.print("영어점수 입력(0~100) > "); 
			eng = sc.nextInt();
			if(eng>=0 && eng<=100){ break; }
		}
		
		for(; math<0 || math>100 ;) { // 조건 : 0보다 작거나 100보다 크다면
			System.out.print("수학점수 입력(0~100) > "); 
			math = sc.nextInt();
		}
		

		//처리- 연산자 먼저() 값(++,--,산술) 비교(><==) 조건(&& || ?:) 대입(=)
		// 	 - 제어문(if/switch) 반복(for/while/do while)
		total = kor + eng + math;
		avg = total / 3.0; // 강제형변화 or 정수/실수 
		pass = avg < 60? "불합격":kor<40 || eng<40 || math<40? "불합격":"합격";
		if (avg>=95) { sch = "장학생";}
		
		// level = avg>=90?"수":avg>=80?"우":avg>=70?"미":avg>=60?"양":"가";
		// 위와 같은 내용을 switch로
		switch((int)avg/10) {
		case 10: case 9: level="수"; break;
		case 8: 		 level="우"; break;
		case 7: 		 level="미"; break;
		case 6: 		 level="양"; break;
		default: 		 level="가"; break;
		}
		
		
		//출력
		System.out.println("=========================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("=========================================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s", stdid, kor, eng, math, total, avg, pass, level, sch);

	}

}
