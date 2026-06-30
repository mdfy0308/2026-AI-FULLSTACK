package com.the703.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;
import com.the703.util.UtilUpload;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired private AppUserDao dao;
	@Autowired private UtilUpload upload;
	@Autowired private PasswordEncoder passwordEncoder;

	// 회원가입
	@Transactional
	@Override
	public int insert(MultipartFile file, AppUserDto dto) {

		dto.setUfile("the703.png");
		// 파일 업로드
		if (!file.isEmpty()) {
			try { dto.setUfile(upload.fileUpload(file)); } 
			catch (IOException e) { e.printStackTrace(); }
		}
		dto.setMbtiTypeId(1); // 확장버전 : mbti
		dto.setProviderId("the703-1"); // UUID - 추가
		dto.setProvider("the703");
		
		// 비밀번호 암호화
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		int result = dao.insertAppUser(dto); // # sql 1번
		// @Transactional - sql 구문을 2개 이상 사용했을 경우, 둘중 하나라도 실패하면 롤백

		// 권한
		AuthDto udto = new AuthDto();
		udto.setEmail(dto.getEmail()); udto.setAuth("ROLE_MEMBER");

		// 정보 등록 성공하면 권한도 넣기
		if (result > 0) { dao.insertAuth(udto); } // # sql 2번

		return result;
	}

	// 로그인
	@Override
	public AppUserAuthDto readAuthByEmail(String email, String provider) {
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);
		return dao.readAuthByEmail(dto);
	}

	// 마이페이지
	@Override
	public AppUserDto selectEmail(String email, String provider) {
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);
		return dao.findByEmail(dto);
	}

	// 이메일 중복
	@Override
	public int iddouble(String email, String provider) {
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);
		return dao.iddoubleByEmail(dto);
	}

	// 로그인한 유저 맞는지 확인(비밀번호 확인)
	@Override
	public boolean matchesPassword(String email, String provider, String rawPassword) {
		// 1. dbUser 찾기
		AppUserDto dbUser = new AppUserDto();
		dbUser.setEmail(email);
		AppUserDto result = dao.findByEmail(dbUser);

		// 2. 비밀번호 일치하는지 확인
		return result != null 
			   && result.getPassword() != null
			   && passwordEncoder.matches(rawPassword, result.getPassword());
		// 사용자가 입력한 값(rawPassword)과 찾아온 db결과물(result)이 일치하는지 확인
	}

	// 유저 정보 삭제
	@Transactional
	@Override public int delete(AppUserDto dto, boolean local) {
		// 비밀번호가 안 맞으면 0
		if (!matchesPassword(dto.getEmail(), dto.getProvider(), dto.getPassword())) { return 0; }

		dao.deleteAppUser(dto);

		AuthDto adto = new AuthDto();
		adto.setEmail(dto.getEmail());
		adto.setAuth("ROLE_MEMBER");

		dao.deleteAuth(adto);
		return 1;
	}

	// 유저 정보 업데이트
	@Transactional @Override
	public int update(MultipartFile file, AppUserDto dto) {
		// 비밀번호가 안 맞으면 0
		if (!matchesPassword(dto.getEmail(), dto.getProvider(), dto.getPassword())) { return 0; }
		
		// 이미지 업로드 기능
		if (!file.isEmpty()) {
			try { dto.setUfile(upload.fileUpload(file)); } 
			catch (IOException e) { e.printStackTrace(); }
		}

		return dao.updateAppUser(dto);
	}

}
