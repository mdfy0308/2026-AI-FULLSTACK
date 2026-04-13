package com.the703.basic008_ex;

public class ArrayEx012 {

	public static void main(String[] args) {
		// 모든 값을 더하는 프로그램을 완성하시오
		
		int[] arr = {10, 20, 30, 40, 50};
		int box = 0;
		
		for(int i=0;i<arr.length;i++) { box += arr[i]; }
		System.out.println("sum = " + box);

		
	} //

} //
