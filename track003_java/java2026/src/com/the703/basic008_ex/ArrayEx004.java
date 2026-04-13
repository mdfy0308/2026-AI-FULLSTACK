package com.the703.basic008_ex;

public class ArrayEx004 {

	public static void main(String[] args) {
		
//		1. 배열명 : ch
//	    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
//	    3. ch 배열에서 a의 갯수 세기
//	    4. 출력된화면 : a의 갯수 3    

		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		int cnt = 0;
		
		for(int i=0;i<ch.length;i++) { 
			if(ch[i]=='a') { cnt += 1; } 
		} System.out.printf("a의 갯수 : %d", cnt);

	}

}
