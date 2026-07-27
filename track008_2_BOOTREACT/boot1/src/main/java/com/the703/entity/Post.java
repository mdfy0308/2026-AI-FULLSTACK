package com.the703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "POSTS")
@Getter @Setter
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
	@SequenceGenerator(name="post_seq", sequenceName = "POST_SEQ", allocationSize = 1)
	private Long id;
	
	@Column
	private boolean deleted=false;
	
	@Column(nullable = false, name="CREATED_AT")
	private LocalDateTime createdAt;
	
	@Column(nullable = false, name="UPDATED_AT")
	private LocalDateTime updatedAt;
	
	@Lob	// 대용량 데이터 처리 - CLOB(문자열 전용), BLOB(이미지, 파일, 오디오, 영상 등)
	@Column(nullable = false)
	private String content;
	
	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	@PreUpdate
	void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
	// [여러 개의 글]을 → 한 사람이 작성할 수 있다.
	@ManyToOne // 1. 다대일
	@JoinColumn(name="APP_USER_ID", nullable = false)
	private AppUser user;
	
}
