## 1. Mysql?

#### 1. mysql why?
1. DBMS
    - Database Management System
    - 데이터베이스를 관리해주는 시스템
2. Database
    - Data + Base
    - Data 1. 데이터(수집된 사실, 값) 2. 정보(의미 부여)
    - Data(의미를 제공하는 데이터) + Base(체계와 규격을 가진 집합)
```
    Q1. 다음 빈칸을 채우시오
    1. (#1 데이터)는  수집된 사실이나 값을 의미하고
    2. (#2 정보 )는  데이터들 중에서 의미를 제공하는 데이터를 의미
```
3. Database 종류
    - Oracle, Mysql, MSSql


#### 2. mysql Setting

1. MYSQL 다운로드
    https://dev.mysql.com/
    - Download
    - MySQL Community Server
2. MYSQL 설치
3. MYSQL 환경설정 (1) path
4. MYSQL 환경설정 (2) utf-8


## 2. RDBMS
1. RDBMS (Relational Database Management System)
- 관계형 데이터베이스 관리 시스템
- 테이블들의 관계

2. RDBMS 구성요소
- 개체 (Entity : Table)
- 관계 (Relationship)
- 속성 (Attribute : 필드)

※ 스키마 - 데이터베이스 구조와 제약조건을 명세정의
    외부스키마 = 사용자뷰
    개념스키마 = 전체적인뷰
    내부스키마 = 저장스키마

※ 데이터베이스 설계단계
    #1. 개념적 설계 - 요구사항분석 후 개념적 설계 ERD
    (집을 어떻게 지을지? 방은 몇 개, 주방은 어디, 거실의 크기는...)
    #2. 논리적 설계 - ERD를 이용하여 데이터베이스 스키마를 설계
    (방 = 테이블, 사람 = 엔티티, 관계 = 외래키)
    #3. 물리적 설계 - 테이블 저장구조 설계 ( mysql,oracle,,,,)
    (실제 건축 자재로 만들기 - mysql, oracle)

3. 데이터베이스 언어
    1) 정의어 (DDL) = Data Definition Language (데이터 정의어)
        CREAETE, ALTER, DROP → CAD
    2) 조작어 (DML) = Data Manipulation Language (데이터 조작어)
        INSERT, SELECT, UPDATE, DELETE → CRUD
    3) 제어어 (DCL) = Data Control Language (데이터 제어어)
        GRANT, REVOKE


4. [실습] Database 만들기

1. 만들기       : create database DB명;
2. 확 인       : show databases;
3. 삭제(복구X)  : drop database DB명;
4. 사용하기     : use DB명;

1) 접속 : mysql -uroot -p


5. [연습]
1. db명 : test, mbasic, db703 3개 db만들기
2. db 만들어진것 확인
3. db703 삭제


---

## 3. 테이블

1. RDBMS (Relational Database Management System)
- 관계형 데이터베이스 관리 시스템
- 테이블의 관계
- 속성(필드) 연결

2. 테이블 만들기(집안의 방, 가방 안의 분류표)
DDL (정의: create, alter, drop), 
DML (조작: insert, select, update, delete), 
DCL (제어: grant, revoke)

```
CREATE TABLE table명 (
    필드1 자료형 옵션,
    필드2 자료형 옵션
);
```

자료형 : 
    1. 숫자 : int(정수), double(실수)
    2. 문자 : char(고정, Y/N), varchar(가변, abc, abcd)
    3. 날짜 : data, datetime

옵션 :
    필수 입력 - not null
    숫자 자동 증가 - auto_increment
    기본키 - primary key

※ ERROR 1046 (3D000): No database selected
use db명