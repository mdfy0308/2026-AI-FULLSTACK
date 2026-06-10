package com.the703.service;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

public interface UserService {
	
	//1. 회원가입 - 아이디 중복 검사를 함께 + 권한 추가
	public int		join(UserDto dto);
		
	//2. 로그인 - 아이디/비밀번호가 일치하면 로그인
	public int		findLogin(UserDto dto);
	
	//3. 마이페이지 - 유저 정보 상세 보기
	public UserDto	findByUno(int uno);
	
	//4. 아이디 중복 검사
	public String	findByEmail(String email);
	
	/* security login */
	public AuthListDto readAuth(AuthDto dto);
	public UserDto findByEmailUserInfo(String email);
	
}
