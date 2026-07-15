package com.the703.llmrag;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;


// 전용 record 클래스를 만들어서 사용


@Service // @Autowire를 사용할 수 있게.
@RequiredArgsConstructor // Lombok. final 필드만 골라서 생성자를 자동 생성해줌.
public class AiService {

	private final RestClient openAiRestClient;
	// 이 RestClient는 다른 설정 클래스(RestClientConfig)에서 완성된 상태로 주입.
	

	/* 1. 업로드된 pdf파일에서 원문텍스트 추출 - retrieval 역할수행 / 컨텍스트 증강 */
	public String extractTextFromPdf(MultipartFile file) throws IOException {
		try (PDDocument document = Loader.loadPDF(file.getBytes())) {
			PDFTextStripper stripper = new PDFTextStripper();
			return stripper.getText(document); // pdf전체 텍스트추출
		}
	}
	/* RAG(Retrieval-Augmented Generation) 
	관련 문서를 먼저 읽어서 AI에게 "이거 참고해서 답해줘"라고 같이 넣어주는 방식.
	이 메서드는 그중 "문서를 텍스트로 추출"하는 부분. PDF 파일을 받아서 안의 글자만 뽑아낸다.
	PDFBox 라이브러리 사용.
	*/
	

	/* 2. 연동후 결과 도출 */
	public String askToGptWithContext(String context, String question) {
		
		String systemInstruction = "당신은 업로드된 문서내용을 기반으로 답변하는 전문 비서입니다."; // ##
		String userPrompt = "--- [문서 내용] ---\n%s\n --- [질문] ---\n%s".formatted(context, question); 
		// %s...formatted(...) — 자바의 문자열 템플릿. C의 printf처럼 %s 자리에 값이 들어간다. 
		
		// 메시지 리스트 빌드
		List<Message> messages = List.of(
				new Message("system", systemInstruction), //AI의 역할 세팅
				new Message("user", userPrompt) // 프롬프트
		);
		/*
			Map 방식				|		record 방식
		키 이름 오타 나도 컴파일 통과	|	컴파일러가 필드명 검증
		값 타입 자유로움 (Object)	|	타입 명확 (String)
		빠르게 프로토타이핑			| 	유지보수/협업에 강함
		*/
		
		///////////////////////////////////////////////////////////////
		// 요청 조립 및 전송
		LlmRagRequest requestBody = new LlmRagRequest("gpt-4o-mini", messages); 
		// # record로 요청 body 만들기.

		LlmRagResponse response = openAiRestClient
				.post().uri("/chat/completions") 
				// RestClienConfig가 이미 baseUrl(https://api.openai.com/v1)을 세팅해두었기 때문에
				.body(requestBody) 
				.retrieve() // 요청
				.body(LlmRagResponse.class); 
				// ##응답을 String이 아니라 record 타입으로 바로 받음. 자동 파싱

		// 응답 테스트 가공하기
		if (response != null && !response.choices().isEmpty()) {
			return response.choices().get(0).message().getContent();
		} 
		/*
		choices()와 getContent()의 차이
		- choices(), message()는 record의 접근자. record는 필드마다 자동으로 이런 메서드를 만든다.
		- getContent() 일반 자바 빈 스타일 getter.
		Message가 record가 아니라 일반 클래스(LOMBOK @Data라서.)
		*/
		
		return "AI 응답을 생성하지 못했습니다.";
	}

	/* 로컬고정용파일용 */
	public String extractTextFromPdf(InputStream inputStream) throws IOException {
		try (PDDocument document = Loader.loadPDF(inputStream.readAllBytes())) {
			PDFTextStripper stripper = new PDFTextStripper();
			return stripper.getText(document);
		}
	}
}