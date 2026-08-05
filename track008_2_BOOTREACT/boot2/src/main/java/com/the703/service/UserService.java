package com.the703.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // ##
import org.springframework.web.multipart.MultipartFile;

import com.the703.dto.LoginRequest;
import com.the703.dto.UserDto.UserRequestDto;
import com.the703.dto.UserDto.UserResponseDto;
import com.the703.entity.AppUser;
import com.the703.exception.ResourceNotFoundException;
import com.the703.repository.AppUserRepository;
import com.the703.util.FileStorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 데이터 저장(insert)시 rollback // readOnly=true 읽기 전용, 낭비
public class UserService {

	private final AppUserRepository appUserRepository; // @Autowired 대신
	private final FileStorageService fileStorageService;

	// 보안 : 비밀번호 암호화 ##
	// create : 회원가입
	@Transactional
	public UserResponseDto createUser(UserRequestDto request, MultipartFile profileImage) {
		String provider = request.getProvider() != null ? request.getProvider() : "local";
		
		if(appUserRepository.findByEmailAndProvider(request.getEmail(), provider).isPresent()) {
			throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
		}
		if(appUserRepository.existsByNickname(request.getNickname())) {
			throw new IllegalArgumentException("이미 사용중인 닉네임입니다.");
		}
		
		AppUser user = new AppUser();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setNickname(request.getNickname());
		user.setProvider(provider);
		user.setRole("ROLE_USER");
		user.setUfile(profileImage != null && !profileImage.isEmpty()
					  ? fileStorageService.upload(profileImage)
					  : "uploads/the703.png");
		
		return UserResponseDto.fromEntity(appUserRepository.save(user)); // 유저 생성
	}

	// Read : 이메일 중복검사
	public boolean existsByEmail(String email) { return appUserRepository.existsByEmail(email); }
	
	// Read : 닉네임 중복검사
	public boolean existsByNickname(String nickname) { return appUserRepository.existsByNickname(nickname); }
	
	// Read : 로그인
	public UserResponseDto login(LoginRequest request) {
		AppUser user = appUserRepository.findByEmailAndProvider(
											request.getEmail(),
											request.getProvider() != null? request.getProvider():"local")
										.orElseThrow(()-> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
		return UserResponseDto.fromEntity(user);
	}
	
	// Read : 사용자 단건조회
	public UserResponseDto getUser(Long userId){ // Optional - 값 1개, null
		AppUser user = appUserRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다. id : " + userId));
		return UserResponseDto.fromEntity(user); 

	}

	// Read : 전체 사용자 수
	public long countUsers() { return appUserRepository.count(); }

	// Update : 닉네임 변경
	@Transactional
	public UserResponseDto updateNickname(Long userId, String newNickname) {
		
		if(appUserRepository.existsByNickname(newNickname)) {
			throw new IllegalArgumentException("이미 사용중인 닉네임입니다.");
		}
		
		// 해당 유저 번호 받아서 유저 찾기
		AppUser user = appUserRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. ID: " + userId));

		// 수정
		user.setNickname(newNickname);
		return UserResponseDto.fromEntity(user);
	}

	// Update : 프로필 이미지변경
	@Transactional
	public UserResponseDto updateProfileImage(Long userId, MultipartFile profileImage) {
		// 해당유저 번호 받아서 유저찾기
		AppUser user = appUserRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("사용자를 찾을 수 없습니다.id:" + userId));
		// 수정
		user.setUfile(profileImage != null && !profileImage.isEmpty() ? fileStorageService.upload(profileImage)
				: "uploads/thejoa703.png");
		return UserResponseDto.fromEntity(user);
	}

	// Delete : 회원탈퇴
	@Transactional
	public void deleteById(Long userId) {
		// 선택 1) 소프트 딜리트 - 프로필 이미지 변경한 예시처럼 수정
		if (!appUserRepository.existsById(userId)) {
			throw new IllegalArgumentException("삭제할 사용자가 존재하지 않습니다. ID: " + userId);
		}
		appUserRepository.deleteById(userId); //  선택 2) 실제 db에서 삭제(하드딜리트)
	}

	


}




