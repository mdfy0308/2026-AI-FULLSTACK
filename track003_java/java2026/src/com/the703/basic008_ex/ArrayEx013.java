package com.the703.basic008_ex;

import java.util.Arrays;

public class ArrayEx013 {

	public static void main(String[] args) {
		// datas 배열에는 각 회원의 보험 실적 건수마다 datas 배열에 아이디가 적혀있음
		// 회원번호 1~4까지의 각 실적의 갯수를 세어서 갯수만큼 stars 배열에 갯수를 담기
		// 해당 숫자만큼 *을 출력하는 프로그램
		// stars[0] stars[1]  stars[2]   stars[3]
		// [5,          1,         2,   		3]
		// *****
		// *
		// **
		// ***
		
		int[] datas = { 1, 3, 1, 1, 4, 4, 3, 1, 4, 1, 2 }; // 각 번호가 몇개인지 세어서 넣으라는 거였다...
		int[] stars = new int [4];
		
		
		// datas의 배열에서 회원번호가 각각 몇개인지 확인하기
		
		for(int i=0;i<datas.length;i++) {
			if (datas[i]>=1 && datas[i]<=4) { stars[datas[i]-1] += 1; }
		}
 
		// 해당되는 갯수만큼 * 출력
		System.out.println(Arrays.toString(stars));
		for(int i=0;i<stars.length;i++) {
			for(int j=1;j<=stars[i];j++) {System.out.print("*");}
			System.out.println();
		}
				

	} //

} //
