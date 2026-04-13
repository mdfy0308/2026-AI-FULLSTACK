package com.the703.basic008_ex;

import java.util.Arrays;

public class ArrayEx014 {

	public static void main(String[] args) {

	// 1~45중에서 겹치지 않게 숫자 6개를 만들어 로또번호 프로그램을 작성하시오.
		
		int lotto[] = new int[6];
		
		for(int i=0;i<lotto.length;i++) {
			lotto[i] = (int)(Math.random()*45+1);
//			for(int j=0;j<lotto.length;j++) {
//				if(lotto[i]==lotto[j]) { 
//					lotto[j] = (int)(Math.random()*45+1); j = 0; continue;
//				} else { break; }
//			}
		}
		
		System.out.println(Arrays.toString(lotto));

	} //

} //
