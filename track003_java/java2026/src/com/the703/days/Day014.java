package com.the703.days;

import java.util.Arrays;
import java.util.Scanner;

public class Day014 {

	public static void main(String[] args) {
		// 복습문제
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자 입력(1,2,3) > ");
		int day = scanner.nextInt();

//		1. if 버전
//		정수를 하나 입력받아 다음 조건에 따라 요일을 출력하는 프로그램을 작성하시오.
//		1이라면 1이다, 2라면 2이다, 3이라면 3이다    1,2,3이 아니다
		if(day==1) { System.out.println("1이다.");}
		else if(day==2) { System.out.println("2이다.");}
		else if(day==3) { System.out.println("3이다.");}
		else { System.out.println("1, 2, 3이 아니다.");}


//		2. switch 버전 - 위의 문제를 switch 문으로 작성하시오.
		switch(day) {
		case 1: System.out.println("1이다."); break;
		case 2: System.out.println("2이다."); break;
		case 3: System.out.println("3이다."); break;
		default: System.out.println("1, 2, 3이 아니다."); break;
		}


//		3. for, while, do while 버전
//		1 2 3 4  


//		4. 이중 for 버전
//		다음과 같은 모양을 출력하는 프로그램을 작성하시오.
//		★
//		★★
//		★★★


//		5. 1차원배열  다음에 해당하는 값에서 index를 이용하여 3을 출력해주세요!
		int [] arr2 = {1,2,3}; // 0~2
		
		System.out.println(arr2[2]);


//		6. 1차원배열      new 연산자 이용해서 배열만들기
//		    1. 배열명 : arr     
//		    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5    
//		       for+length 이용해보기
//		    3. for + length 로 출력
		
		double[] arr = new double[5];
		double data = 1.1;
		
		for(int i=0;i<arr.length;i++) { arr[i] = data; data += 0.1; }
		
		for(int i=0;i<arr.length;i++) { System.out.printf("%.1f%s\t", arr[i], i<(arr.length - 1)? ", ":""); }

		
		
		
		
	} //

} //
