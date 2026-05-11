package com.the703.basic017;

public class StringStringBuffer {
	public static void main(String[] args) {
		
		
		// #1. String
		String str = "ABC"; // 925858445
		System.out.println("1. str 주소 >" + str + " " + System.identityHashCode(str));
		
		str += "D"; // 471910020
		System.out.println("2. str 주소 >" + str + " " + System.identityHashCode(str));
		
		// #2. StringBuffer
		StringBuffer sb = new StringBuffer();
		sb.append("ABC"); // 531885035
		System.out.println("3. sb 주소 >" + sb + " " + System.identityHashCode(sb));
		
		sb.append("D"); // 531885035 → 동일한 주소
		System.out.println("4. sb 주소 >" + sb + " " + System.identityHashCode(sb));
				
		
	}//
}//
