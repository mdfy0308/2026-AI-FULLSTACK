package com.the703.basic008_ex;

public class Array2Ex004 {

	public static void main(String[] args) {

		// 배열을 이용하여 다음의 프로그램을 작성하시오.
		// 1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.
		int[][] datas = { 
				{ 10, 10, 10, 10 }, 
				{ 20, 20, 20, 20 }, 
				{ 30, 30, 30, 30 }, 
		}; // 3층 4칸
		
		int[][] result = new int[datas.length + 1][datas[0].length + 1];

//		#1. result 에 datas 데이터 복사하기
//		#2. 가로방향누적데이터
//		#3. 세로방향데이터누적
//		#4. 총합

		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				result[i][j] = datas[i][j]; // 데이터 복사
				result[i][datas[i].length] += result[i][j]; // 가로방향 누적
				result[datas.length][j] += result[i][j]; // 세로방향 누적
			}
			result[datas.length][datas[i].length] += result[i][datas[i].length]; // 총합
		}

//		출력내용:
//		10   10   10   10   40 
//		20   20   20   20   80
//		30   30   30   30   120
//		60   60   60   60   240

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}

	} //

} //
