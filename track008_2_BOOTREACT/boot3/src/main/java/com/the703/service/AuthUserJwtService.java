package com.the703.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.the703.oauth2.CustomOAuth2User;


/* jwt 인증 사용자 정보 서비스
- Authentication에서 CustomOAuth2User로 꺼내온 유저 정보 사용

*/
@Component
public class AuthUserJwtService {
	
	// 현재 로그인한 사용자 ID 반환
	public Long getCurrentUserId(Authentication authentication) {
		CustomOAuth2User userPrincipal = (CustomOAuth2User) authentication.getPrincipal();
		return userPrincipal.getId();
	}
	// 현재 로그인한 사용자 EMAIL 반환
	public String getCurrentUserEmail(Authentication authentication) {
		CustomOAuth2User userPrincipal = (CustomOAuth2User) authentication.getPrincipal();
		return userPrincipal.getEmail();
	}
	// 현재 로그인한 사용자 닉네임 반환
	public String getCurrentUserNickname(Authentication authentication) {
		CustomOAuth2User userPrincipal = (CustomOAuth2User) authentication.getPrincipal();
		return userPrincipal.getNickname();
	}
}
