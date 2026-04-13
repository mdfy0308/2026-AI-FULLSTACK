package com.the703.basic008_ex;

public class ArrayEx007 {

	public static void main(String[] args) {

		// 대소문자를 서로 바꾸어서 출력하시오.
		
		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		
		for(int i=0;i<ch.length;i++) {
			if(ch[i]>='A' && ch[i]<='Z') {
				System.out.print((char)(ch[i] + 32) + (i<ch.length-1? ", ":""));
			} else if (ch[i]>='a' && ch[i]<='z') { 
				System.out.print((char)(ch[i] - 32) + (i<ch.length-1? ", ":""));
			}
		}

	} //

} //
