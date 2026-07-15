package com.the703.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service // 다른 곳에서 @Autowired로 가져다 쓸 수 있게
public class ApiOpenAi {
	
	@Value("${openai.api.key}") private String apiKey;
	// application.properties에 있는 openai.api.key값을 apiKey 필드에 넣어줌.
	// 보안 문제로 하드 코딩을 하면 안 되니까 properties에 따로 지정
	
	private static final String API_URL="https://api.openai.com/v1/chat/completions"; 
	// #1. 주소 고정. 주소는 절대 바뀌지 않으므로 상수(final)로, 인스턴스마다 다를 필요가 없으니 static도.
	// private static final은 "확정된 상수"라는 표현
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	// ObjectMapper는 잭슨(Jackson) 라이브러리의 도구로 JSON 문자열을 자바 객체로 바꾸거나 그 반대의 일을 실행한다.
	// AI의 응답이 JSON 문자열로 오는데 그 안에서 응답 텍스트(choices[0].message.content)만 꺼내야하는 경우
	
	private final RestClient restClient;
	// HTTP 요청을 보내는 도구
	
	public ApiOpenAi(RestClient.Builder restClientBuilder) {
		this.restClient = restClientBuilder.baseUrl(API_URL).build();
	} 
	// "RestClient"를 만드는 도구를 파라미터로 받음.
	// .baseUrl(API_URL).build(); Builder에 "이 기본 주소로 세팅해줘"라고 요청. 
	// → 이 결과가 RestClient 객체.
	
	// 왜 baseUrl을 미리 설정하나? 
	// → 나중에 요청 보낼 때 매번 전체 URL을 안 써도 되게 하려고. 
	// 지금은 baseUrl이 이미 /chat/completions까지 다 포함하고 있어서 이후엔 URL 지정도 안 함.
	
	
	public String getAIResponse(String userMessage) {
		// 1. 요청하는 body 만들기
		Map<String, Object> body = Map.of(
				"model", "gpt-4.1",
				"messages", List.of( 
						Map.of( "role", "user", "content", userMessage + " 내용을 이모티콘으로 요약해줘." ) 
				)
		);
		/* 자바로 JSON 객체를 표현한 것
		 * 		JSON			|			자바
		 { "key": "value" }		|	Map.of("key", "value")
		 [ 1, 2, 3 ]			|	List.of(1, 2, 3)
		 중첩						|	Map 안에 List 안에 Map
		 */
		
		// 2. 실제 요청 전송
		try {
			//RestClient 스타일 세팅 값 받아오기
			String responseBody = restClient.post() // POST 메서드
					.contentType(MediaType.APPLICATION_JSON) // -H "Content-Type: application/json"
					.header("Authorization", "Bearer " + apiKey) // -H "Authorization: Bearer $KEY"
					.body(body) // -d '{...}'
					.retrieve() // 실제 요청 실행. (트리거)
					.body(String.class); // 응답을 받으면 스트링으로. 문자열 안에 JSON이 통째로 들어있는 셈.
			// ※.body는 같지만 의미는 완전히 다름
			// 앞의 .body(body) : 내가 보낼 데이터를 세팅
			// 뒤의 .body(String.class) : 응답을 어떤 타입으로 받을지를 지정
			
			//3. 응답이 오면 json 파싱(원하는 부분 추출)
			/* 현재 responseBody : {"id":"...","choices":[{"message":{"content":"실제 답변"}}], ...}
			 여기서 content 값만 꺼내야하지만, 문자열 상태에선 못 꺼냄.
			 → JSON 구조체로 파싱해야 접근할 수 있다. 때문에 objectMapper로 문자열을 JsonNode(트리 구조)로 변환 */
			JsonNode root = objectMapper.readTree(responseBody);
						
			return root.path("choices").get(0).path("message").path("content").asText();
			/*
			root (전체)
 				└── path("choices")    → choices 배열. 키 이름으로 찾기(JSON 객체 안)
      				└── get(0)         → 첫 번째 원소 (Map). 배열 인덱스로 찾기(JSON 배열 안)
           				└── path("message")  → message 객체
                			└── path("content") → 내용 값
                     			└── asText()   	→ 최종 값을 자바 String으로 변환하여 리턴.	
			*/
		} catch (Exception e) { throw new RuntimeException( "openai 호출응답 파싱오류", e); }
	}
	
	/* 전체 흐름 요약
	1. 필드 준비  → API 키, 주소, RestClient, ObjectMapper 세팅
	2. 생성자    → RestClient 완성 (baseUrl 지정)
	3. Map/List로 요청 바디 조립 → JSON 형태
	4. RestClient로 POST 요청 실행 → 응답을 String으로 받음
	5. ObjectMapper로 JSON 파싱 → 원하는 필드만 꺼내서 리턴
	*/
}


/*******

1. 터미널에서 직접 OpenAI에 HTTP요청을 보내는 명령. 자바 코드가 이 커맨드를 만들어준다.
2. HTTP 메서드
curl https://api.openai.com/v1/chat/completions \ 
# "어디로 보낼 건가"(URL)
-H "Content-Type: application/json" \ 
# body 데이터가 JSON 형식이라고 알려준다
-H "Authorization: Bearer $OPENAI_API_KEY" \ 
# 가지고 있는 API키 확인. 신분증 같은 것. 없으면 OpenAI가 401 Unauthorized로 거절
-d '{ 
	# -d가 있으면 자동으로 POST. 왜 POST인가? 데이터를 담아 보내야 하니까.(질문 내용) 검색처럼 URL만 조회하는 것이 아님.
	# 그리고 이하가 body 내용(JSON)
  "model": "VAR_chat_model_id", # 사용하는 AI 모델
  "messages": [
    {
      "role": "developer", # AI의 역할/성격을 지정
      "content": "You are a helpful assistant."
    },
    {
      "role": "user", # 사용자
      "content": "Hello!" # 실제 사용자의 질문
    }
  ]
}'

//////////////////////////////////////////////////////

2. openAI의 응답 구조
{
  "id": "chatcmpl-B9MBs8CjcvOU2jLn4n570S5qMJKcT",
  "object": "chat.completion",
  "created": 1741569952,
  "model": "gpt-5.4",
  "choices": [
    {
      "index": 0,
      "message": { # choices[0].message.content가 AI의 실제 답변 텍스트
        "role": "assistant",
        "content": "Hello! How can I assist you today?",
        "refusal": null,
        "annotations": []
      },
      "logprobs": null,
      "finish_reason": "stop"
    }
  ],
  "usage": {
    "prompt_tokens": 19,
    "completion_tokens": 10,
    "total_tokens": 29,
    "prompt_tokens_details": {
      "cached_tokens": 0,
      "audio_tokens": 0
    },


*/