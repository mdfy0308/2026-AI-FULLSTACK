package com.the703;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.the703.domain.DeptUser;
import com.the703.entity.AppUser;
import com.the703.entity.Comment;
import com.the703.entity.Hashtag;
import com.the703.entity.Image;
import com.the703.entity.Post;
import com.the703.entity.PostLike;
import com.the703.mapper.DeptUserMapper;
import com.the703.repository.AppUserRepository;
import com.the703.repository.CommentRepository;
import com.the703.repository.DeptUserRepository;
import com.the703.repository.HashtagRepository;
import com.the703.repository.ImageRepository;
import com.the703.repository.PostLikeRepository;
import com.the703.repository.PostRepository;

@SpringBootTest
@Transactional
class Boot2ApplicationTests {

	@Autowired 	private AppUserRepository appUserRepository;
	@Autowired	private PostRepository postRepository;
	@Autowired	private ImageRepository imageRepository;
	@Autowired	private HashtagRepository hashtagRepository;
	@Autowired	private CommentRepository commentRepository;
	@Autowired	private PostLikeRepository postLikeRepository;
	
	// Mapper
	@Autowired private DeptUserMapper deptUserMapper;
	@Autowired private DeptUserRepository deptUserRepository;
	@Autowired private jakarta.persistence.EntityManager entityManager;
	
	// 테스트 공통 데이터 : 사용자 2명 + 게시글 1개
	private AppUser user1;
	private AppUser user2;
	private Post post;
	
	// insert : save / select: findBy / update: save / delete : delete
	@BeforeEach
	void setup() {
		// 사용자 생성
		String email1 = "user1_" + UUID.randomUUID() + "@test.com";
		String email2 = "user2_" + UUID.randomUUID() + "@test.com";

		user1 = new AppUser();
		user1.setEmail(email1);
		user1.setPassword("pass123");
		user1.setNickname("user1");
		user1.setProvider("local");
		user1.setDeleted(false);

		user2 = new AppUser();
		user2.setEmail(email2);
		user2.setPassword("pass123");
		user2.setNickname("user2");
		user2.setProvider("local");
		user2.setDeleted(false);
		appUserRepository.save(user1);
		appUserRepository.save(user2);

		// 게시글 생성
		post = new Post();
		post.setContent("테스트 게시글");
		post.setUser(user1);
		post.setDeleted(false);
		postRepository.save(post);
	}
	
	// ----------------------------------------
	// AppUserRepository
	// ----------------------------------------
	@Test
	@DisplayName("▶AppUserRepository - CRUD")
	void contextLoads() {
		
		// 이메일 중복검사
		assertThat(appUserRepository.findByEmail(user1.getEmail()).get().getEmail() ).isEqualTo( user1.getEmail() );

	}
	
	// ----------------------------------------
	// AppUserRepository
	// ----------------------------------------
	@Test
	@DisplayName("▶ImageRepository - CRUD")
	void testImageRepository() {

		// 이미지 생성 가능
		Image image = new Image();
		image.setSrc("1.png");
		image.setPost(post);
		imageRepository.save(image);
		
		// 단건 조회
		assertThat( imageRepository.findById(image.getId()).get().getSrc()).isEqualTo("1.png");

		// 삭제 후 조회 불가 확인
		imageRepository.delete(image);
		assertThat(imageRepository.findById(image.getId())).isEmpty();

	}
	
	// -------------------------------------------------------------------
	// HashtagRepository
	// -------------------------------------------------------------------
	// insert : save / select:findBy / update:save / delete:delete
	@Test
	@DisplayName("▶HashtagRepository-CRUD")
	void testHashtagRepository() {
		// 해쉬태그저장
		Hashtag tag = new Hashtag();
		tag.setName("haha");
		hashtagRepository.save(tag);
		
		// 포스트에 저장
		post.getHashtags().add(tag); //
		tag.getPosts().add(post);
		postRepository.save(post);
		
		// 검색
		Optional<Hashtag> withPosts = hashtagRepository.findByNameWithPosts("haha");
		assertThat(withPosts).isPresent();
		assertThat(withPosts.get().getPosts()).isNotEmpty();
		assertThat(withPosts.get().getName()).isEqualTo("haha");
	}

	// -------------------------------------------------------------------
	// CommentRepository
	// -------------------------------------------------------------------
	// insert : save / select:findBy / update:save / delete:delete
	@Test
	@DisplayName("▶CommentRepository-CRUD")
	void testcommentRepository() {
		// 댓글 생성
		Comment comment = new Comment();
		comment.setContent("테스트 댓글");
		comment.setDeleted(false);
		comment.setUser(user1);
		comment.setPost(post);
		commentRepository.save(comment);
		
		// 댓글 조회
		List<Comment> comments = commentRepository.findByPostIdAndDeletedFalse(post.getId());
		assertThat(comments.size()).isEqualTo(1);
		
		// 댓글 수정
		comment.setContent("수정된 댓글");
		commentRepository.save(comment);
		assertThat(commentRepository.findById(comment.getId()).get().getContent()).isEqualTo("수정된 댓글");
		
		// 댓글 삭제
		comment.setDeleted(true);
		commentRepository.save(comment);
		List<Comment> rcomments = commentRepository.findByPostIdAndDeletedFalse(post.getId());
		assertThat(rcomments.size()).isEqualTo(0);
		
	}
	
	// -------------------------------------------------------------------
	// PostLikeRepository
	// -------------------------------------------------------------------
	// insert : save / select:findBy / update:save / delete:delete
	@Test
	@DisplayName("▶PostLikeRepository-CRUD")
	void testPostLikeRepository() {

		// 좋아요 생성
		PostLike like = new PostLike(user2, post);
		postLikeRepository.save(like);

		// 특정 유저가 특정 게시글 좋아요 했는지
		Optional<PostLike> found = postLikeRepository.findByUser_IdAndPost_Id(user2.getId(), post.getId());
		assertThat(found).isPresent();

		// 특정 게시글 좋아요 수 집계
		long count = postLikeRepository.countByUser_IdAndPost_Id(user2.getId(), post.getId());
		assertThat(count).isEqualTo(1L);

		// 특정 게시글 좋아요 수 취소
		postLikeRepository.deleteByUser_IdAndPost_Id(user2.getId(), post.getId());
		long rcount = postLikeRepository.countByUser_IdAndPost_Id(user2.getId(), post.getId());
		assertThat(rcount).isEqualTo(0L);
			
		}
	
	// ----------------------------------------------------------
	// Mapper
	// ----------------------------------------------------------
	@Test
	@DisplayName("▶DeptUserMapper-CRUD")
	void testDeptUserMapper() {
		DeptUser dept1 = new DeptUser();
		dept1.setDeptno(10L);
		dept1.setDname("영업부");
		dept1.setLoc("서울");
		
		DeptUser dept2 = new DeptUser();
		dept2.setDeptno(20L);
		dept2.setDname("개발부");
		dept2.setLoc("부산");
		
		//Q1. repository - 간단한 crud 이용
		deptUserRepository.save(dept1);
		deptUserRepository.save(dept2); entityManager.flush(); entityManager.clear();
		
		//Q2. mapper에 있는 찾기 메서드
		List<DeptUser> lists = deptUserMapper.findByNameKeyword("영업");
		
		//Q3. 검증 assertThat 
		assertThat(lists.get(0).getDname()).contains("영업");
		
	}
	
}
