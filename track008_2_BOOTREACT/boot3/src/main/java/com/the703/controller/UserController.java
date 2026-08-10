package com.the703.controller;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
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
import com.the703.security.JwtProperties;
import com.the703.security.JwtProvider;
import com.the703.security.TokenStore;
import com.the703.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Tag(name = "User Api", description = "사용자 관련 API") // swagger
@RestController // @Controller + @ResponseBody
@RequestMapping("/auth") // /api/users
@RequiredArgsConstructor
//@CrossOrigin(origins="*") // 연습용
public class UserController {

	private final JwtProperties props; 		// 1. JWT 출입증(설정값)
	private final JwtProvider jwtProvider;	// 2. JWT 토큰 생성, 검증(accessToken/refreshToken)
	private final TokenStore tokenStore;	// 3. JWT 저장소
	private final UserService userService;	// @Autowired

	// 사용자 등록(회원가입)
	// ResponseEntity
	@Operation(summary = "회원가입", description = "새로운 사용자를 등록합니다.")
	@PostMapping(value = "/signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<UserResponseDto> createUser(@ModelAttribute UserRequestDto request,
			@Parameter(description = "프로필 이미지 파일") // swagger
			@RequestPart(name = "ufile", required = false) MultipartFile ufile) {
		UserResponseDto response = userService.createUser(request, ufile);
		return ResponseEntity.ok(response);
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
//	@Operation(summary = "로그인", description = "이메일과 비밀번호로 로그인하여 세션을 생성")
//	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<UserResponseDto> login(@RequestBody LoginRequest request, HttpSession session //
//	) {
////		Long userId = (Long)session.getAttribute("LOGIN_USER_ID");
////		if (userId == null) { return ResponseEntity.status(401).build(); } // 권한 없음
////		return ResponseEntity.ok( userService.getUser(userId) );
//		UserResponseDto user = userService.login(request);
//		session.setAttribute("LOGIN_USER_ID", user.getId()); // 세션 세팅
//		return ResponseEntity.ok(user);
//	}
	
    @Operation(summary = "로그인 (Access Token + Refresh Token 발급)")
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> login(
            @RequestBody LoginRequest request,
            HttpServletResponse response   
    ) { 
    	// 1. 사용자 인증 처리
        UserResponseDto user = userService.login(request);
        // 2-1. Access Token 생성(사용자 id + 역할)
        String accessToken = jwtProvider.createAccessToken(
                user.getId().toString(),
                Map.of("role", user.getRole())
        );
        // 2-2. Refresh Token - room 아예 빼기(checkout)
        String refreshToken = jwtProvider.createRefreshToken(user.getId().toString());
        // 2-3. redis에 저장
        tokenStore.saveRefreshToken(
                user.getId().toString(),
                refreshToken,
                (long) props.getRefreshTokenExpSeconds()
        );
        // 3. 쿠키 설정
        // org.springframework.http.ResponseCookie
        ResponseCookie cookie = ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(true) 		// js 접근 불가
                .secure(true)  			// https 전송만 허용
                .sameSite("Strict")  	// csrf 방지
                .path("/")   			// 전체경로 적용
                .maxAge(props.getRefreshTokenExpSeconds())	// 만료시간 설정  
                .build();
        // springframework.http.HttpHeaders
        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        
        // 4. 사용자 정보 반환
        return ResponseEntity.ok(Map.of(
                "accessToken", accessToken,
                "user", user
        ));
    }


	// 로그아웃
//	@Operation(summary = "로그아웃", description = "현재 세션을 만료시켜 로그아웃합니다.")
//	@PostMapping("/logout")
//	public ResponseEntity<Void> logout(HttpSession session) {
//		session.invalidate();
//		return ResponseEntity.noContent().build();
//	}
    
    // 이제 session 사용 안함
    @Operation(summary = "로그아웃")
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(
          @CookieValue(name = "refreshToken", required = false) String refreshToken,
                                       HttpServletResponse response) {
        var claims = jwtProvider.parse(refreshToken).getBody();
        String userId = claims.getSubject();

        tokenStore.deleteRefreshToken(userId);	// redis에서 제거
 
        ResponseCookie deleteCookie = ResponseCookie.from("refreshToken", "")
                .httpOnly(true)
                .secure(true)
                .sameSite("Strict")
                .path("/")
                .maxAge(0)
                .build();
        response.addHeader(HttpHeaders.SET_COOKIE, deleteCookie.toString());

        return ResponseEntity.noContent().build();
    }

	// 마이페이지
//	@Operation(summary = "현재 로그인한 사용자 정보 조회", description = "세션 기반으로 현재 로그인한 사용자의 정보를 조회합니다")
//	@GetMapping("/me")
//	public ResponseEntity<UserResponseDto> getUser(HttpSession session) {
//		Long userId = (Long) session.getAttribute("LOGIN_USER_ID");
//		if (userId == null) {
//			return ResponseEntity.status(401).build();
//		} // 권한없음.
//		return ResponseEntity.ok(userService.getUser(userId));
//	}
    
    @Operation(summary = "현재 로그인한 사용자 정보 조회")
    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> me(HttpServletRequest request,
                 @CookieValue(name = "refreshToken", required = false) String refreshToken) {
        try { 
            // AUTHORIZATION 헤더에서 AccessToken 확인
            String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7); // Bearer 제거
                var claims = jwtProvider.parse(token).getBody();  // 토큰 파일
                String userId = claims.getSubject();  // 사용자 id 추출
                UserResponseDto user = userService.getUser(Long.valueOf(userId));  // 사용자 조회
                return ResponseEntity.ok(user);	// 사용자 반환
            }  
            if (refreshToken != null) {	
                var claims = jwtProvider.parse(refreshToken).getBody();
                String userId = claims.getSubject();	// 사용자 아이디값 추출
                UserResponseDto user = userService.getUser(Long.valueOf(userId));  // 사용자 조회
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.status(401).build();  // 인증 실패
        } catch (Exception e) {
            return ResponseEntity.status(401).build();  // 예외 발생시 인증 실패
        }
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
//	@Operation(summary = "회원 탈퇴", description = "계정을 삭제하고 세션을 만료시킵니다.")
//	@DeleteMapping("/me")
//	public ResponseEntity<Void> deleteMe(HttpSession session){
//		Long userId = (Long)session.getAttribute("LOGIN_USER_ID");
//		if(userId == null) { return ResponseEntity.status(401).build(); } // 권한 없음.
//		userService.deleteById(userId);
//		session.invalidate();
//		return ResponseEntity.noContent().build();
//	}
    @Operation(summary = "회원 탈퇴")
    @DeleteMapping("/me")
    public ResponseEntity<Void> deleteMe(HttpServletRequest request,
                                         HttpServletResponse response,
                                         @CookieValue(name = "refreshToken", required = false) String refreshToken) {
        try { 
        	// Access Token 확인
            String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return ResponseEntity.status(401).build();
            }
            // Access Token 추출
            String accessToken = authHeader.substring(7); // 키 추출
            var claims = jwtProvider.parse(accessToken).getBody();
            String userId = claims.getSubject();
            
            // 해당 유저 삭제
            userService.deleteById(Long.valueOf(userId)); // ##

            // refreshToken 삭제
            if (refreshToken != null) {
                tokenStore.deleteRefreshToken(userId);
            }
            
            // 쿠키 삭제
            ResponseCookie deleteCookie = ResponseCookie.from("refreshToken", "")
                    .httpOnly(true)
                    .secure(true)
                    .sameSite("Strict")
                    .path("/")
                    .maxAge(0)
                    .build();
            response.addHeader(HttpHeaders.SET_COOKIE, deleteCookie.toString());

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }
   
    @Operation(summary = "Access Token 재발급")
    @PostMapping("/refresh")
    public ResponseEntity<Map<String, Object>> refresh(@CookieValue("refreshToken") String refreshToken) {
        var claims = jwtProvider.parse(refreshToken).getBody();
        String userId = claims.getSubject();

        String stored = tokenStore.getRefreshToken(userId);
        if (stored == null || !stored.equals(refreshToken)) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid refresh token"));
        }

        String role = userService.findRoleByUserId(Long.valueOf(userId));

        String newAccessToken = jwtProvider.createAccessToken(
                userId,
                Map.of("role", role)
        );

        return ResponseEntity.ok(Map.of("accessToken", newAccessToken));
    }
	
}

// http://localhost:8080/swagger-ui/index.html
