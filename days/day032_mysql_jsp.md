### ■1. MYSQL

1) WEB BASIC - HTML + CSS + JS (화면단)
2) JAVA (프로그래밍)
3) MYSQL/ORACLE (DB)
4) JSP (html + java)


##### TABLE
##### ALTER



---


### ■2. JSP

### 1. web
- 클라이언트 ↔ 서버
- WS vs WAS
    1. WS (WEB Server) : 정적 콘텐츠(html, css, js) 웹브라우저 제공
        예) Apache

    2. WAS (WEB Application Server) : 동적콘텐츠
        - 브라우저와 DBMS 사이에서 동작하는 미들웨어
        예) Apache + Tomcat

    3. Tomcat
        >> Http request( 요청) > Catalina(해결사) > Context > Servlet > response

        3-1) http request(요청)
        3-2) Coyte 가  해결사찾기  : http요청을 처리할 웹어플리케이션(context) 
                                   web.xml 파일내용을 참고해서 요청전달.
        3-3) Catalina (Servlet)  : 해결사   
        3-4) Jasper (Jsp Engine) : java+html 페이지 요청처리 응답(response)

        C:\sujeong\2026-AI-FULLSTACK\track005_jsp\tomcat9.0\apache-tomcat-9.0.100\work\Catalina\localhost\jsp2026\org\apache\jsp

---


### ■3. 복습 문제

1.  데이터베이스 언어
-- DDL(  정의어  )  CREATE, ALTER, DROP 
-- DML(  조작어  )    INSERT, SELECT, UPDATE, DELETE 
-- DCL(  제어어  )    GRANT, REVOKE


2. 다음과 같이 테이블준비
-- DB명     : mbasic    
-- 테이블명: userinfo
-- 필드1 -  필수입력  no    ,  숫자자동증가, 기본키      정수형
-- 필드2 -  필수입력  name     가변형문자열(100)
-- 필드3 -  필수입력  age      정수형
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(100) | NO   |     | NULL    |                |
| age   | int          | NO   |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)


create table userinfo(
    no int not null auto_increment primary key,
    name varchar(100) not null,
    age int not null
);


3. 다음을 수정  
-- 1. 이메일 필드 추가(add)       email varchar(100)
alter table userinfo add email varchar(100);

-- 2. 이메일 필드 수정(change)   email을 email2로  자료형은 varchar(50) 으로 
alter table userinfo change email email2 varchar(50);

-- 3. 이메일 필드 수정(modify)   email2의 자료형을 varchar(100) 으로 
alter table userinfo modify email2 varchar(100);

-- 4. 이메일 필드 삭제(drop)   
alter table userinfo drop email2;