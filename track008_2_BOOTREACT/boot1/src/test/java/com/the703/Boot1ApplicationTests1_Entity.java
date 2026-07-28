package com.the703;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.the703.entity.AppUser;
import com.the703.entity.Post;
import com.the703.repository.AppUserRepository;
import com.the703.repository.PostRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional // 테스트 완료 후 데이터 자동 롤백
class Boot1ApplicationTests1_Entity {
	@Autowired	AppUserRepository appUserRepository;
	@Autowired	PostRepository postRepository;

	// insert, update(save) select(findBy) delete(deleteBy)

	private AppUser savedUser;
	private Post savedPost;
	
	// ============================================
	// 1. CREATE(생성테스트)
	// ============================================
	
	@BeforeEach
	void createTest() {
		//// AppUser 공통으로 사용할 테스트용 회원
		AppUser user = AppUser.builder()
				.email("3@3")
				.password("1234")
				.nickname("third")
				.provider("local").build();
		savedUser = appUserRepository.save(user);
		

		//// Post 공통으로 사용할 테스트용 게시글
		Post post = new Post();
		post.setContent("CRUD 테스트용 게시글 내용입니다.");
		post.setUser(savedUser);
		savedPost = postRepository.save(post);
	}
	
	@Test
	@DisplayName("1. CREATE 생성테스트(save)")
	void testCreate() {
		assertThat(savedUser.getId()).isNotNull();
		assertThat(savedPost.getId()).isNotNull();
	}
	
	@Test
	@DisplayName("2. READ 생성테스트(findBy)")
	void testRead() {
		Optional<AppUser> foundUser = appUserRepository.findById(savedUser.getId());
		assertThat(foundUser).isPresent(); // true, false
		assertThat(foundUser.get().getNickname()).isEqualTo("third");
		
		Optional<AppUser> foundEmail = appUserRepository.findByEmail("3@3");
		assertThat(foundEmail).isPresent(); // true, false
		assertThat(foundEmail.get().getEmail()).isEqualTo("3@3");
		
		List<Post> posts = postRepository.findByDeletedFalse();
		assertThat(posts).isNotEmpty();
	}
	
	@Test
	@DisplayName("3. UPDATE 생성테스트(save)")
	void testUpdate() {
		savedUser.setNickname("three");
		appUserRepository.save(savedUser);
		
		savedPost.setContent("update... 260727");
		postRepository.save(savedPost);		
		
		AppUser updatedUser = appUserRepository.findById(savedUser.getId()).get();
		Post 	updatedPost = postRepository.findById(savedPost.getId()).get();
		
		assertThat(updatedUser.getNickname()).isEqualTo("three");
		assertThat(updatedPost.getContent()).isEqualTo("update... 260727");
	}
	
	@Test
	@DisplayName("4. DELETE 생성테스트(delete)")
	void testDelete() {
		appUserRepository.delete(savedUser);
		postRepository.delete(savedPost);
		
		Optional<AppUser> deletedUser = appUserRepository.findById(savedUser.getId());
		Optional<Post> deletedPost = postRepository.findById(savedPost.getId());
		
		assertThat(deletedUser).isEmpty();
		assertThat(deletedPost).isNotEmpty();
	}

}


/// jpa : save(insert, update) / delete(delete) / findBy필드명(select)
