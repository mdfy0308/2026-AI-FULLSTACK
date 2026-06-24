package com.the703.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data → 필요없는 컨텐츠도 같이 가져옴(충돌 위험)

//아래처럼 필요한 것만 이용할 수 있음
@Getter @Setter @ToString 
@NoArgsConstructor
@AllArgsConstructor

public class Sboard2Dto {
	
	private int id;
	private int appUserId;
	private String btitle;
	private String bcontent;
	private String bpass;
	private String bfile;
	private int bhit;
	private String bip;
	private String createdAt;
	
}


/*

create table sboard2(
ID NUMBER NOT NULL,
APP_USER_ID NUMBER NOT NULL,
BTITLE VARCHAR2(1000) NOT NULL,
BCONTENT CLOB NOT NULL,
BPASS VARCHAR2(255) NOT NULL,
BFILE VARCHAR2(255) default 'the703.png',
BHIT NUMBER DEFAULT 0,
BIP VARCHAR2(255) NOT NULL,
CREATED_AT DATE default sysdate
);

*/