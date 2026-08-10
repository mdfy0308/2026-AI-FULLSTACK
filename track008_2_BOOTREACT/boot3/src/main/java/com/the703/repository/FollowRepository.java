package com.the703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.the703.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
	
	// 팔로우 단건 조회	- 팔로워/팔로위 findBy / ※Optional<Follow>
	Optional<Follow> findByFollower_IdAndFollowee_Id(Long followerId, Long followeeId);
		
	// 팔로잉 목록 조회	findBy 	→	AppUser(엔티티) follower(필드) id 찾기
	// 1) 쿼리 1개 : findByFollower_Id(1L) 팔로잉 목록 10명		1
	// 2) 추가 쿼리 10개 : 각각의 정보를 가져오려면 쿼리 10번 더			N 11번의 쿼리 실행? X → 한꺼번에 하자
	// ----------------- 아래 추가
	// @EntityGraph(attributePaths = {"followee"})	// 쿼리 실행시 Followee 데이터까지 한꺼번에 조회
	@EntityGraph(attributePaths = {"followee"})	// 쿼리 실행시 Followee 데이터까지 한꺼번에 조회
	List<Follow> findByFollower_Id(Long followerId);
	
	// 팔로워 목록 조회	findBy 	→	AppUser(엔티티) followee(필드) id 찾기
	@EntityGraph(attributePaths = {"follower"})	// 쿼리 실행시 Followee 데이터까지 한꺼번에 조회
	List<Follow> findByFollowee_Id(Long followeeId);
	
	// 팔로잉 수 집계	countBy →	AppUser(엔티티) follower(필드) id 찾기
	long countByFollower_Id(Long followerId);
	
	// 팔로워 수 집계	countBy →	AppUser(엔티티) followee(필드) id 찾기
	long countByFollowee_Id(Long followeeId);

}
