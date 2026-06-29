package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.the703.service.AppUserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired AppUserService service;
	
	@GetMapping("/join") 	public String joinForm() 	{ return "users/join";	 }
	@GetMapping("/login") 	public String loginForm() 	{ return "users/login";	 }
	@GetMapping("/mypage") 	public String mypage()		{ return "users/mypage"; }
	@GetMapping("/update") 	public String updateForm() 	{ return "users/update"; }
	@GetMapping("/delete") 	public String deleteForm() 	{ return "users/delete"; }
	
	@GetMapping("/fail") public String fail(Model model){ 
		model.addAttribute("errorMessage", "로그인 실패: 아이디 또는 비밀번호를 확인해주세요.");
		return "users/login"; 
	}
	
		
}
