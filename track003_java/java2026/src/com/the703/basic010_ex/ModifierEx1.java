package com.the703.basic010_ex;

import com.the703.basic010.Milk;

public class ModifierEx1 {
	public static void main(String[] args) {
		
		Milk m1 = new Milk();
		Milk m2 = new Milk(2, "매일", 3990);
		
		m1.setMprice(2000);
		m1.setMname("서울");
		System.out.println(m1);
		System.out.println(m2);

	} // end main
} // end class
