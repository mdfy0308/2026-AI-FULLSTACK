package com.the703.basic018_ex;

class Candy {
	String name;
	public void sell() {
		System.out.println(name + "가 1개 팔렸습니다.");
	}
}

class MentolSeller extends Candy implements Runnable {
	
	@Override
	public void run() {
		try { Thread.sleep(10); } 
		catch (InterruptedException e) {  e.printStackTrace(); }
		
		for(int i=0; i<5; i++) {
			sell();
			try { Thread.sleep(1000); }
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}

public class ThreadEx002 {
	public static void main(String[] args) {
		System.out.println(".............. main start");
		MentolSeller seller = new MentolSeller();
		seller.name = "멘톨 캔디";
		Thread t = new Thread(seller);
		t.start();

		for (int i = 0; i < 1; i++) {
			System.out.println("  손님 기다리는 중.....");
			try { Thread.sleep(1000); } 
			catch (InterruptedException e) { e.printStackTrace(); }
		}
		System.out.println(".............. main end");
		
	}//
}//