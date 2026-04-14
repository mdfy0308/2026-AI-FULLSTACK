package com.the703.basic008_ex;

public class ArrayEx011 {

	public static void main(String[] args) {
		// 최대값, 최소값 구하기
		// 최대값: -1, 최소값: -9;
		
		int[] su = {-3, -5, -1, -9, -7};
		int max = -99999, min = 99999;
		
		for(int i=0;i<su.length;i++) {
			for(int j=0;j<su.length;j++) {
				if(su[i]<su[j]) { max = su[j]; }
				if(su[i]>su[j]) { min = su[j]; }
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		
	} //

} //
