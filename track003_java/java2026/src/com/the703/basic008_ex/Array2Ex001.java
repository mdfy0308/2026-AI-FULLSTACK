package com.the703.basic008_ex;

public class Array2Ex001 {

	public static void main(String[] args) {

//		   이중for+ length 이용해서 출력하기 
		int[][] arr2 = { 
				{ 100, 200, 300 },
				{ 400, 500, 600 } 
		};
		
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				System.out.print(arr2[i][j] + "\t");
			} System.out.println();
		}

	} //

} //
