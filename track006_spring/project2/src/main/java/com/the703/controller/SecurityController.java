package com.the703.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.UserDto;
import com.the703.service.UserService;

@Controller
@RequestMapping("/security/*")
public class SecurityController {

	@Autowired
	UserService service;

	@RequestMapping("/all")
	public String all() {
		return "security/all";
	}

	@RequestMapping("/member")
	public String member() {
		return "security/member";
	}

	@RequestMapping("/join")
	public String join() {
		return "users/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join_post(UserDto dto, RedirectAttributes rttr) {
		String result = "회원가입 실패";
		if(service.insert(dto) > 0) { result="회원가입 성공"; }
		rttr.addFlashAttribute("result", result);
		return "redirect:/security/login";
	}

	@RequestMapping("/login")
	public String login() {
		return "users/login";
	}

	@RequestMapping("/fail")
	public String fail() {
		return "users/fail";
	}

	// Authentication - Principal( 현재 로그인 한 사용자 정보 )
	@RequestMapping("/mypage")
	public String mypage(Principal principal, Model model) {
		System.out.println("...................." + principal);
		System.out.println("...................." + principal.getName()); // username - email;
		
		model.addAttribute("dto", service.findByEmailUserInfo( principal.getName() ));
		// mapper-email 검색시 해당유저 정보 가져오기

		return "users/mypage";
	}

}
