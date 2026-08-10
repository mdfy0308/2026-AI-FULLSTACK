package com.the703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="FOLLOWS")
@Getter @Setter
public class Follow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_seq")
	@SequenceGenerator(name="follow_seq", sequenceName = "FOLLOW_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(nullable = false, name="CREATED_AT")
	private LocalDateTime createdAt;
	
	@PrePersist
	void onCreate() { this.createdAt = LocalDateTime.now(); }
	
	@ManyToOne(fetch = FetchType.LAZY) // 연관된 엔티티(AppUser) 당장 가져오는 것이 아님
	@JoinColumn(name="FOLLOWR_ID", nullable = false)
	AppUser follower;	// 보는 사람
	
	@ManyToOne(fetch = FetchType.LAZY) // 실제 객체 사용하는 시점에서 쿼리 실행, 불필요한 Join 줄이기
	@JoinColumn(name="FOLLOWW_ID", nullable = false)
	AppUser followee;	// 보여지는 사람
	
	public Follow(AppUser follower, AppUser followee) {
		super();
		this.follower = follower;
		this.followee = followee;
	}	
}

/*

팔로워 : 나를 구독하는 사람
팔로잉 : 내가 한 구독

follower		followee
	1				2
	1				3
	2				1 (이렇게 하면 맞팔)

*/