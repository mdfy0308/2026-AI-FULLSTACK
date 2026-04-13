package com.the703.basic008_ex;

public class ArrayEx009 {

	public static void main(String[] args) {
		int [] su = {-3, 5, -1, 9, -7, 2, -11};
		int result = 0;
		
		for(int i=0;i<su.length;i++) {
			if(!(su[i]<0 || su[i]%2==0)) { result += su[i]; }
		} System.out.println("양수인 홀수의 합: " + result);

		
		
	} //

} //
