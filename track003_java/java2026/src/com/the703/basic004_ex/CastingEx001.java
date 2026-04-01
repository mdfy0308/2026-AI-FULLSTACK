package com.the703.basic004_ex;

import java.util.Scanner;

public class CastingEx001 {

	public static void main(String[] args) {
		// 연습문제1)
//		패키지명 : com.company.java003_ex
//		클래스명 : CastingEx001
//		출력내용 :  Scanner 이용해서 나누기 프로그램만들기 
//		   숫자입력1>  _입력받기  10   ( ☆자료형을 int )
//		   숫자입력2>  _입력받기  3     ( ☆자료형을 int )              
//		   10 / 3 = 3.33
		
		//변수
		int num1, num2;
	    double result;
	    
	    Scanner sc = new Scanner(System.in);
	    	    
	    //입력
	    System.out.print("숫자입력1>");
	    num1 = sc.nextInt();
	    	    
	    System.out.print("숫자입력2>");
	    num2 = sc.nextInt();
	    
	    //처리
	    result = (double)num1 / num2;
	    
	    //출력
	    System.out.printf("%d / %d = %.2f", num1, num2, result);

//		※  형변환법 :    by = (byte) in;   
//		나 잠깐만 byte할게.... 데이터 누수있을수 있음!
	
	}

}
