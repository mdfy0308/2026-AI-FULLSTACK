[실습1]

mysql> show databases;
mysql> use mbasic
mysql> status -- 상태 확인

create table t1(  
    name varchar(100) not null, 
    age  int
  );

show tables; -- 테이블 목록 확인
+------------------+
| Tables_in_mbasic |
+------------------+
| t1               |
+------------------+

mysql> desc t1; -- 테이블 구조 확인
+-------+--------------+------+-----+---------+-------+
| Field | Type         | Null | Key | Default | Extra |
+-------+--------------+------+-----+---------+-------+
| name  | varchar(100) | NO   |     | NULL    |       |
| age   | int          | YES  |     | NULL    |       |
+-------+--------------+------+-----+---------+-------+

create table t11(
    no   int            not null, -- null을 허용하지 않음
    name varchar(30)    not null
);

create table t12(
    bookid int          not null,
    title  varchar(100) not null
);

mysql> show tables;
+------------------+
| Tables_in_mbasic |
+------------------+
| t1               |
| t11              |
| t12              |
+------------------+


※ 참고사항) not null 필수입력
mysql> insert into t1 (age) values (1);
-- ERROR 1364 (HY000): Field 'name' doesn't have a default value;

mysql> insert into t1 (name, age) values ('aaa', 1);
Query OK, 1 row affected (0.00 sec)

mysql> insert into t1 (name) values ('bbb');
Query OK, 1 row affected (0.00 sec)

mysql> select * from t1;
+------+------+
| name | age  |
+------+------+
| aaa  |    1 |
| bbb  | NULL |
+------+------+
2 rows in set (0.00 sec)


[실습2] auto_increment (숫자 자동증가), primary key
-- 필드명 / 자료형 / 옵션

create table t2(
    jumin int not null auto_increment primary key,
    name varchar(100) not null,
    age int
);


-- ※ 참고사항)
insert into  t2 (name, age)  values ('aaa' , 1);   -- 숫자자동증가
insert into  t2 (name)  values ('bbb');            -- 숫자자동증가
insert into  t2 (jumin, name, age)  values (1 , 'ccc' , 1);  -- error 기본키
insert into  t2 (jumin, name, age)  values (3 , 'ccc' , 1);  

mysql> select * from t2;
+-------+------+------+
| jumin | name | age  |
+-------+------+------+
|     1 | aaa  |    1 |
|     2 | bbb  | NULL |
|     3 | aaa  |    1 |  -- aaa, 1 / aaa,1 구분을 해줄수 있는 필드는  jumin  1,3  
+-------+------+------+
2 rows in set (0.00 sec)

