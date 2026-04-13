package com.the703.basic008_ex;

public class ArrayEx010 {

	public static void main(String[] args) {
		// su[4]의 등수를 구하시오.
		int [] su = {-3, -5, -1, -9, -7};
		int rank = 1;
		
		for(int i=0;i<su.length;i++) {
			if(su[4]<su[i]) { rank++;}
		} System.out.printf("등수 : %d등", rank);
		
		
	} //

} //
