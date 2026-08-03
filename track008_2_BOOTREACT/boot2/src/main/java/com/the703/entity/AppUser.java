package com.the703.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="APP_USER")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_seq")
	@SequenceGenerator(name = "appuser_seq", sequenceName = "APPUSER_SEQ", allocationSize = 1)
	@Column(name="APP_USER_ID")
	private long id;
	
	@Column(length = 120, nullable=false)
	private String email;
	
	@Column(length = 200, nullable=false) // length 길이, nullable null 허용/비허용
	private String password;
	
	@Builder.Default
	@Column(length = 50, nullable=false)
	private String role="ROLE_USER";	// 기본 권한
	
	
	@Column(length = 150, nullable=false)
	private String provider="local";
	
	@Column(name="PROVIDER_ID", length = 150)
	private String providerId="local";
	
	@Column(length = 255)
	private String ufile;
	
	@Column(length = 50, nullable=false)
	private String nickname;
	
	@Column(length = 30)
	private String mobile;
	
	@Column(name="Mbti_TYPE_ID")
	private Integer mbtitype;
	
	@Column
	private boolean deleted=false;
	
	@Column(name="CREATED_AT", nullable=false)
	private LocalDateTime createdAt;
	
	@Column(name="UPDATED_AT", nullable=false)
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
	
	public AppUser(String email, String password, String provider, String nickname) {
		super();
		this.email = email;
		this.password = password;
		this.provider = provider;
		this.nickname = nickname;
		this.role     = "ROLE_USER";
	}
	
	// [한 사람]이 → 여러 개의 글을 작성할 수 있다.
	// 1. mappedBy = "user" : Post 엔티티에 있는 user 필드와 연결 - 읽기만 가능 / 수정 X
	// 2. cascade = CascadeType.ALL : AppUser 변화(생성, 수정, 삭제)를 연결된 POST에 반영
	// 3. orphanRemoval = true : 유저 탈퇴시 유저가 작성한 글도 삭제
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Post> posts = new ArrayList<>();
	
	// 좋아요
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<PostLike> likes = new ArrayList<>();
	
	// 코멘트
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments = new ArrayList<>();
	
	// 리트윗
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Retweet> retweets = new ArrayList<>();
	
	@OneToMany(mappedBy="follower", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Follow> following = new ArrayList<>(); // 내가 팔로우한 사람들
	
	@OneToMany(mappedBy="followee", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Follow> followers = new ArrayList<>(); // 나를 팔로우하는 사람들
	
	
	
}







