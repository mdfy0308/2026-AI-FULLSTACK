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
@Table(name = "COMMENTS")
@Getter @Setter
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
	@SequenceGenerator(name= "comment_seq", sequenceName= "COMMENT_SEQ", allocationSize= 1)
	private Long id;
	
	@Lob
	@Column(nullable = false)
	private String content;	// 게시글 내용(긴 텍스트)
		
	@Column(name="CREATED_AT", nullable = false)
	private LocalDateTime createdAt;
	
	@Column(name="UPDATED_AT", nullable = false)
	private LocalDateTime updatedAt;
	
	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	@PreUpdate
	void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
	@Column
	private boolean deleted=false;


	// 한 유저가/한 게시글이 여러 개의 코멘트를 가질 수 있음
	@ManyToOne
	@JoinColumn(name="APP_USER_ID", nullable = false)
	private AppUser user;
	
	@ManyToOne
	@JoinColumn(name="POST_ID", nullable = false)
	private Post post;
	
}
