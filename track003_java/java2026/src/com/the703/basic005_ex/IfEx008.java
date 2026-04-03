package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx008 {

	public static void main(String[] args) {
		
		
		// 변수
		Scanner sc = new Scanner(System.in);
		int kor = 0, eng = 0, math = 0, total = 0;
		double avg = 0.0;
		String stdid="", pass="불합격", level="가", sch="X";
		
		//입력
		//학번 입력 > std111
		//국어점수 입력 > 100
		//수학점수 입력 > 100
		//영어점수 입력 > 99	
		System.out.print("학번 입력 > "); stdid = sc.next();
		System.out.print("국어점수 입력 > "); kor = sc.nextInt();
		System.out.print("영어점수 입력 > "); eng = sc.nextInt();
		System.out.print("수학점수 입력 > "); math = sc.nextInt();
		
		
		// 처리
		//1. 총점 구하기
		total = kor + eng + math;
		
		//2. 평균 구하기
		avg = (double)total / 3; // 둘중의 하나는 실수로 만든다
		// avg = total / 3.0;
		
		//3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
		// if(avg >= 60 && kor >= 40 && eng >= 40 && math >= 40) { pass="합격"; }
		pass = avg < 60? "불합격":kor<40 || eng<40 || math<40? "불합격":"합격";
		
		//4. 평균이 95점이상이면 장학생
		//if(avg>=95){sch = "장학생";}
		sch = avg>=95? "장학생":"X";
		// sch = avg<95? "" : "장학생";
		
		//5. 평균이 90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 
		level = avg>=90?"수":avg>=80?"우":avg>=70?"미":avg>=60?"양":"가";
		
		
		// 출력
		//============================================= 
		//학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
		//=============================================
		//std111   100   100   99   299   99.67   합격   수   장학생
		System.out.println("=========================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("=========================================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s", stdid, kor, eng, math, total, avg, pass, level, sch);
		

	} // end main

} // end class

