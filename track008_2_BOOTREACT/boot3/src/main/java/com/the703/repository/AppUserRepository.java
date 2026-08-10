package com.the703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.the703.entity.AppUser;

@Repository // Entity, PK-자료형
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	Optional<AppUser> findByEmail(String email);
	
	// 단건조회 : 이메일, 프로바이더로 단건 조회
	Optional<AppUser> findByEmailAndProvider(String email, String provider);
	
	// 닉네임으로 조회
	Optional<AppUser> findByNickname(String nickname);
	
	// 닉네임 중복여부
	boolean existsByNickname(String nickname);
	
	// 이메일 중복여부
	boolean existsByEmail(String email);
	
}


//create - save 		: insert into app_user (column) values (?, ?, ?...)
// read - findById : select * from app_user where id=?
// update - save : update from app_user set password=? where id=?
// delete - deleteById : delete from app_user where id=?

// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
/*
1. 검색 : findBy필드명

*/