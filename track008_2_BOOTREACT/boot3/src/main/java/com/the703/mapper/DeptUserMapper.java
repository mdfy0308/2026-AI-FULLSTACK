package com.the703.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.the703.domain.DeptUser;

@Mapper
public interface DeptUserMapper {
	List<DeptUser> findByNameKeyword(String keyword);
}
