package com.the703.basic008_ex;

public class ArrayEx005 {

	public static void main(String[] args) {

//		1. 배열명 : ch
//	    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
//	    3. ch 배열에서 대문자의 갯수카운트, 소문자의 갯수 카운트
		
		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		int cnt1 = 0, cnt2 = 0;
		
		for(int i=0;i<ch.length;i++) {
			if(ch[i]>='A' && ch[i]<='Z') { cnt1 += 1; }
			else if(ch[i]>='a' && ch[i]<='z') { cnt2 += 1; }
		} System.out.printf("대문자의 갯수: %d\n소문자의 갯수: %d", cnt1, cnt2);

	}

}
