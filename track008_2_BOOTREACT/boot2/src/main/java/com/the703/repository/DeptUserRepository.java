package com.the703.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.the703.domain.DeptUser;

public interface DeptUserRepository extends JpaRepository<DeptUser, Long> {

}
