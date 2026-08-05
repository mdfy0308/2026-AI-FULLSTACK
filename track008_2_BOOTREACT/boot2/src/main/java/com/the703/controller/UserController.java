package com.the703.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dto.LoginRequest;
import com.the703.dto.UserDto.UserRequestDto;
import com.the703.dto.UserDto.UserResponseDto;
import com.the703.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Tag(name = "User Api", description = "사용자 관련 API") // swagger
@RestController // @Controller + @ResponseBody
@RequestMapping("/api/users")
@RequiredArgsConstructor
//@CrossOrigin(origins="*") // 연습용
public class UserController {

	private final UserService userService;

	// 사용자 등록(회원가입)
	// ResponseEntity
	@Operation(summary = "회원가입", description = "새로운 사용자를 등록합니다.")
	@PostMapping(value = "/signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<UserResponseDto> createUser(@ModelAttribute UserRequestDto request,
			@Parameter(description = "프로필 이미지 파일") @RequestPart(name = "ufile", required = false) MultipartFile ufile) {
		UserResponseDto response = userService.createUser(request, ufile);
		return ResponseEntity.ok(userService.createUser(request, ufile));
	}

	// 이메일 중복확인
	@Operation(summary = "이메일 중복 확인", description = "사용중인 이메일인지 확인합니다.")
	@GetMapping("/check-email")
	public ResponseEntity<Boolean> checkEmail(@Parameter(description = "확인할 이메일") @RequestParam("email") String email) {
		return ResponseEntity.ok(userService.existsByEmail(email));
	}

	// 닉네임 중복확인
	@Operation(summary = "닉네임 중복 확인", description = "사용중인 닉네임인지 확인합니다.")
	@GetMapping("/check-nickname")
	public ResponseEntity<Boolean> checkNickname(
			@Parameter(description = "확인할 닉네임") @RequestParam("nickname") String nickname) {
		return ResponseEntity.ok(userService.existsByNickname(nickname));
	}

	// 로그인
	@Operation(summary = "로그인", description = "이메일과 비밀번호로 로그인하여 세션을 생성")
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponseDto> login(@RequestBody LoginRequest request, HttpSession session //
	) {
//		Long userId = (Long)session.getAttribute("LOGIN_USER_ID");
//		if (userId == null) { return ResponseEntity.status(401).build(); } // 권한 없음
//		return ResponseEntity.ok( userService.getUser(userId) );
		UserResponseDto user = userService.login(request);
		session.setAttribute("LOGIN_USER_ID", user.getId()); // 세션 세팅
		return ResponseEntity.ok(user);
	}

	// 로그아웃
	@Operation(summary = "로그아웃", description = "현재 세션을 만료시켜 로그아웃합니다.")
	@PostMapping("/logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.noContent().build();
	}

	// 마이페이지
	@Operation(summary = "현재 로그인한 사용자 정보 조회", description = "세션 기반으로 현재 로그인한 사용자의 정보를 조회합니다")
	@GetMapping("/me")
	public ResponseEntity<UserResponseDto> getUser(HttpSession session) {
		Long userId = (Long) session.getAttribute("LOGIN_USER_ID");
		if (userId == null) {
			return ResponseEntity.status(401).build();
		} // 권한없음.
		return ResponseEntity.ok(userService.getUser(userId));
	}

	// 닉네임 수정
	@Operation(summary = "닉네임 변경", description = "특정 사용자의 닉네임을 변경합니다.")
	@PatchMapping("/{userId}/nickname")
	public ResponseEntity<UserResponseDto> updateNickname(
			@Parameter(description = "사용자 아이디") @PathVariable("userId") Long userId,
			@Parameter(description = "변경할 닉네임") @RequestParam("nickname") String nickname
	){
		return ResponseEntity.ok(	userService.updateNickname(userId, nickname)	);
	}

	// 이미지 프로필 수정
	@Operation(summary = "프로필 이미지 업로드/교체", description = "특정 사용자의 프로필 이미지를 변경합니다.")
	@PatchMapping(value = "/{userId}/profile-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	public ResponseEntity<UserResponseDto> updateProfileImage(
			@Parameter(description = "사용자 아이디") @PathVariable("userId") Long userId,
			@Parameter(description = "변경할 파일") @RequestParam("ufile") MultipartFile ufile
	){
		return ResponseEntity.ok(	userService.updateProfileImage(userId, ufile)	);
	}
	
	
	// 탈퇴
	@Operation(summary = "회원 탈퇴", description = "계정을 삭제하고 세션을 만료시킵니다.")
	@DeleteMapping("/me")
	public ResponseEntity<Void> deleteMe(HttpSession session){
		Long userId = (Long)session.getAttribute("LOGIN_USER_ID");
		if(userId == null) { return ResponseEntity.status(401).build(); } // 권한 없음.
		
		userService.deleteById(userId);
		session.invalidate();
		return ResponseEntity.noContent().build();
	}
	
}


// http://localhost:8080/swagger-ui/index.html
