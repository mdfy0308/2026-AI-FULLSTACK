package com.the703.basic018_ex;

import javax.swing.JOptionPane;


/*** ver -1
class Count extends Thread {

	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try { Thread.sleep(1000); }
			catch (InterruptedException e) { break; }
		}
	}
}
*/

// ver-2
class Count extends Thread {

	@Override
	public void run() {	
		for (int i = 10; i > 0; i--) {
			//중단 요청 확인
			if( Thread.currentThread().isInterrupted() ) { break; }
			
			System.out.println(i);
			try { Thread.sleep(1000); } 
			catch (InterruptedException e) { break; }
		}
	}
}

public class ThreadEx003 {
	public static void main(String[] args) {

		Thread count = new Count();
		count.start();
		String info = "계속 카운트 합니다.";

		// ##### 3. 입력받기
		String answer = JOptionPane.showInputDialog("count stop?  y/n");

		if (answer.toLowerCase().equals("y")) { count.interrupt(); info = "Count를 멈춥니다."; }
		
		System.out.println(info);

	} //
} //

/*
 */