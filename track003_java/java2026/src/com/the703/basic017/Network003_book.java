package com.the703.basic017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/*
1. 네이버 개발자 - 로그인
2. 애플리케이션 - 사용할 api 설정
Client ID : j2WNQQkbAHKmKFKRouQT
Client Secret : jdCtaF98Wx
> URL
https://openapi.naver.com/v1/search/book.xml
https://openapi.naver.com/v1/search/book.json

> 옵션
	프로토콜		: HTTPS
	HTTP 메서드	: GET
	파라미터 		: query			String
	
https://openapi.naver.com/v1/search/book.xml	XML		<>
https://openapi.naver.com/v1/search/book.json	JSON	{}

> GET /v1/search/book.xml?query=%EC%A3%BC%EC%8B%9D&display=10&start=1 HTTP/1.1
> Host: openapi.naver.com
> User-Agent: curl/7.49.1
> Accept: -
> X-Naver-Client-Id: j2WNQQkbAHKmKFKRouQT
> X-Naver-Client-Secret: jdCtaF98Wx
>
3. Http 통신 이용해서 데이터 가져오기
*/


public class Network003_book {

	public static void main(String[] args) {


		try {
			//1. URL	주소확인
			String apiUrl = "https://openapi.naver.com/v1/search/book.json?query=" 
						     + URLEncoder.encode("스프링부트", "UTF-8"); //## 검색어
			URL url = new URL(apiUrl);
			
			//2. HttpURLConnection	연결객체
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			//3. 요청설정	GET
			// > X-Naver-Client-Id: j2WNQQkbAHKmKFKRouQT
			// > X-Naver-Client-Secret: jdCtaF98Wx
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id"    , "j2WNQQkbAHKmKFKRouQT");
			conn.setRequestProperty("X-Naver-Client-Secret", "jdCtaF98Wx");
			
			//4. 응답확인
			int code = conn.getResponseCode();		
			
			//5. 응답데이터
			BufferedReader br;
			if( code==200 ) { 
				br = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			String line = ""; StringBuffer sb = new StringBuffer();
			while( (line = br.readLine()) != null ) { sb.append(line + "\n"); }
			
			System.out.println(sb.toString());
			br.close();
			conn.disconnect();
			
		} catch(Exception e) { e.printStackTrace(); }

	}//
} //
