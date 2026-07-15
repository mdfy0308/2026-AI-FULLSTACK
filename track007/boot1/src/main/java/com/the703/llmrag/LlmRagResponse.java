package com.the703.llmrag;

import java.util.List;

public record LlmRagResponse(List<Choice> choices) {
	
	// record는 자바14+에서 나온 문법으로, 필드만 가지는 간단한 데이터 클래스를 한 줄로 만들어준다.
	// LOMBOK의 @Data 같은 것을 자바가 내장한 셈.
	
}