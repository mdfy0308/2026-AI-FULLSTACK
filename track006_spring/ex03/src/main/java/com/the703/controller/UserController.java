package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.the703.service.UserService;

@Controller
public class UserController {

	@Autowired UserService service;
	
	// 회원가입
	@RequestMapping(value="/users/join.do")
	public String join() { return null; }
	
	// 로그인
	
	// 마이페이지
	
		
}
