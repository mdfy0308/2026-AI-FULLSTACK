package com.the703.basic008_ex;

public class Array2Ex002 {

	public static void main(String[] args) {
//		1. new 연산자 이용하여 다차원배열만들기
//		2. for + length 이용해서 대입   
//		3. for + length 이용해서 출력 
//		   101   102   103
//		   104    105    106
		
		int[][] arr1 = new int[2][3];
		int data = 101;
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				arr1[i][j] = data; data++;
			}
		}
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				System.out.print(arr1[i][j] + "\t");
			} System.out.println();
		}
	} //

} //
