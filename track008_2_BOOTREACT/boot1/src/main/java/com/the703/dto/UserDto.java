package com.the703.dto;

import com.the703.entity.AppUser;

import lombok.Getter;
import lombok.Setter;

public class UserDto {
	
	// 회원가입 요청 Dto
	@Setter @Getter
	public static class UserRequestDto{
		private String email;
		private String password;
		private String nickname;
		private String mobile;
		private Integer mbtitype;
	}
	
	// 회원 정보 응답 Dto
	@Getter
	public static class UserResponseDto{
		private Long id;
		private String email;
		private String password;
		private String nickname;
		private String mobile;
		private Integer mbtitype;
		private String role;
		
		public UserResponseDto(AppUser user) { // insert, update
			super();
			this.id = user.getId();
			this.email = user.getEmail();
			this.password = user.getPassword();
			this.nickname = user.getNickname();
			this.mobile = user.getMobile();
			this.mbtitype = user.getMbtitype();
			this.role = user.getRole();
		}
	}
	
}
