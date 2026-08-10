package com.the703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="RETWEETS",
	uniqueConstraints = @UniqueConstraint(
			name="UK_RETWEET_USER_ORIG", columnNames = {"APP_USER_ID", "POST_ID"}
	)
)
@Getter @Setter
public class Retweet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="retweet_seq")
	@SequenceGenerator(name="retweet_seq", sequenceName = "RETWEET_SEQ", allocationSize = 1)
	private Long id;
		
	@Column(name="CREATED_AT", nullable=false)
	private LocalDateTime createdAt;
	
	@PrePersist
	void onCreate() { this.createdAt = LocalDateTime.now(); }
	
	public Retweet(LocalDateTime createdAt, AppUser user, Post originalPost) {
		super();
		this.createdAt = createdAt;
		this.user = user;
		this.originalPost = originalPost;
	}
	
	@ManyToOne
	@JoinColumn(name="APP_USER_ID", nullable=false)
	private AppUser user; // 리트윗한 사람
	
	@ManyToOne
	@JoinColumn(name="ORIGINAL_POST_ID", nullable=false) // ORIGINAL_POST_ID 외래키(FK)
	private Post originalPost; // 원본 게시글
	
}
