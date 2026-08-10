package com.the703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.the703.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> { // Entity, PK
	
	List<Post> findByDeletedFalseOrderByCreatedAtDesc(); // List<Post> - 결과가 여러 개일 때
	
	// 해시태그 이름으로 게시글 검색하기
	List<Post> findByHashtags_NameAndDeletedFalse(String name);
	
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
	
	// 특정 유저가 좋아요한 게시물
	@Query(	value=
			"SELECT * FROM ( " +
            "SELECT p.*, ROWNUM AS rnum " +
            "FROM ( " +
            "   SELECT po.ID, po.CONTENT, po.CREATED_AT, po.DELETED, po.UPDATED_AT, po.APP_USER_ID " +  
            "   FROM POSTS po " +
            "   WHERE po.APP_USER_ID = :userId AND po.DELETED = 0 " +
            "   UNION ALL " +
            "   SELECT po.ID, po.CONTENT, po.CREATED_AT, po.DELETED, po.UPDATED_AT, po.APP_USER_ID " + 
            "   FROM POSTS po " +
            "   WHERE po.ID IN ( " +
            "       SELECT DISTINCT r.ORIGINAL_POST_ID " +
            "       FROM RETWEETS r " +
            "       WHERE r.APP_USER_ID = :userId " +
            "   ) AND po.DELETED = 0 " +
            "   ORDER BY CREATED_AT DESC " +  
            ") p " +
            ") " +
            "WHERE rnum BETWEEN :start AND :end",
            nativeQuery = true
	)
	List<Post> findLikedPostsWithPaging(@Param("userId") Long userId,
										  @Param("start") int start,
										  @Param("end") int end);
	
	// 내가 쓴 글 + 내가 리트윗한 글
	@Query(value=
			"SELECT * FROM ( " +
		    "SELECT p.*, ROWNUM AS rnum " +
		    "FROM ( " +
		    "   SELECT po.ID, po.CONTENT, po.CREATED_AT, po.DELETED, po.UPDATED_AT, po.APP_USER_ID " +  
		    "   FROM POSTS po " +
		    "   WHERE po.APP_USER_ID = :userId AND po.DELETED = 0 " +
		    "   UNION ALL " +
		    "   SELECT po.ID, po.CONTENT, po.CREATED_AT, po.DELETED, po.UPDATED_AT, po.APP_USER_ID " + 
		    "   FROM POSTS po " +
		    "   WHERE po.ID IN ( " +
		    "       SELECT DISTINCT r.ORIGINAL_POST_ID " +
		    "       FROM RETWEETS r " +
		    "       WHERE r.APP_USER_ID = :userId " +
		    "   ) AND po.DELETED = 0 " +
		    "   ORDER BY CREATED_AT DESC " +  
		    ") p " +
		    ") " +
		    "WHERE rnum BETWEEN :start AND :end",
		    nativeQuery = true
	)
	List<Post> findMyPostsAndRetweetsWithPaging(@Param("userId") Long userId,
											    @Param("start") int start,
											    @Param("end") int end);
	
	
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