package com.the703;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.the703.dto.UserDto.UserRequestDto;
import com.the703.dto.UserDto.UserResponseDto;
import com.the703.entity.AppUser;
import com.the703.entity.Post;
import com.the703.repository.AppUserRepository;
import com.the703.service.PostService;
import com.the703.service.UserService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional // 테스트 완료 후 데이터 자동 롤백
class Boot1ApplicationTests2_Service {

	@Autowired UserService userService;
	@Autowired PostService postService;
	
	private AppUser testUser;
	
	@Autowired AppUserRepository appUserRepository;
	@BeforeEach
	void createTest() {
		//// AppUser 공통으로 사용할 테스트용 회원
		AppUser user = AppUser.builder()
				.email("z@z")
				.password("z")
				.nickname("first")
				.provider("local")
				.build();
		
		testUser = appUserRepository.save(user);
	}

	@Test
	@DisplayName("1. 회원가입 및 사용자 간단 테스트")
	void testCreate() {
		UserRequestDto requestDto = new UserRequestDto();
		requestDto.setEmail("1@1");
		requestDto.setPassword("1");
		requestDto.setNickname("first");
		requestDto.setMobile("010111111");
		requestDto.setMbtitype(2);

		UserResponseDto createdUser = userService.createUser(requestDto);
		assertThat(createdUser.getId()).isNotNull();
		assertThat(createdUser.getEmail()).isEqualTo("1@1");

		UserResponseDto foundUser = userService.getUser(createdUser.getId());
		assertThat(foundUser.getId()).isNotNull();
	}

	@Test
	@DisplayName("2. 게시글 작성 테스트")
	void testPost() {
		Post created = postService.createPost(testUser.getId(), "테스트");
		assertThat(created.getId()).isNotNull();
	}
	
	@Test
	@DisplayName("3. 게시글 수정 및 검색 테스트")
	void testUpdatePost() {
		// 게시글 작성
		Post created = postService.createPost(testUser.getId(), "테스트");
		assertThat(created.getId()).isNotNull();
		
		// 작성한 게시글 수정
		Post updated = postService.updatePost(created.getId(), "수정"); // 수정할 글 번호
		assertThat(updated.getContent()).isEqualTo("수정");
		
		// 수정된 게시글 확인
		Post found = postService.getPostById(created.getId());
		assertThat(found.getContent()).isEqualTo("수정");
	}
	
	@Test
	@DisplayName("4. 게시글 삭제 테스트")
	void testDeletePost() {
		// 게시글 작성
		Post created = postService.createPost(testUser.getId(), "테스트");
		assertThat(created.getId()).isNotNull();
		
		// 게시글 삭제
		postService.deletePost(created.getId()); // 수정할 글 번호
		
		// 여러글
		List<Post> posts = postService.getAllPosts();
		boolean exists = posts.stream()
							  .anyMatch(post -> post.getId().equals(created.getId()));
		assertThat(exists).isFalse();
	}

}

/// jpa : save(insert, update) / delete(delete) / findBy필드명(select)
