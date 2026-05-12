package com.the703.basic018;

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
		
		// ### 스레드 중단요청 2)
		for(int i=0; i<5; i++) {
			sell();
			try { Thread.sleep(1000); }
			catch (InterruptedException e) { 
				 System.out.println("판매 중 인터럽트(방해) 발생");
				 break;
			}
		}
	}
}

public class Thread004 {
	public static void main(String[] args) {
		
		MentolSeller seller = new MentolSeller();
		seller.name = "멘톨 캔디";
		Thread t = new Thread(seller);
		t.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("  손님 기다리는 중.....");
			try { Thread.sleep(1000); }
			catch (InterruptedException e) { e.printStackTrace(); }
		}
		
		System.out.println(".............. 손님이 없어서 판매를 중단합니다.");
		t.interrupt(); // ### 스레드 중단 요청 1)
		// interrupt를 사용하려면 무조건 sleep을 사용해야함
		
	}//
}//
