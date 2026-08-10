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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="POST_LIKES", 
	uniqueConstraints = @UniqueConstraint(columnNames = {"APP_USER_ID", "POST_ID"})
)
@Getter @Setter @NoArgsConstructor
public class PostLike {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="post_Like_seq")
	@SequenceGenerator(name="post_Like_seq", sequenceName = "POST_LIKE_SEQ", allocationSize = 1)
	private Long id;
	

	@Column(name="CREATED_AT", nullable=false)
	private LocalDateTime createdAt; // 좋아요 누른 시점
	
	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@ManyToOne
	@JoinColumn(name="APP_USER_ID", nullable=false)
	private AppUser user;
	
	@ManyToOne
	@JoinColumn(name="POST_ID", nullable=false)
	private Post post;
	
	public PostLike(AppUser user, Post post) {
		super();
		this.user = user;
		this.post = post;
	}
	

}
