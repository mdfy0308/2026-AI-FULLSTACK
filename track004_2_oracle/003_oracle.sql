--1. 테이블 / 시퀀스
create table appuser(
    APP_USER_ID NUMBER NOT NULL,
    EMAIL VARCHAR2(100) NOT NULL,
    PASSWORD VARCHAR2(100),
    MBTI_TYPE_ID NUMBER,
    CREATED_AT DATE DEFAULT sysdate,
    UFILE VARCHAR2(255),
    MOBILE VARCHAR2(50),
    NICKNAME VARCHAR2(50),
    PROVIDER VARCHAR2(50) NOT NULL,
    PROVIDER_ID VARCHAR2(100)
);

drop sequence appuser_seq;
create sequence appuser_seq;

create table authorities(
    AUTH_ID NUMBER NOT NULL,
    EMAIL VARCHAR2(255),
    AUTH VARCHAR2(255) NOT NULL,
    APP_USER_ID NUMBER
);

create sequence authorities_seq;

alter table appuser modify CREATED_AT DATE DEFAULT sysdate;

commit;




-- 2.sql
-- 1) 회원가입
insert into appuser(APP_USER_ID, EMAIL, PASSWORD, MBTI_TYPE_ID, UFILE, MOBILE, NICKNAME, PROVIDER, PROVIDER_ID)
values(appuser_seq.nextval, 'first@gmail.com', '111', 1, '1.png', '01012345678', 'first', 'the703', 't7-1');


--2) 로그인
-- 이메일로 이메일, 비밀번호, 권한
select u.email, u.password, a.auth
from appuser u left join authorities a on u.email=a.email
where u.email = 'first@gmail.com'; -- #{email}

-- 3) 이메일로 유저찾기
select * from appuser where email = 'first@gmail.com'; -- #{email}


-- 4) 이메일로 중복 검사
select count(*) from appuser where email='first@gmail.com';


-- 5) 회원 수정
update appuser
set password='2222', 
mbti_type_id=2, 
ufile='2.png', 
nickname='second', 
mobile='01022223333', 
provider='naver', 
provider_id='n-1'
where app_user_id=1;


-- 6) 회원 삭제
delete from appuser where app_user_id=1;


-- 7) 권한 삽입
insert into authorities(AUTH_ID, EMAIL, AUTH) values (authorities_seq.nextval, 'first@gmail.com', 'ROLE_MEMBER');


-- 8) 권한 삭제
delete from authorities where email = 'first@gmail.com';





