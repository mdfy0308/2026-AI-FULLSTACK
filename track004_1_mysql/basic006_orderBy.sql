-- 1. 복습문제
-- 2. CRUD (SELECT ORDER BY , LIMIT)
-- 3. CRUD (SELECT 연습문제)
 
-- ________________________________________________________________
-- ________________________________________________________________

-- ■ 진행1. CRUD 복습문제
-- > 복습문제
--  다음의 결과가나오게 조회하시오.
-- emp 테이블에서
-- 추가수당(comm) 이 없고
-- 상급자(mgr)은 존재하며
-- 직책(JOB) 'MANAGER', 'CLERK' 중에서
-- 사원이름(ename)의 두번째 글자가 L이아닌
-- 사원데이터를  조회하시오

use mbasic;
show tables;

select * from emp;
select * from emp where comm is null and mgr is not null and job in ('MANAGER', 'CLERK') and ename not like '_L%';

set sql_safe_updates = 0;


-- SELECT   검색필드1, 검색필드2,,,
-- FROM    테이블명
-- WHERE where_condition
-- ORDER BY   [ASC | DESC]
-- LIMIT offset;

-- 준비 :  userinfo 테이블있는지 확인
-- userinfo 복사해서 select_userinfo 만들기
-- mysql> desc select_userinfo;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | YES  |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.02 sec)

select * from userinfo;
create table select_userinfo select * from userinfo;

alter table select_userinfo modify no int not null auto_increment primary key; -- 기본 키, 숫자 자동 증가
insert into select_userinfo(no, name, age) values (5, 'first', 55);
insert into select_userinfo(no, name, age) values (6, 'third', 66);
insert into select_userinfo(no, name, age) values (7, 'seven', null);

desc select_userinfo; -- 테이블 구조 확인
select * from select_userinfo; -- 데이터 확인

-- mysql> select * from select_userinfo;
-- +----+--------+------+
-- | no | name   | age  |
-- +----+--------+------+
-- |  1 | first  |   11 |
-- |  2 | second |   22 |
-- |  3 | third  |   33 |
-- |  4 | fourth |   44 |
-- |  5 | first  |   55 |
-- |  6 | third  |   66 |
-- |  7 | seven  | NULL |
-- +----+--------+------+
-- 7 rows in set (0.04 sec)

-- mysql>
-- Q1. 나이가 많은 순으로 출력
select * from select_userinfo order by age desc; -- 내림차순(많은 순으로)
select * from select_userinfo order by age asc; -- 오름차순(적은 순으로), null 부터
 
-- Q2. 나이가 많은 순으로 2명 출력
select * from select_userinfo order by age desc limit 0, 2; -- 0번째부터 2개
select * from select_userinfo order by age desc limit 1, 3; -- 1번째부터 3개


-- 실습 1.  emp테이블을   emp이름으로 복사하시오. (있다면 pass)
create table select_emp select * from emp;

-- 실습 2.  JOB이 'SALESMAN'인 레코드를 조회하시오.
-- +-------+--------+----------+------+------------+------+------+--------+
-- | empno | ename  | job      | mgr  | hiredate   | sal  | comm | deptno |
-- +-------+--------+----------+------+------------+------+------+--------+
-- |  7499 | ALLEN  | SALESMAN | 7698 | 1981-02-20 | 1600 |  300 |     30 |
-- |  7521 | WARD   | SALESMAN | 7698 | 1981-02-22 | 1250 |  500 |     30 |
-- |  7654 | MARTIN | SALESMAN | 7698 | 1981-09-28 | 1250 | 1400 |     30 |
-- |  7844 | TURNER | SALESMAN | 7698 | 1981-09-08 | 1500 |    0 |     30 |
-- +-------+--------+----------+------+------------+------+------+--------+
-- 4 rows in set (0.00 sec)

select * from select_emp where job = 'SALESMAN';

-- 실습 3. emp 테이블에서 ename, mgr, sal  필드를 조회하시오.     
-- +--------+------+------+
-- | ename  | mgr  | sal  |
-- +--------+------+------+
-- | SMITH  | 7902 |  800 |
-- | ALLEN  | 7698 | 1600 |
-- | WARD   | 7698 | 1250 |
-- | JONES  | 7839 | 2975 |
-- | MARTIN | 7698 | 1250 |
-- | BLAKE  | 7839 | 2850 |
-- | CLARK  | 7839 | 2450 |
-- | SCOTT  | 7566 | 3000 |
-- | KING   | NULL | 5000 |
-- | TURNER | 7698 | 1500 |
-- | ADAMS  | 7788 | 1100 |
-- | JAMES  | 7698 |  950 |
-- | FORD   | 7566 | 3000 |
-- | MILLER | 7782 | 1300 |
-- +--------+------+------+
-- 14 rows in set (0.00 sec)

select ename, mgr, sal from select_emp;


-- 실습 4. emp 테이블에서 JOB이 'SALESMAN'인 레코드의  ename, mgr, sal  필드를 조회하시오.     
-- +--------+------+------+
-- | ename  | mgr  | sal  |
-- +--------+------+------+
-- | ALLEN  | 7698 | 1600 |
-- | WARD   | 7698 | 1250 |
-- | MARTIN | 7698 | 1250 |
-- | TURNER | 7698 | 1500 |
-- +--------+------+------+
-- 4 rows in set (0.00 sec)

select ename, mgr, sal from select_emp where job='SALESMAN';

 
-- 실습 5. emp 테이블에서  급여(SAL)가 높은 순서로  조회하시오.     
-- +-------+--------+-----------+------+------------+------+------+--------+
-- | empno | ename  | job       | mgr  | hiredate   | sal  | comm | deptno |
-- +-------+--------+-----------+------+------------+------+------+--------+
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |
-- +-------+--------+-----------+------+------------+------+------+--------+
-- 14 rows in set (0.00 sec)

 -- sal을 기준으로 내림차순 정렬. 
select * from select_emp order by sal desc;
 

-- 실습 6. emp 테이블에서  Job기준으로 올림차순, 같으면 sal을 기준으로 내림차순으로 정렬하시오.
-- +-------+--------+-----------+------+------------+------+------+--------+
-- | empno | ename  | job       | mgr  | hiredate   | sal  | comm | deptno |
-- +-------+--------+-----------+------+------------+------+------+--------+
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |
-- +-------+--------+-----------+------+------------+------+------+--------+
-- 14 rows in set (0.00 sec)  
 -- Job기준으로 올림차순, 같으면 sal을 기준으로 내림차순정렬 
 
 select * from select_emp order by job asc, sal desc; 


-- 실습 7. emp 테이블에서     sal가 2000이상인 레코드 들중에  ename, sal, empno필드를  empno를 기준으로 내림차순 정렬하시오. 
-- +-------+------+-------+
-- | ename | sal  | empno |
-- +-------+------+-------+
-- | FORD  | 3000 |  7902 |
-- | KING  | 5000 |  7839 |
-- | SCOTT | 3000 |  7788 |
-- | CLARK | 2450 |  7782 |
-- | BLAKE | 2850 |  7698 |
-- | JONES | 2975 |  7566 |
-- +-------+------+-------+
-- 6 rows in set (0.00 sec)
-- sal가 2000이상인 레코드 들중에 ename, sal, select_userinfono를
-- 가져오데 empno를 기준으로 내림차순 정렬 

select ename, sal, empno 
from select_emp 
where sal >= 2000
order by empno desc;

    
-- 실습 8. emp 테이블에서    job을 기준으로 중복행은 제거하여 같은것은 한번만 나오게 출력하시오
-- +-----------+
-- | job       |
-- +-----------+
-- | CLERK     |
-- | SALESMAN  |
-- | MANAGER   |
-- | ANALYST   |
-- | PRESIDENT |
-- +-----------+
-- 5 rows in set (0.00 sec)

select distinct job from select_emp;

    
-- 실습 9.  emp 테이블에서    empno ( 사원번호 ) , ename ( 이름) , job ( 담당 업무)  필드를 
-- 다음과 같이 필드명을 바꿔(별명으로) 출력하시오.
-- +----------+--------+-----------+
-- | 사원번호    | 이름    | 담당 업무 |
-- +----------+--------+-----------+
-- |     7369 | SMITH  | CLERK     |
-- |     7499 | ALLEN  | SALESMAN  |
-- |     7521 | WARD   | SALESMAN  |
-- |     7566 | JONES  | MANAGER   |
-- |     7654 | MARTIN | SALESMAN  |
-- |     7698 | BLAKE  | MANAGER   |
-- |     7782 | CLARK  | MANAGER   |
-- |     7788 | SCOTT  | ANALYST   |
-- |     7839 | KING   | PRESIDENT |
-- |     7844 | TURNER | SALESMAN  |
-- |     7876 | ADAMS  | CLERK     |
-- |     7900 | JAMES  | CLERK     |
-- |     7902 | FORD   | ANALYST   |
-- |     7934 | MILLER | CLERK     |
-- +----------+--------+-----------+
-- 14 rows in set (0.00 sec)
--  * 컬럼명에 별칭주기(as) 

select empno as `사원번호`, ename as `이름`, job as `담당 업무` from select_emp;

 

-- 실습 10 emp 테이블에서 급여를 기준으로 오름차순으로 정렬하여 조회하시오.
-- +-------+--------+-----------+------+------------+------+------+--------+
-- | empno | ename  | job       | mgr  | hiredate   | sal  | comm | deptno |
-- +-------+--------+-----------+------+------------+------+------+--------+
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
-- +-------+--------+-----------+------+------------+------+------+--------+
-- 14 rows in set (0.00 sec)

select * from select_emp order by sal asc;


-- 실습 11 emp 테이블에서 급여를 기준으로 내차순으로 정렬하여 조회하시오.
-- +-------+--------+-----------+------+------------+------+------+--------+
-- | empno | ename  | job       | mgr  | hiredate   | sal  | comm | deptno |
-- +-------+--------+-----------+------+------------+------+------+--------+
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |
-- +-------+--------+-----------+------+------------+------+------+--------+
-- 14 rows in set (0.00 sec)
 select * 
 from select_emp 
 order by sal desc;

-- 실습 12 emp테이블에서 1순위는 부서번호를 (deptno)를 기준으로 오차순, 그중에서도 급여를기준으로(sal) 내림차순으로 정렬하시오.
-- +-------+--------+-----------+------+------------+------+------+--------+
-- | empno | ename  | job       | mgr  | hiredate   | sal  | comm | deptno |
-- +-------+--------+-----------+------+------------+------+------+--------+
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |
-- +-------+--------+-----------+------+------------+------+------+--------+
-- 14 rows in set (0.00 sec)
 
select * 
from select_emp
order by deptno asc, sal desc;


-- 실습 13. 다음의 결과가나오게 조회하시오.
-- +-------------+---------------+-----------+---------+------------+--------+------------+---------------+
-- | EMPLOYEE_NO | EMPLOYEE_NAME | JOB       | MANAGER | HIREDATE   | SALARY | COMMISSION | DEPARTMENT_NO |
-- +-------------+---------------+-----------+---------+------------+--------+------------+---------------+
-- |        7499 | ALLEN         | SALESMAN  |    7698 | 1981-02-20 |   1600 |        300 |            30 |
-- |        7698 | BLAKE         | MANAGER   |    7839 | 1981-05-01 |   2850 |       NULL |            30 |
-- |        7900 | JAMES         | CLERK     |    7698 | 1981-12-03 |    950 |       NULL |            30 |
-- |        7654 | MARTIN        | SALESMAN  |    7698 | 1981-09-28 |   1250 |       1400 |            30 |
-- |        7844 | TURNER        | SALESMAN  |    7698 | 1981-09-08 |   1500 |          0 |            30 |
-- |        7521 | WARD          | SALESMAN  |    7698 | 1981-02-22 |   1250 |        500 |            30 |
-- |        7876 | ADAMS         | CLERK     |    7788 | 1987-05-23 |   1100 |       NULL |            20 |
-- |        7902 | FORD          | ANALYST   |    7566 | 1981-12-03 |   3000 |       NULL |            20 |
-- |        7566 | JONES         | MANAGER   |    7839 | 1981-04-02 |   2975 |       NULL |            20 |
-- |        7788 | SCOTT         | ANALYST   |    7566 | 1987-04-19 |   3000 |       NULL |            20 |
-- |        7369 | SMITH         | CLERK     |    7902 | 1980-12-17 |    800 |       NULL |            20 |
-- |        7782 | CLARK         | MANAGER   |    7839 | 1981-06-09 |   2450 |       NULL |            10 |
-- |        7839 | KING          | PRESIDENT |    NULL | 1981-11-17 |   5000 |       NULL |            10 |
-- |        7934 | MILLER        | CLERK     |    7782 | 1982-01-23 |   1300 |       NULL |            10 |
-- +-------------+---------------+-----------+---------+------------+--------+------------+---------------+
-- 14 rows in set (0.00 sec)

select empno `EMPLOYEE_NO`, ename `EMPLOYEE_NAME`, job `JOB`, mgr `MANAGER`, 
	   hiredate `HIREDATE`, sal `SALARY`, comm `COMMISSION`, deptno `DEPARTMENT_NO` 
from select_emp
order by deptno desc, ename asc;
