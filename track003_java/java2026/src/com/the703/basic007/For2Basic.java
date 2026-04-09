package com.the703.basic007;

public class For2Basic {

	public static void main(String[] args) {

		
		//ver-2 각 칸 정리, for {영역} {변수} for{시작;종료;변화}
		
		System.out.println("1층");
		for(int kan=1;kan<=3;kan++)
		{ System.out.print(kan); } System.out.println();
		
		//ver-2 각 층 정리, for {영역} {변수} for{시작;종료;변화}
		
		System.out.println("2층");
		for(int kan=1;kan<=3;kan++)
		{ System.out.print(kan); } System.out.println();
		
		//ver-3 층+칸 모두 정리
		for(int fl=1;fl<=2;fl++){ 
			System.out.println(fl+"층"); 
			for(int kan=1;kan<=3;kan++) { System.out.print(kan); } 
			System.out.println();
		}
				
	} //

} //
