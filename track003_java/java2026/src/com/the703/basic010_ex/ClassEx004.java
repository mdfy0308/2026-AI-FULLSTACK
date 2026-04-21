package com.the703.basic010_ex;

import java.util.Scanner;

class TV {
	String channel;
	int volume;

	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("채널 입력 > ");
		channel = sc.next();
		System.out.print("볼륨 입력 > ");
		volume = sc.nextInt();
	}

	public TV() {
	}

	public TV(String channel, int volume) {
		super();
		this.channel = channel;
		this.volume = volume;
	}

	void show() {
		System.out.println("Channel : " + channel);
		System.out.println("Volume : " + volume);
	}
}

public class ClassEx004 {
	public static void main(String[] args) {

		TV t1 = new TV("JTBC", 8);
		t1.show();
		TV t2 = new TV();
		t2.input();
		t2.show();
	}
}

/*
 * 출력내용 : JDBC 8
 * 
 * channel입력>youtube volume 입력>10 youtube 10
 * 
 */