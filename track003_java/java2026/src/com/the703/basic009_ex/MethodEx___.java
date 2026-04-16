package com.the703.basic009_ex;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx___ {

	public static int[] process_total(int[] a, int[] b, int[] c) {
		int[] total = new int[5];
		for (int i = 0; i < a.length; i++) {
			total[i] = a[i] + b[i] + c[i];
		}
		return total;
	}

	public static int[] process_avg(int[] num) {
		int[] aver = new int[5];
		for(int i=0; i<num.length; i++) {
			aver[i] = num[i] / 3;
		}
		return aver;
	}

//	public static String process_pass(float aver, int k, int e, int m) {
//		return aver < 60 ? "불합격" : k < 40 || e < 40 || m < 40 ? "불합격" : "합격";
//	}
//
//	public static String process_scholar(float aver) {
//		return aver >= 95 ? "장학생" : "----";
//	}
//
//	public static String process_star(float avg) {
//		String st = "";
//		for (int i = 1; i <= (int) (avg / 10); i++) {
//			st += "*";
//		}
//		return st;
//	}
//
//	public static void process_show(String st, int k, int e, int m, int t, float aver, String ps, String sch,
//			String rank) {
//		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
//		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
//		System.out.println("-------------------------------------------------------------------------------");
//		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%s\t%s\n", st, k, e, m, t, aver, ps, sch, rank);
//		System.out.println("-------------------------------------------------------------------------------");
//	}

	//////////////////////////////////////////////////////
	public static void main(String[] args) {

//		(1)  변수
		String[] name = { "아이언맨", "헐크", "캡틴", "토르", "호크아이" };
		int[] kor = { 100, 100, 100, 70, 35 };
		int[] eng = { 100, 100, 100, 80, 35 };
		int[] math = { 100, 100, 100, 60, 35 };
		int[] avg = new int[5];
		int[] rank = { 1, 1, 1, 1, 1 };
		boolean chk = false;

		String[] num = new String[5];
		String[] pass = new String[5];
		String[] sch = new String[5];

//		(3) 처리 : 
		int[] total = process_total(kor, eng, math); // 1. 총점처리
		System.out.println(Arrays.toString(total));

		avg = process_avg(total); // 2. 평균처리
		System.out.println(Arrays.toString(avg));
//
//		3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
//		pass = process_pass(avg, kor, eng, math);
//
//		4. 평균이 95점이상이면 장학생
//		jang = process_scholar(avg);
//
//		5. 평균점수대로 별표 붙이기, 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
//		star = process_star(avg);
//
//		(4) 출력
//		process_show(name, kor, eng, math, total, avg, pass, jang, star);
//
	} //

} //
