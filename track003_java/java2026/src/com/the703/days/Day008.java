package com.the703.days;

import java.util.Scanner;

public class Day008 {

	public static void main(String[] args) {
		
		//변수
		Scanner sc = new Scanner(System.in);
		int kor = -1, eng = -1, math = -1, total = -1;
		double avg = 0.0;
		String stdid = "", pass = "불합격", level = "가", sch = "X";
		
		//입력
		
		
		System.out.print("학번 입력 > ");
		stdid = sc.next();
		
		for(;;) { break; }
		
		System.out.print("국어점수 입력 > ");
		kor = sc.nextInt();
		
		System.out.print("영어점수 입력 > ");
		eng = sc.nextInt();
		
		System.out.print("수학점수 입력 > ");
		math = sc.nextInt();
		
		
		
		//처리
//		1. 총점 구하기
		total = kor + eng + math;
		
//		2. 평균 구하기
		avg = (double)total / 3;

//		3. 평균 60이상 / 각 과목 40 미만이 아니라면 합격/불합격
		pass = avg<60? "불합격":kor<40 || eng<40 || math<40? "불합격":"합격";
		
//		4. 평균이 95 이상이면 장학생
		sch = avg >= 95? "장학생":"X";
		
//		5. 평균이 90이상이면 수, 80은 우, 70은 미, 60은 양, 아니라면 가
		level = avg>=90? "수":avg>=80? "우":avg>=70? "미":avg>=60? "양":"가";
				
		//출력
		System.out.println("=====================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("=====================================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s", stdid, kor, eng, math, total, avg, pass, level, sch);
		
	}// end main

} // end class

// 3. 필수조건
// q1-1 int형 변수 x가 60 이상일때 조건식 (x >= 60)
// q1-2 char형 변수 ch가 'a' 또는 'A'일때 True (ch == 'a' || ch == 'A')
// q1-3 char형 변수 ch가 숫자('0'~'9')일때 (ch >= '0' && ch <= '9')
// q1-4 char형 변수 ch가 영문자(대문자)일때 (ch >= 'A' && ch <= 'Z')
