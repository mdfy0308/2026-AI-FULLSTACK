package com.the703.service;

import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

public interface UserService {
	
	public int insert(UserDto dto);
	public String findByEmail(String email);
	public String findByNickname(String nickname);

	public  AuthUserDto readAuth( String email );
	public	UserDto findByEmailUserInfo(String email);
	
}
