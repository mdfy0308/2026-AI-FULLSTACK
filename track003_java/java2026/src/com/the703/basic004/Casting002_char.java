package com.the703.basic004;

public class Casting002_char {

	public static void main(String[] args) {
		
		//#1. 문자 - 저장시 숫자, 출력시 문자
		char ch1 = ' '; // 공백이 하나라도 있어야 오류가 나지 않는다.
		char ch2 = '\u0000'; // 유니코드 초기화
		
		System.out.println("step1 :" + ch1 + "\t" + ch2);
		System.out.println("step2 :" + (int)ch1 + "\t" + (int)ch2);
		
		//#2. 문자
		char ch = 'A';
		System.out.println("step3 : " + ch + "\t" + (int)ch);
		System.out.println("step4 : " + (ch+1)); // 66
		//2-1) 'A'+1
		//2-2) char(65|2byte) + int(4byte)
		//2-3) 66
		
		System.out.println("step5 : " + (char)(ch+1));
		
		//Q.대문자 'A'를 소문자 'a'로 변환
		char q = 'A';
		char a = (char)(q + 32);
		System.out.println('A' + "\t" + 'a');
		System.out.println((int)'A' + "\t" + (int)'a');
		System.out.println(q + " 를 소문자로 변환시키려면 " + a);
		

	}

}
