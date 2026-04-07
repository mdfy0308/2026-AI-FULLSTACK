package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001_3 {

	public static void main(String[] args) {
		
		//변수
		//자료형 : 기본형/참조형(String)
		//기본형 : 정수 byte-short-int-long / 실수 float-double
		Scanner sc = new Scanner(System.in);
		int kor = -1, eng = -1, math = -1, total= 0; // 초기값은 범위 밖의 숫자로
		double avg= 0.0;
		String stdid="", pass="불합격", sch="X", level="가";		
		
	
		//입력
		System.out.print("학번 입력 > "); 
		stdid = sc.next();
		
		for(;;) {
			if(kor<0||kor>100) {
				System.out.print("국어점수 입력(0~100) > "); kor = sc.nextInt();
			} else if(eng<0||eng>100) {
				System.out.print("영어점수 입력(0~100) > "); eng = sc.nextInt();
			} else if(math<0||math>100) {
				System.out.print("수학점수 입력(0~100) > "); math = sc.nextInt();
			} else { break; } // kor, eng, math의 입력을 잘 한 경우
		}
		
		//처리
		total = kor + eng + math;
		avg = total / 3.00;
		pass = avg < 60? "불합격":kor<40 || eng<40 || math<40? "불합격":"합격";
		sch = avg>=95? "장학생":"X";
		level = avg>=90?"수":avg>=80?"우":avg>=70?"미":avg>=60?"양":"가";
		
		
		//출력
		System.out.println("=========================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("=========================================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s", stdid, kor, eng, math, total, avg, pass, level, sch);

	}

}
