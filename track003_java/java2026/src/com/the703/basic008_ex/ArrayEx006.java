package com.the703.basic008_ex;

public class ArrayEx006 {

	public static void main(String[] args) {
		//new를 이용하여 문자열 배열 ch 52개 만들기
		//new는 객체를 만드는 키워드
		
		//대문자 A~Z, a~z까지 52개의 데이터를 for를 이용하여 ch배열에 데이터를 대입
		
		// for문을 이용하여 모음의 갯수 구하기 A, E, I, O, U, a, e, i , o, u
		
		char[] ch = new char[52];
		char[] ch2 = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
		int cnt = 0;
		
		for(int i=0;i<26;i++) { ch[i] = (char)('A' + i); ch[i+26] = (char)('a' + i); }
		
		for(int i=0;i<ch.length;i++) { 
			for(int j=0;j<ch2.length;j++) { if(ch[i] == ch2[j]) { cnt++; }
			}
		} System.out.println("모음의 갯수 : " + cnt);
		
	} //

} //
