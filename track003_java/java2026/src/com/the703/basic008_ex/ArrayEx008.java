package com.the703.basic008_ex;

public class ArrayEx008 {

	public static void main(String[] args) {
		// 음수의 갯수를 출력하시오
		
		int [] su = {-3, 5, -1, 9, -7};
		int cnt = 0;
		
		for(int i=0;i<su.length;i++) { if(su[i]<0) { cnt++; } }
		System.out.println("음수의 갯수 : " + cnt);

	}

}
