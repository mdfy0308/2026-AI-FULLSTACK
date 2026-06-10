package ex03;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.UserDto;
import com.the703.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) // 1. spring 구동테스트
@ContextConfiguration(locations = {
	    "classpath:config/root-context.xml",
	    "classpath:config/security-context.xml"  // security 설정 있으면 포함
	}) // 2. 설정

public class ModelTest2 {
	@Autowired UserMapper user;
	@Autowired UserService service;
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	
	/* security */
	@Test public void test3() throws UnknownHostException {
		
		/* 해당 유저 정보 가져오기 */
		AuthDto dto2 = new AuthDto(); dto2.setEmail("a@a"); 
		System.out.println( user.readAuth(dto2) ); 
				
		/* 권한 2개 - 회원 , admin */
//		AuthDto dto1 = new AuthDto();
//		dto1.setEmail("a@a"); dto1.setAuth("ROLE_ADMIN");
//		System.out.println( user.insertAuth(dto1) ); // ROLE_MEMBER, ROLE_ADMIN
		
		/* 회원가입(비밀번호 암호화) pwencoder.encode("a") */
//		UserDto dto = new UserDto();
//		dto.setNickname("first"); dto.setBpass( pwencoder.encode("a") );
//		dto.setEmail("a@a"); dto.setMobile("01011111234");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		System.out.println(user.join(dto));
	}
	
	@Ignore @Test public void test1() throws UnknownHostException {
		
		// 이메일 중복 : email
//		System.out.println( user.findByEmail("first@gmail.com") );
//		
//		// 마이페이지 : uno
//		System.out.println( user.findByUno(1) );
		
		// 로그인 : email/bpass
//		UserDto dto2 = new UserDto();
//		dto2.setBpass("1234"); dto2.setEmail("first@gmail.com");
//		System.out.println( user.findLogin(dto2) );
				
		// 회원가입 : UserDto
//		UserDto dto = new UserDto();
//		dto.setNickname("first"); dto.setBpass("1234");
//		dto.setEmail("first@gmail.com"); dto.setMobile("01011111234");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		System.out.println(user.join(dto));
		
	}
}
