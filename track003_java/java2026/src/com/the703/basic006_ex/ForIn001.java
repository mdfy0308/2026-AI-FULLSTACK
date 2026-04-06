package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001 {

	public static void main(String[] args) {
		
		//변수
		Scanner sc = new Scanner(System.in);
		int kor = -1, eng = -1, math = -1, total= -1;
		double avg= 0.0;
		String stdid="", pass="불합격", sch="X", level="가";		
		
	
		//입력 0~100만 입력받고 그 외의 경우 다시 입력하게
		System.out.print("학번 입력 > "); 
		stdid = sc.next();
		
		for(;;) {
			System.out.print("국어점수 입력(0~100) > "); 
			kor = sc.nextInt();
			if(kor>=0 && kor <=100){ break; }
		}
		
		for(;;) {
			System.out.print("영어점수 입력(0~100) > "); 
			eng = sc.nextInt();
			if(eng>=0 && eng<=100){ break; }
		}
		
		for(;;) {
			System.out.print("수학점수 입력(0~100) > "); 
			math = sc.nextInt();
			if(math>=0 && math <=100){ break; }
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
