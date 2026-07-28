package com.the703.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.the703.dto.PostDto.PostRequestDto;
import com.the703.dto.PostDto.PostResponseDto;
import com.the703.entity.Post;
import com.the703.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Post Api", description = "게시글 관련 API")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PostController {

	private final PostService postService;

	// 게시글 등록
	@Operation(summary = "게시글 등록", description = "새로운 게시글을 등록합니다.")
	@PostMapping
	public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto requestDto) {
		Post createdPost = postService.createPost(requestDto.getUserId(), requestDto.getContent());
		return ResponseEntity.ok(new PostResponseDto(createdPost));
	}

	// 전체 게시글 조회
	@Operation(summary = "전체 게시글 조회", description = "전체 게시글을 조회합니다.")
	@GetMapping
	public ResponseEntity<List<PostResponseDto>> getAllPosts() {
		List<Post> posts = postService.getAllPosts();
		List<PostResponseDto> lists = posts.stream()
										   .map(PostResponseDto::new) // PostResponseDto
										   .collect(Collectors.toList()); // list로 변경
		return ResponseEntity.ok( lists );
	}

	
	// 게시글 단건 조회
	@Operation(summary = "게시글 조회", description = "게시글의 상세내용을 조회합니다.")
	@GetMapping("/{id}")
	public ResponseEntity<PostResponseDto> getPost(@PathVariable("id") Long id) {
		Post post = postService.getPostById(id);
		return ResponseEntity.ok(new PostResponseDto(post));
	}

	
	// 게시글 수정
	@Operation(summary = "게시글 수정", description = "게시글을 수정합니다.") // 수정 put(전체 데이터 수정), patch(데이터 일부분 수정)
	@PutMapping("/{id}")
	public ResponseEntity<PostResponseDto> updatePost(
			@PathVariable("id") Long id,
			@RequestBody PostRequestDto requestDto) {
		Post post = postService.updatePost(id, requestDto.getContent());
		return ResponseEntity.ok(new PostResponseDto(post)); // 200
	}

	// 게시글 삭제
	@Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deletePost(@PathVariable("id") Long id) {
		postService.deletePost(id);
		return ResponseEntity.ok(id); // 200
	}

}

// http://localhost:8080/swagger-ui/index.html

/*
 - GET       /api/posts/{id}      게시글 단건 조회 ※  getPostById 
  - PUT      /api/posts/{id}      게시글 수정     ※  updatePost
  - DELETE   /api/posts/{id}      게시글 삭제     ※  deletePost
  - GET      /api/posts      전체 게시글 조회     ※  getAllPosts , getPostPaged
  - POST    /api/posts      게시글 작성         ※  createPost 
*/
