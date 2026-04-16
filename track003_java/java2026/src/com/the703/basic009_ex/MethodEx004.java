package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx004 {

	public static int process_total(int a, int b, int c) {
		return a + b + c;
	}

	public static float process_avg(int num) {
		return num / 3f;
	}

	public static String process_pass(float aver, int k, int e, int m) {
		return aver < 60 ? "불합격" : k < 40 || e < 40 || m < 40 ? "불합격" : "합격";
	}

	public static String process_scholar(float aver) {
		return aver >= 95 ? "장학생" : "----";
	}

	public static String process_star(float avg) {
		String st = "";
		for (int i = 1; i <= (int) (avg / 10); i++) {
			st += "*";
		}
		return st;
	}

	public static void process_show(String st, int k, int e, int m, int t, float aver, String ps, String sch,
			String rank) {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%s\t%s\n", st, k, e, m, t, aver, ps, sch, rank);
		System.out.println("-------------------------------------------------------------------------------");
	}

	//////////////////////////////////////////////////////
	public static void main(String[] args) {

//		(1)  변수
		String name = "";
		int kor, eng, math, total;
		float avg = 0.0f;
		String pass = "";
		String jang = "";
		String star = "";
		Scanner sc = new Scanner(System.in);

//		(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
		System.out.print("이름 입력 > "); name = sc.next();
		System.out.print("국어 점수 입력 > "); kor = sc.nextInt();
		System.out.print("영어 점수 입력 > "); eng = sc.nextInt();
		System.out.print("수학 점수 입력 > "); math = sc.nextInt();

//		(3) 처리 : 
		total = process_total(kor, eng, math); // 1. 총점처리
		avg = process_avg(total); // 2. 평균처리

//		3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
		pass = process_pass(avg, kor, eng, math);

//		//////// 4. 평균이 95점이상이면 장학생
		jang = process_scholar(avg);

//		//////// 5. 평균점수대로 별표 붙이기, 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
		star = process_star(avg);

//		(4) 출력
		process_show(name, kor, eng, math, total, avg, pass, jang, star);

	} //

} //
