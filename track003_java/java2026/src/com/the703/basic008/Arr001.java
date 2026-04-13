package com.the703.basic008;

import java.net.MulticastSocket;

public class Arr001 {

	public static void main(String[] args) {
		
		// 1. 변수 활용하는 방법
		int a=1, b=2, c=3;
		
		// 2. 배열?
		/* [같은 타입]의 데이터를 [연속된 공간에 저장]하는 자료 구조 
		 - 각 데이터의 저장위치를 [index]를 통해 접근
		 - 1) int [] arr 주소 보관할 준비
		 - 2) null 공간은 있지만 값이 없다
		*/
		
		int [] arr = null; // 초기값 지정
		System.out.println(arr);
		
		// [stack]arr2 주소 보관 = [heap] 1,2,3 연속된 공간에 저장
		int []    arr2		  = {1, 2, 3}; // 3개 > 0~2
		// arr2(1000번지)		  → 1000번지 {1,   2,   3}
		//								[0], [1], [2]
		System.out.println(arr2); // [I@372f7a8d
		System.out.println("1 꺼내쓰기 > " + arr2[0]);
		System.out.println("2 꺼내쓰기 > " + arr2[1]);
		System.out.println("3 꺼내쓰기 > " + arr2[2]);
		
		
		// 3. 배열 예시
		// 3-1. arr3 : 1 2 3 4 5
		
		int [] arr3 = {1, 2, 3, 4, 5}; //0~4
		System.out.println(arr3[2]);
		
		//3-2. arr4 : 100 200 300
		int [] arr4 = {100, 200, 300}; //0~2
		System.out.println(arr4[0]);
		
		//3-3. arr5 : 1.1 1.2 1.3 //0~2
		double [] arr5 = {1.1, 1.2, 1.3}; // 1.3 꺼내쓰려면?
		System.out.println(arr5[2]);
		
		//3-4. arr6 : 'a', 'b', 'c'
		char [] arr6 = {'a', 'b', 'c'}; //0~2
		System.out.print(arr6[0]+"\t");
		System.out.print(arr6[1]+"\t");
		System.out.print(arr6[2]+"\t");
		
		//3-5. 41~44 for로 출력
		System.out.println();
		System.out.println(arr6.length); // 갯수
		for(int i=0;i<arr6.length;i++) { System.out.print(arr6[i] + (i<(arr6.length - 1)? ", " : ""));}
		
		

	} // end main

} // end class
