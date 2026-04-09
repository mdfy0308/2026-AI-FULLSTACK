package com.the703.basic007_ex;

public class For2Ex002 {

	public static void main(String[] args) {
//		@###
//		#@##
//		##@#
//		###@
		
		// 1) 눈에 보이는 대로
//		System.out.print('@'); System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
//		System.out.print('#'); System.out.print('@'); System.out.print('#'); System.out.print('#'); System.out.println();
//		System.out.print('#'); System.out.print('#'); System.out.print('@'); System.out.print('#'); System.out.println();
//		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('@'); System.out.println();
		
		
		//2) 칸 정리 
//		for(int i=1;i<=4;i++){ System.out.print(i==1? '@':'#'); } 
//		System.out.println();
		// 줄번호와 i의 값이 일치할 때 @를 출력
		
		
		//3) 총정리
		for(int li=1;li<=4;li++) {
			for(int i=1;i<=4;i++){ System.out.print(i==li? '@':'#'); } 
			System.out.println();
		}

		
	} //

} //
