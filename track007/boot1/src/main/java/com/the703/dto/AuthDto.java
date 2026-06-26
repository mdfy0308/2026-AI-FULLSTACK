package com.the703.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString 
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {
	
	private Integer authId;
	private String email;
	private String auth;
	private Integer appUserId;

}


/*

create table authorities(
AUTH_ID NUMBER NOT NULL,
EMAIL VARCHAR2(255),
AUTH VARCHAR2(255) NOT NULL,
APP_USER_ID NUMBER
);

create sequence authorities_seq;


*/