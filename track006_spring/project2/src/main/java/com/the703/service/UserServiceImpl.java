package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

@Service
public class UserServiceImpl  implements UserService{
 
	@Autowired  UserMapper dao;
	@Autowired  @Qualifier("passwordEncoder") PasswordEncoder  pwencoder;
	//import org.springframework.security.crypto.password.PasswordEncoder;
	@Override
	public int insert(UserDto dto) {
		
		//권한 추가. 들어온 정보(dto)의 이메일 값과 권한을 adto에 추가
		AuthDto adto = new AuthDto();
		adto.setEmail(dto.getEmail()); adto.setAuth("ROLE_MEMBER");
		dao.insertAuth(adto);
		dto.setBpass( pwencoder.encode(dto.getBpass()) );
		
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		
		return dao.insert(dto);
	}

	@Override
	public String findByEmail(String email) { return dao.findByEmail(email); }  
	
	@Override
	public AuthUserDto readAuth(String email) {  return dao.readAuth(email); }

	@Override
	public UserDto findByEmailUserInfo(String email) { return dao.findByEmailUserInfo(email); }

	@Override
	public String findByNickname(String nickname) {  return dao.findByNickname(nickname); }


}
