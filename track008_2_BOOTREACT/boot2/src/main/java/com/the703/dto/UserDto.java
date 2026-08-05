package com.the703.dto;

import java.time.LocalDateTime;

import com.the703.entity.AppUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class UserDto {
	
	// 회원가입 요청 Dto
	@AllArgsConstructor
	@NoArgsConstructor
	@Setter @Getter
	public static class UserRequestDto{
		
		@Email
		@NotBlank
		private String email;
		
		@NotBlank
		private String password;
		
		@NotBlank
		private String nickname;
		
		// private String mobile;
		// private Integer mbtitype;
		private String provider;
	}
	
	// 회원 정보 응답 Dto
	@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
	public static class UserResponseDto{
		private Long id;
		private String email;
		private String password;
		private String nickname;
		private String mobile;
		private String provider;
		private Integer mbtitype;
		private String role;
		private String ufile;
		private LocalDateTime createdAt;
		
		public static UserResponseDto fromEntity(AppUser user) { // repository 처리해준 값
			return UserResponseDto.builder()
					.id(user.getId())
					.email(user.getEmail())
					.nickname(user.getNickname())
					.provider(user.getProvider())
					.role(user.getRole())
					.createdAt(user.getCreatedAt())
					.ufile(user.getUfile())
					.build();
		}
		
		public AppUser toEntity() {
            AppUser user = new AppUser();
            user.setId(this.id);
            user.setEmail(this.email);
            user.setNickname(this.nickname);
            user.setProvider(this.provider != null ? this.provider : "local");
            user.setRole(this.role != null ? this.role : "ROLE_USER");
            user.setUfile(this.ufile);
            return user;
        }
		
		public UserResponseDto(com.the703.entity.AppUser user) { // insert, update
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

/*
UserRequestDto < email, password, nickname, ☆image(다음번에) / provider, mobile, mbtitype>
UserResponseDto <  email, perm, nickname, image />

LoginRequest < email, password >
 */
