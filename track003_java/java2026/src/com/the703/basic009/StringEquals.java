package com.the703.basic009;

public class StringEquals {

	public static void main(String[] args) {

		String id = "abc", id2 = "abc";
		String id3 = new String("abc");
		
		System.out.println( System.identityHashCode(id) );
		System.out.println( System.identityHashCode(id2) );
		System.out.println( System.identityHashCode(id3) );
		
		//문자열 비교시 equals를 이용
		System.out.println(id.equals(id3)); // true

	} //

} //
