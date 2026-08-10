package com.the703.oauth2;

/*
  OAuth2 사용자 정보 인터페이스
*/

public interface UserInfoOAuth2 {
    String getProvider();     // 공급자 이름(google, kakao, naver)
    String getProviderId();   // 고유 사용자 id
    String getEmail();        // 사용자 이메일
    String getNickname();     // 사용자 닉네임
    String getImage();        // 프로필 이미지 url
}
