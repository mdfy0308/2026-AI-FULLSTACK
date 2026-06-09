package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the703.dao.UserMapper;
import com.the703.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired UserMapper dao;

	@Override
	public int join(UserDto dto) {
	
		// 회원 가입할때 아이디 중복 검사도 같이 해야하는데....
//		String result = "";
//		String email = dto.getEmail();
//		findByEmail(email);

		// 들어온 정보(dto)에 bip값 세팅해서 → dao.join(dto)로 돌려줌
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		return dao.join(dto);

	}

	@Override
	public int findLogin(UserDto dto) {
		return dao.findLogin(dto);
	}

	@Override
	public UserDto findByUno(int uno) {
		return dao.findByUno(uno);
	}

	@Override
	public String findByEmail(String email) {
		return dao.findByEmail(email);
	}
}
