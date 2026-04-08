package com.the703.basic006_ex;

public class RepeatEx004 {

	public static void main(String[] args) {
		//A~Z까지 출력하고 5번째마다 줄바꿈하시오
		// System.out.println('A'); // 1
		char a = 'A';
		int cnt = 1;
		
		for(a = 'A'; a <='Z'; a++) {
			switch(cnt%5) {
			case 0: System.out.println(a); break;
			default: System.out.print(a); break;
			} cnt++;
		}
		
		System.out.println();
		a = 'A';
		cnt = 1;
		
		while (a<='Z') {
			if(cnt%5==0) { System.out.println(a); } 
			else { System.out.print(a); }
			cnt++; a++;
		}
		
		System.out.println();
		a = 'A';
		cnt = 1;
		
		do { if(cnt%5==0) { System.out.println(a); } 
			else { System.out.print(a); }
			cnt++; a++; } while (a <='Z');
		
		
	} //

} //
