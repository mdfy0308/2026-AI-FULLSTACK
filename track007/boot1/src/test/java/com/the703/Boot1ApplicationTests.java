package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;
import com.the703.service.AppUserService;

@SpringBootTest
class Boot1ApplicationTests {
	@Autowired AppUserDao dao;
	@Autowired AppUserService service;
	
	// 삭제
	@Disabled @Test public void deleteService_User() {
		AppUserDto user = new AppUserDto();
		user.setEmail("2@2");
		user.setPassword("2");
		user.setAppUserId(61);
		assertEquals(1, service.delete(user, true));
	}
	
	// 수정
	@Disabled @Test public void updateService_User() {
		AppUserDto user = new AppUserDto();
		user.setEmail("2@2"); user.setPassword("2");
		user.setMbtiTypeId(2); user.setUfile("2.png");
		user.setMobile("01012345678"); user.setNickname("BETA");
		user.setProvider("local"); user.setProviderId("local_002");
		user.setAppUserId(61);
		
		MockMultipartFile file = new MockMultipartFile("file", "test.text", "text/plain", "data".getBytes());
		
		assertEquals(1, service.update(file, user)); // 예상되는 결과, 코드
	}
	
	// 이메일 중복
	@Disabled @Test public void iddoubleService_User() {
		int result = service.iddouble("2@1", "local");
		System.out.println(result == 1? "중복":"사용 가능");
	}
	
	// 마이페이지
	@Disabled @Test public void mypageService_User() {
		AppUserDto mypage = service.selectEmail("2@1", "local");
		assertNotNull(mypage);
		System.out.println(mypage);
	}
		
	// 로그인
	@Disabled @Test public void login_Service_User() {
		AppUserAuthDto login =  service.readAuthByEmail("2@1", "local");
		assertNotNull(login);
		assertEquals("2@1", login.getEmail());
		assertTrue( login.getAuthList().stream().anyMatch(a -> "ROLE_MEMBER".equals(a.getAuth())) );
	}
	
	// 등록
	@Test public void insert_Service_User() {
		AppUserDto user = new AppUserDto();
		user.setEmail("2@2");
		user.setPassword("2");
		user.setMbtiTypeId(1);
		user.setUfile("2.png");
		user.setMobile("01012345678");
		user.setNickname("ALPHA");
		user.setProvider("local");
		user.setProviderId("local_001");
		
		MockMultipartFile file = new MockMultipartFile("file", "test.text", "text/plain", "data".getBytes());
		
		int result = service.insert(file, user);
		assertEquals(1, result); // 예상되는 결과, 코드

	}
	
	//////////////////////////////////////////////////////////////
	
	//6. 수정 (동적SQL)
	@Disabled @Test
	public void update_user() {
		AppUserDto user = new AppUserDto();
		user.setAppUserId(21);
		user.setNickname("first");
		
		System.out.println("...................");
		System.out.println(user);
	}
	
	//5. 사용자 + 권한 삭제
	@Disabled @Test 
	public void delete_user() {
		AppUserDto user = new AppUserDto();
		user.setAppUserId(21);
		assertEquals(1, dao.deleteAppUser(user));
		
		AuthDto auth = new AuthDto();
		auth.setEmail("1@1");
		assertEquals(1, dao.deleteAuth(auth));
	}
	
	//4. 마이페이지
	@Disabled @Test 
	public void mypage_User() {
		AppUserDto user = new AppUserDto();
		user.setEmail("1@1");
		// assertEquals( "1@1", dao.findByEmail(user).getEmail() );
		System.out.println(user);
	}
	
	//3. 아이디중복
	@Disabled @Test 
	public void iddoubleByEmail() {
		AppUserDto user = new AppUserDto();
		user.setEmail("1@1");
		int result = dao.iddoubleByEmail(user);
		assertEquals(1, result);
	}
	
	//2. 로그인
	@Disabled @Test
	public void login_user(){
		AppUserDto user = new AppUserDto();
		user.setEmail("1@1");
		assertNotNull(dao.readAuthByEmail(user));
	}
	
	@Disabled @Test
	public void insert_User(){ // 1. 회원가입 - 유저 등록 + 권한 등록
		AppUserDto user = new AppUserDto();
		user.setEmail("1@1");
		user.setPassword("1");
		user.setMbtiTypeId(1);
		user.setUfile("1.png");
		user.setMobile("01012345678");
		user.setNickname("ALPHA");
		user.setProvider("local");
		user.setProviderId("local_001");
		
		int result = dao.insertAppUser(user);
		assertEquals(1, result); // 예상되는 결과, 코드
		// org.junit.jupiter.api.Assertions.assertEquals;
		
		AuthDto auth = new AuthDto();
		auth.setEmail("1@1");
		auth.setAuth("ROLE_USER");
		int result_auth = dao.insertAuth(auth);
		assertEquals(1, result_auth);
		
	}	

}
