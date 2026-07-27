package com.the703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.the703.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> { // Entity, PK
	
	List<Post> findByDeletedFalse(); // List<Post> - 결과가 여러 개일 때
	
	// 비교 - 결과값이 1개거나 없을 때는 Optional
	// Optional<AppUser> findByEmail(String email);
	
	@Query(
			value="SELECT * FROM ( " +
		    "SELECT p.*, ROWNUM AS rnum " +
		    "FROM (SELECT * FROM POSTS WHERE DELETED = 0 ORDER BY CREATED_AT DESC) p " + 
		    ") " +
		    "WHERE rnum BETWEEN :start AND :end", 
		    nativeQuery=true
	)
	List<Post> findPostWithPaging(@Param("start") int start, @Param("end") int end);
	
}

/* 

(1) 사용할 수 있는 기본 sql
1. Create 	: save - insert into posts (컬럼...) values (?, ?...)
2. Read		: findAll - select * from posts
			: findById - select * from posts where id = ?
3. Update	: save - update 테이블명 set 컬럼=값 where id(PK) = ?
4. Delete	: deleteById - delete from posts where id = ? 

(2) 삭제 안 된 게시글 찾기, findBy필드명

(3) 복잡한 sql - @Query

*/