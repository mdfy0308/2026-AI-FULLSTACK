package com.the703.basic008;

import java.util.Arrays;

public class Arr002 {

	public static void main(String[] args) {
		// 배열
		// [같은타입]의 데이터를 [연속된 공간에] 저장하는 자료 구조
		// arr(1000번지) = 1000번지 {1, 2, 3} = 만드는 것과 동시에 값 넣기
		int [] arr = { 1,2,3 };
		
		int[] arr2 = new int[3];
		System.out.println(arr2);
		
//		arr2[0] = 0;
//		arr2[1] = 10;
//		arr2[2] = 20;
		
		int data = 0;
		for(int i=0;i<arr2.length;i++) { arr2[i] = data; data += 10; }
		
		System.out.println(Arrays.toString(arr2));
		
		
	} //

} //
