package com.the703.basic006_ex;

public class RepeatEx002 {

	public static void main(String[] args) {
//		for , while , do while 3가지 버젼으로 
//		1~10까지 3의 배수의 합 : 18
		
		
//		ver-1) for

		int sum = 0;
		
		for(int i=1;i<=10;i++) {
			switch(i%3) {
			case 0: sum = sum+i; break;
			default: break; }
		}
		System.out.println("for) 3의 배수의 합 : " + sum);

		
//		ver-2) while
		
		int i = 1; 
		sum = 0;
		
		while(i<=10) { if(i%3 == 0) {sum = sum+i;} i++; }
		System.out.println("While) 3의 배수의 합 : " + sum);

		
//		ver-3) do while
		
		i = 1;
		sum = 0;
		
		do { if(i%3 == 0) {sum = sum+i;} i++; } while (i<=10);
		System.out.println("do While) 3의 배수의 합 : " + sum);
		
	} //

} //


//Q. 1~10 사이에서 3의 배수의 누적합 : 18;
//ver-1 말로 풀어쓰기, 가장 작은 단위부터
//만약 1이 3의 배수라면 > 누적합
//만약 2이 3의 배수라면 > 누적합
//만약 3이 3의 배수라면 > 누적합

//ver-2 구조로 바꾸기 - 제어, 반복
//if(만약 1이 3의 배수라면) { 누적합 담기 }
//if(만약 2가 3의 배수라면) { 누적합 담기 }
//if(만약 3이 3의 배수라면) { 누적합 담기 }

//ver-3 코드로 풀기 > 변수 찾고 반복문 작성
//int sum=0;
//if(1%3==0) {sum += 1;}
//if(2%3==0) {sum += 2;}
//if(3%3==0) {sum += 3;}


