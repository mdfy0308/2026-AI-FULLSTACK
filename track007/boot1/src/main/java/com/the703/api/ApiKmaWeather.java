package com.the703.api;

import java.net.URI;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service // 비즈니스 로직을 수행하는 서비스 객체임을 알려주는 어노테이션
public class ApiKmaWeather {
	
	@Value("${kma.api}") private String apiKey;
	// 외부 설정파일에서 kma.api라는 값을 가져와 apiKey 변수에 넣음, 하드코딩 X
	
	private final RestClient restClient;
	// 외부의 다른 서버(API)에 HTTP 요청을 보내고 응답을 받아오기 위해 사용하는 동기식(Synchronous) HTTP 클라이언트
	
	public ApiKmaWeather(RestClient.Builder restClientBuilder) {
		// .builder 조립기. restClient 객체를 완성하여 변수에 대입.
		super();
		this.restClient = restClientBuilder.build();
	}
	
	public String getWeatherResponse() {
		String date = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
		URI uri = UriComponentsBuilder // uri를 조립
				.fromUriString("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst") // https 시작하지 않아도 ok / 인코딩 관련 문제 처리
				.queryParam("serviceKey", apiKey) // .queryParam 인터넷 주소 뒤에 붙는 파라미터를 붙여줌
				.queryParam("numOfRows", 10)
				.queryParam("pageNo", 1)
				.queryParam("base_date", date)
				.queryParam("base_time", "0600")
				.queryParam("nx", 55)
				.queryParam("ny", 124)
				.build(true) // 파라미터 조립을 완료하는 명령어, 이미 인코딩된 인증키니까 더 이상 건드리지 말라는 의미
				.toUri(); // 조립된 주소 문자열을 최종적으로 자바의 URI라는 객체 형태로 변환
		try {
			return restClient.get().uri(uri).retrieve().body(String.class);
			// 조립된 uri 주소로 GET요청을 retrieve() 보냄 → 응답 데이터를 String 형태로 받아와서 반환
		} catch (Exception e) {
			throw new RuntimeException("기상청 API 호출 중 오류 발생 ", e);
		}
	}
}


/*

http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst
?serviceKey=인증키&numOfRows=10&pageNo=1
&base_date=20210628&base_time=0600&nx=55&ny=127

*/