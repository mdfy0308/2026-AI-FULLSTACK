package com.the703.basic008_ex;

public class ArrayNewEx001 {

	public static void main(String[] args) {
		
//		1. 배열명 : arr     
//	    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5    
//	       for+length 이용해보기
//	    3. for + length 로 출력

		double[] arr = new double[5];
		double data = 1.1;
		
		for(int i=0;i<arr.length;i++) { arr[i] = data; data += 0.1; }
		
		for(int i=0;i<arr.length;i++) { System.out.printf("%.1f\t", arr[i]); }
		
		
		
	} //

} //
