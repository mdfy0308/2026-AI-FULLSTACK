package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired UserMapper dao;
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	
	@Override
	public int join(UserDto dto) {
		
		//권한 추가. 들어온 정보(dto)의 이메일 값과 권한을 adto에 추가
		AuthDto adto = new AuthDto();
		adto.setEmail(dto.getEmail()); adto.setAuth("ROLE_MEMBER");
		dao.insertAuth(adto);
		dto.setBpass( pwencoder.encode(dto.getBpass()) );
		
		// 이메일 중복검사도 여기서 처리해야하지??
		
		
		// 들어온 정보(dto)에 bip값 세팅해서 → dao.join(dto)로 돌려줌
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		
		return dao.join(dto);
	}

	@Override
	public int findLogin(UserDto dto) { return dao.findLogin(dto); }  
	
	@Override
	public UserDto findByUno(int uno) { return dao.findByUno(uno); }  
	
	@Override
	public String findByEmail(String email) { return dao.findByEmail(email); }  
	
	@Override
	public AuthListDto readAuth(AuthDto dto) {  return dao.readAuth(dto); }

	@Override
	public UserDto findByEmailUserInfo(String email) { return dao.findByEmailUserInfo(email); }
	
	
}
