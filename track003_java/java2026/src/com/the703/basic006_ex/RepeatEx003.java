package com.the703.basic006_ex;

public class RepeatEx003 {

	public static void main(String[] args) {
		// for, while, do while
		// 1~30의 범위에서 3의 배수이면서 2의 배수인 숫자와 갯수를 구하는 프로그램을 작성하시오.
		// 제일 작은 단위부터, 말로 풀어쓰기 : 만약 n이 3의 배수이면서 2의 배수라면 > 출력+카운트
		
		//for
		int i = 1, cnt = 0;
		
		for(i=1;i<=30;i++) {
			if(i%3==0 && i%2==0) {
				System.out.println(++cnt+".3의 배수이면서 2의 배수인 숫자 : "+i);}
		} System.out.println("for) 갯수 : " + cnt);
		
		
		//while
		i = 1; cnt = 0;
		
		while(i<=30)  {
			if(i%3==0 && i%2==0) {
				System.out.println(++cnt+".3의 배수이면서 2의 배수인 숫자 : "+i);} i++;
		} System.out.println("while) 갯수 : " + cnt);

		
		//do while
		i = 1; cnt = 0;
		do { 
			if(i%3==0 && i%2==0){
				System.out.println(++cnt+".3의 배수이면서 2의 배수인 숫자 : "+i);} i++;
		} while (i<=30);
		System.out.println("do while) 갯수 : " + cnt);

		
		
	} // end main

} // end class