package com.the703.basic008_ex;

public class ArrayNewEx002 {

	public static void main(String[] args) {
//		1. 배열명 : arr     
//	    2. 값 넣기 : A   B   C   D   E    for+length 이용해보기
//	    3. for + length 로 출력
		
		char [] arr = new char[5];
		char ch = 'A';
		
		for(int i=0;i<arr.length;i++) { arr[i] = ch; ch++; }
		for(int i=0;i<arr.length;i++) { System.out.print(arr[i] + "\t");}
		
	} //

} //
