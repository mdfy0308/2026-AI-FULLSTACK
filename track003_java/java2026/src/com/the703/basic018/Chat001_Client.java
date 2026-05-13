package com.the703.basic018;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Chat001_Client {
	public static void main(String[] args) {
		
		// 2) 클라이언트 연결 요청, 수락
		Socket user = null;
		
		try {
			user = new Socket("127.0.0.1", 703); // ip, port
			System.out.println("[Client] 3. A/S센터에 고객 문의");
			
			Thread sender 	= new Sender(user); 	sender.start();
			Thread receiver = new Receiver(user); receiver.start();
			
		} catch (UnknownHostException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); } 
		

	}//
}//

/*

1. Http 	통신 - 단방향 (Client 요청이 있을 때, server 응답하고 연결 종료)
2. Socket 	통신 - 양방향 (특정 포트를 통해 실시간으로 정보를 주고 받음 - tcp/udp)
3. 소켓 통신 흐름
	1) 서버 소켓 (as 센터), 포트 바인딩(문 열기)
	2) 클라이언트 연결 요청, 수락
	3) 클라이언트 소켓(socket)가 말하기 (프로그램 > OutputStream)  
	↔ 상담사(socket)가 읽어들이기 (InputStream > 프로그램)

*/