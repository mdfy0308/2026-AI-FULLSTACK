-- 1. CRUD (SELECT Function-Date)
-- 2. CRUD (SELECT Function-Date  연습문제)
-- 3. CRUD (SELECT Function-IF , CASE)
-- 4. CRUD (SELECT Function-IF , CASE 연습문제)
-- ________________________________________________________________
-- ________________________________________________________________

use mbasic;

-- DDL : CREATE, ALTER, DROP
-- DML : insert, select, update, delete (#)
-- DCL : grant, revoke


-- ■ 1. CRUD (SELECT Function-Date)
-- select (1) - 기본문법
-- select (2) - 집계함수 
-- select (3) - 함수 ( Number, String, Date , if, case )
-- select (4) - join
-- select (5) - subquery

-- ==
-- select (3) - 함수 ( Number, String, Date , if, switch )

-- 1. 시스템의 현재 시각 조회 
select now(); -- '2026-05-26 14:37:24'
select current_time(); -- '14:37:43'
select current_date(); -- '2026-05-26'

-- 2.  요일  ( 0= Mon  , 1=Tue    6=Sun) 
select weekday(now()); -- 1(tue, 화요일) 월요일은 0부터 카운트
select weekday('2026-05-26'); -- 1

-- 3.  날짜형식  date_format(  날짜지정, '%Y-%m-%d %H:%i-%s' )
select date_format( '1993-03-12', "%Y-%m-%d" ); -- '1993-03-12'
select date_format( now(), "%Y-%m-%d" ); -- '2026-05-26'
select date_format( now(), "%Y-%m-%d %H:%i-%s" ); -- '2026-05-26 14:44-31'

-- 참고사항)
-- https://www.w3schools.com/sql/func_mysql_date_format.asp


-- 4.  100일전/ 100일 후  - date_add
select date_add( now(), Interval -10 day ); -- '2026-05-16 14:46:21'
select date_add( now(), Interval 10 day ); -- '2026-06-05 14:46:11'
select date_add( now(), Interval 3 hour); -- '2026-05-26 17:46:48'


-- YEAR MONTH DAY HOUR MINUTE SECOND
-- https://www.w3schools.com/sql/func_mysql_date_add.asp


-- 5. datediff  /  timestampdiff 
select datediff("2026-05-26", "2026-05-25"); -- '1' 일자로 표현
select timestampdiff(hour, "2026-05-26", "2026-05-25"); -- '-24' 시간


-- ■ 2. CRUD (SELECT Function-Date  연습문제)
-- >> 연습문제1)  date_userinfo

-- mysql>
-- mysql> desc date_userinfo;
-- +-------+--------------+------+-----+-------------------+-------------------+
-- | Field | Type         | Null | Key | Default           | Extra             |
-- +-------+--------------+------+-----+-------------------+-------------------+
-- | no    | int          | NO   |     | 0                 |                   |
-- | name  | varchar(100) | NO   |     | NULL              |                   |
-- | age   | int          | NO   |     | NULL              |                   |
-- | date  | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- +-------+--------------+------+-----+-------------------+-------------------+
-- 4 rows in set (0.01 sec)



desc date_userinfo;

create table date_userinfo(
	no int not null default 0,
    name varchar(100) not null,
    age int not null,
    date datetime default current_timestamp
);


-- mysql> select * from date_userinfo;
-- +----+------+-----+---------------------+
-- | no | name | age | date                |
-- +----+------+-----+---------------------+
-- |  1 | aaa  |  11 | 2022-12-30 00:00:00 |
-- |  2 | bbb  |  22 | 2022-11-30 00:00:00 |
-- |  3 | ccc  |  33 | 2022-10-30 00:00:00 |
-- |  4 | ddd  |  44 | 2022-09-30 00:00:00 |
-- +----+------+-----+---------------------+
-- 4 rows in set (0.00 sec)

select * from date_userinfo;

-- mysql>

-- > [001] '2022-11-01' 이전에 회원가입한 유저의 다음과 같이 데이터를 조회하시오
-- +------+---------------------+
-- | name | date                |
-- +------+---------------------+
-- | ccc  | 2022-10-30 00:00:00 |
-- | ddd  | 2022-09-30 00:00:00 |
-- +------+---------------------+
select name, date 
from date_userinfo 
where date < '2022-11-01';

show tables;

-- > [002] '12'월달에  회원가입한 유저에게 30일 연장 이벤트를 실시하려고 한다.
-- +------+---------------------+---------------------+
-- | name | date                | event               |
-- +------+---------------------+---------------------+
-- | aaa  | 2022-12-30 00:00:00 | 2023-01-29 00:00:00 |
-- +------+---------------------+---------------------+
select name, date, date_add(date, Interval 30 day) `event` 
from date_userinfo 
where date_format(date, "%m") = 12;

select name, date, date_add(date, Interval 30 day) `event` 
from date_userinfo 
where month(date) = 12;

-- > [003] 다음과 같이 유저의 가입날짜를 조회하시오.
-- +------+----------------+
-- | name | 가입날짜       |
-- +------+----------------+
-- | aaa  | 2022년12월30일 |
-- | bbb  | 2022년11월30일 |
-- | ccc  | 2022년10월30일 |
-- | ddd  | 2022년09월30일 |
-- +------+----------------+
-- 4 rows in set (0.01 sec)
select name, date_format(date, "%y년 %m월 %d일") `가입날짜` 
from date_userinfo;

select * from date_userinfo;


-- >> 연습문제2)  select_emp
-- > 1. 금일날짜를 출력하시오.
select now();

-- > 2.  금일과  이번년도 크리스마스  날짜사이의 일수 차이를 구하시오
select datediff("2026-12-25", now()); -- 213일

-- > 3. 현재날짜에서 5개월 더해 출력하시오.
select date_add(now(), Interval 5 month); -- '2026-10-26 14:58:59'

-- > 4. 현재날짜를 기준으로 가장 가까운 일요일의 날짜를 구하시오.
-- -- 0 = Monday, 1 = Tuesday, 2 = Wednesday, 3 = Thursday, 4 = Friday, 5 = Saturday, 6 = Sunday.
select now(); -- 오늘 날짜
select weekday(now());


select date_add( now(), interval (6 - weekday(now())) day );

-- 지난 일요일





-- ■ 3. CRUD (SELECT Function-IF , CASE)
-- mysql> desc control;
-- +-------+------+------+-----+---------+-------+
-- | Field | Type | Null | Key | Default | Extra |
-- +-------+------+------+-----+---------+-------+
-- | NO    | int  | YES  |     | NULL    |       |
-- +-------+------+------+-----+---------+-------+
-- 1 row in set (0.00 sec)

show tables; 

create table control(
	no int
);

desc control;
select * from control;

insert into control values (1), (2), (3);

-- mysql> select * from control;
-- +------+
-- | NO   |
-- +------+
-- |    1 |
-- |    2 |
-- |    3 |
-- +------+
-- 3 rows in set (0.00 sec)


-- if(조건, 참, 거짓)
-- 1이다, 1이 아니다
select no, if(no=1, '1이다', '1이 아니다') `1 상태`
from control;

-- 1보다 크다, 작다
select no, if(no>1, '1보다 크다', '1보다 작거나 같다') `1 작다, 크다`
from control;

-- case
select no, case
			when no =1 then '1이다.'
            when no =2 then '2이다.'
            when no =3 then '3이다.'
            else '1, 2, 3이 아니다.'
			end `상태`
from control;



-- ■ 4. CRUD (SELECT Function-IF , CASE 연습문제)

-- mysql> desc if_userinfo;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | YES  |     | 0       |                |
-- | sex   | char(1)      | YES  |     | NULL    |                |
-- | sns   | char(1)      | YES  |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 5 rows in set (0.00 sec)

create table if_userinfo select * from userinfo2;
desc if_userinfo;


-- mysql> select * from if_userinfo;
-- +----+--------+------+------+------+
-- | no | name   | age  | sex  | sns  |
-- +----+--------+------+------+------+
-- |  1 | first  |   11 | NULL | n    |
-- |  2 | second |   22 | m    | y    |
-- |  3 | third  |   33 | m    | y    |
-- |  4 | fourth |   44 | f    | n    |
-- |  5 | fifth  |   55 | f    | y    |
-- |  6 | sixth  |   66 | m    | n    |
-- +----+--------+------+------+------+
-- 6 rows in set (0.00 sec)
select * from if_userinfo;

insert into if_userinfo(name, age, sex, sns) values ('sixth', 66, 'm', 'n');


-- >> 연습문제1)
-- [question1]sns의 수신여부상태를 구하시오
-- +----+--------+-----+------+------+--------------+
-- | no | name   | age | sex  | sns  | 수신여부상태 |
-- +----+--------+-----+------+------+--------------+
-- |  1 | first  |  11 | NULL | n    | 수신거부     |
-- |  2 | second |  22 | m    | y    | 수신유지     |
-- |  3 | third  |  33 | m    | y    | 수신유지     |
-- |  4 | fourth |  44 | f    | n    | 수신거부     |
-- |  5 | fifth  |  55 | f    | y    | 수신유지     |
-- |  6 | sixth  |  66 | m    | n    | 수신거부     |
-- +----+--------+-----+------+------+--------------+

select *, if(sns='y', '수신유지', '수신거부') `수신여부상태` from if_userinfo;


-- [question2]나이가 19세 미만이면 미성년자, 성인을 구하시오.
-- +----+--------+-----+------+------+----------+
-- | no | name   | age | sex  | sns  | 성인여부 |
-- +----+--------+-----+------+------+----------+
-- |  1 | first  |  11 | NULL | n    | 미성년자 |
-- |  2 | second |  22 | m    | y    | 성인     |
-- |  3 | third  |  33 | m    | y    | 성인     |
-- |  4 | fourth |  44 | f    | n    | 성인     |
-- |  5 | fifth  |  55 | f    | y    | 성인     |
-- |  6 | sixth  |  66 | m    | n    | 성인     |
-- +----+--------+-----+------+------+----------+
-- 6 rows in set (0.00 sec)

select *, if(age < 19, '미성년자', '성인') `성인여부` from if_userinfo;




-- [question3]sns의 수신거부 숫자를 구하시오.
-- +---------------+
-- | sns수신거부수 |
-- +---------------+
-- |             3 |
-- +---------------+

select count(if(sns='n', 1, null)) `sns수신거부수` from if_userinfo;


-- == (2) case
-- [question1] emp 테이블을 이용하여
--  부서번호가 10이면 ACCOUNTING , 20이면 RESEARCH , 30이면 SALES을 다음과 같이 출력하시오.
-- +--------+--------+------------+
-- | ENAME  | DEPTNO | 부서이름   |
-- +--------+--------+------------+
-- | SMITH  |     20 | RESEARCH   |
-- | ALLEN  |     30 | SALES      |
-- | WARD   |     30 | SALES      |
-- | JONES  |     20 | RESEARCH   |
-- | MARTIN |     30 | SALES      |
-- | BLAKE  |     30 | SALES      |
-- | CLARK  |     10 | ACCOUNTING |
-- | SCOTT  |     20 | RESEARCH   |
-- | KING   |     10 | ACCOUNTING |
-- | TURNER |     30 | SALES      |
-- | ADAMS  |     20 | RESEARCH   |
-- | JAMES  |     30 | SALES      |
-- | FORD   |     20 | RESEARCH   |
-- | MILLER |     10 | ACCOUNTING |
-- +--------+--------+------------+
-- 14 rows in set (0.00 sec)

select * from emp;

select ename, deptno, 
case when deptno = 10 then 'ACCOUNTING'
	 when deptno = 20 then 'RESEARCH'
     when deptno = 30 then 'SALES'
	 end `부서이름`
from emp;



-- [question2] emp 테이블에서
-- JOB이 CLERK이면 판매원, SALESMAN이면 영업사원, 기타는 사원을  다음과 같이 출력하시오.
-- +--------+-----------+----------+
-- | ENAME  | JOB       | JOB2     |
-- +--------+-----------+----------+
-- | SMITH  | CLERK     | 판매원   |
-- | ALLEN  | SALESMAN  | 영업사원 |
-- | WARD   | SALESMAN  | 영업사원 |
-- | JONES  | MANAGER   | 사원     |
-- | MARTIN | SALESMAN  | 영업사원 |
-- | BLAKE  | MANAGER   | 사원     |
-- | CLARK  | MANAGER   | 사원     |
-- | SCOTT  | ANALYST   | 사원     |
-- | KING   | PRESIDENT | 사원     |
-- | TURNER | SALESMAN  | 영업사원 |
-- | ADAMS  | CLERK     | 판매원   |
-- | JAMES  | CLERK     | 판매원   |
-- | FORD   | ANALYST   | 사원     |
-- | MILLER | CLERK     | 판매원   |
-- +--------+-----------+----------+
-- 14 rows in set (0.00 sec)

select ename `ENAME`, job `JOB`, 
case when job = 'CLERK' then '판매원'
	 when job = 'SALESMAN' then '영업사원'
	 else '사원'
	end `JOB2`
from emp;


