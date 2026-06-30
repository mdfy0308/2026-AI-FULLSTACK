package com.the703.oauth2;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserNaver implements UserInfoOauth2 {
	
private final Map<String, Object> arrtibutes;
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> getResponse(){
		Object response = arrtibutes.get("response");
		return response instanceof Map? (Map<String, Object>)response : null;
	}
	
	@Override public String getProvider() { return "naver"; }  
	
	@Override public String getProviderId() { 
		Map<String, Object> response = getResponse();
		return response != null ? String.valueOf(response.get("id")) : null;
	}  
	
	@Override public String getEmail() { 
		Map<String, Object> response = getResponse();
		return response != null ? String.valueOf(response.get("email")) : null; 
	}  
	
	@Override public String getNickname() { 
		Map<String, Object> response = getResponse();
		return response != null ? String.valueOf(response.get("name")) : null; 
	}  
	
	@Override public String getImage() { 
		Map<String, Object> response = getResponse();
		return response != null ? String.valueOf(response.get("profile_image")) : "the703.png"; 
	}
}

/***
1. provider   = "local" / "google" , "kakao" , "naver"
2. providerId = google → sub, kakao/facebook   → id, naver  → response

<naver>
    resultcode=00, 
    message=success, 
    response = {
        id=pvdq1FSG3VZlD7Cp3JuWfAFi-3xir6A-WPlP5f8kXIo, 
        email=sally03915@naver.com, 
        name=안효정
    }
*/