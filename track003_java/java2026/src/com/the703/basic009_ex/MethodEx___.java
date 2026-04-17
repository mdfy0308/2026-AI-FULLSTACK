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
		for (int i = 0; i < num.length; i++) {
			num[i] = num[i] / 3;
		}
		return num;
	}

	public static String[] process_pass(int[] avg, int[] k, int[] e, int[] m) {
		String[] pass = new String[5];
		for (int i = 0; i < avg.length; i++) {
			if (avg[i] < 60) {
				pass[i] = "불합격";
			} else if (k[i] < 40 || e[i] < 40 || m[i] < 40) {
				pass[i] = "불합격";
			} else { // 그 외 합격
				pass[i] = "합격";
			}
		}
		return pass;
	}

	public static String[] process_scholar(int[] avg) {
		String[] scholar = new String[5];
		for (int i = 0; i < avg.length; i++) {
			if (avg[i] >= 95) {
				scholar[i] = "장학생";
			} else {
				scholar[i] = "----";
			}
		}
		return scholar;
	}

	public static String[] process_star(int[] avg) {
		String[] st = { "", "", "", "", "" };
		for (int i = 0; i < avg.length; i++) {
			for (int j = 0; j < (avg[i] / 10); j++) {
				st[i] += "*";
			}
		}
		return st;
	}

	public static void process_show(String[] name, int[] kor, int[] eng, int[] math, int[] total, int[] avg,
			String[] pass, String[] jang, String[] rank) {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
		System.out.println("-------------------------------------------------------------------------------");

		for (int i = 0; i < name.length; i++) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s\n", name[i], kor[i], eng[i], math[i], total[i],
					avg[i], pass[i], jang[i], rank[i]);
		}
		System.out.println("-------------------------------------------------------------------------------");
	}

	//////////////////////////////////////////////////////
	public static void main(String[] args) {

//		(1)  변수
		String[] name = { "아이언맨", "헐크", "캡틴", "토르", "호크아이" };
		int[] kor = { 100, 100, 100, 70, 35 };
		int[] eng = { 100, 100, 100, 80, 35 };
		int[] math = { 100, 100, 100, 60, 35 };
		int[] avg = new int[5];

		String[] rank = new String[5];
		String[] num = new String[5];
		String[] pass = new String[5];
		String[] sch = new String[5];
		String[] jang = new String[5];

//		(3) 처리 : 
		int[] total = process_total(kor, eng, math); // 1. 총점처리

		avg = process_avg(total); // 2. 평균처리

//		3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
		pass = process_pass(avg, kor, eng, math);

//		4. 평균이 95점이상이면 장학생
		jang = process_scholar(avg);

//		5. 평균점수대로 별표 붙이기, 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
		rank = process_star(avg);

//		(4) 출력
		process_show(name, kor, eng, math, total, avg, pass, jang, rank);

	} //

} //
