package com.the703.basic017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Network001 {
	public static void main(String[] args) {
		
		try { 
			//1. Url
			URL url = new URL("https://www.google.com/"); 
			
			//2. 연결객체 (HttpUrlConnection)
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			//3. 요청설정 (Request)
			conn.setRequestMethod("GET"); // 주소 표시창줄에 자원요청 - get(노출O) post(노출X) patch 
			
			//4. 응답코드 (Response)
			int code = conn.getResponseCode();
			System.out.println(code); // 200 응답 성공 / 404 페이지 없음 / 500 오류
			
			//5. 응답데이터
			BufferedReader br;
				
			if(code==200) {
				//	  한줄씩 속도 향상 - 바이트 스트림을 문자 스트림 - 응답 데이터 스트림
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {	
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			String line = ""; StringBuffer sb = new StringBuffer();
			while( ( line = br.readLine() ) != null) { sb.append(line+"\n"); }
			System.out.println(sb.toString());
			br.close(); conn.disconnect();
			
		} catch (MalformedURLException e) { e.printStackTrace(); 
		} catch (IOException e) {  e.printStackTrace(); }
		
		
		
		// # BufferdReader > [프로그램 : Network001/java] > BufferdWriter
		

		
	}//
}//

/*

Network

1) web (http 통신) → Jsp (java + html) → Spring
2) socket 




*/