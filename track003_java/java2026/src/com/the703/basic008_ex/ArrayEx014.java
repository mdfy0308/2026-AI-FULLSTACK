package com.the703.basic008_ex;

import java.util.Arrays;

public class ArrayEx014 {

	public static void main(String[] args) {

	// 1~45중에서 겹치지 않게 숫자 6개를 만들어 로또번호 프로그램을 작성하시오.
		
		int lotto[] = new int[6];
		
		for(int i=0;i<lotto.length;i++) {
			lotto[i] = (int)(Math.random()*45+1);
			
			for(int j=0;j<i;j++) { // 반복 범위 확인
				if(lotto[i]==lotto[j]) { lotto[i] = (int)(Math.random()*45+1); j=-1; break; }
			}
		} // 대입
		
//      int[] lotto = new int[6];
//      
//      for (int i = 0; i < lotto.length; i++) {
//         lotto[i] = (int)(Math.random()*45)+1;
//         int j = 0;
//         while (j < lotto.length) {
//            if(i!=j && lotto[i] == lotto[j]) {
//               lotto[i] = (int)(Math.random()*45)+1;
//               j = 0;
//               System.out.println(j);
//            }
//            j++;
//         }
//      }
//      System.out.println(Arrays.toString(lotto));

	} //

} //
