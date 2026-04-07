package com.the703.basic006_ex;

public class ForEx003 {

	public static void main(String[] args) {
		
//		for 이용
//		1~10까지의 합을 구하시오. 
		
		//변수
		int hap = 0;
		
		//입력
		
		//처리 - 1~10까지의 합을 구하시오.
		//hap[0] > hap = 0
		//hap[1] > hap = 1		0+1			hap = hap+1
		//hap[2] > hap = 3 		(0+1)+2		hap = hap+2
		//hap[3] > hap = 6 		(0+1+2)+3	hap = hap+3
		
		//처리
		for(int i=1; i<=10; i++) { hap = hap + i; }
		
		//출력
		System.out.println("합 : " + hap);

	} // 

} //
