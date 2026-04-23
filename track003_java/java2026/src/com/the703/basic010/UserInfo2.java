package com.the703.basic010;


/* */

public class UserInfo2 {

	public String name; // 아무데서나 접근 가능
	protected String safeCode; // extends시 자식에서 사용 가능
			  String house; // 아무것도 없으면 default, 패키지(폴더)
	private int iQ; // 클래스 내부 The value of the field UserInfo.iQ is not used

	public int getiQ() { return iQ; }

	public void setiQ(int iQ) { this.iQ = iQ; }
}
