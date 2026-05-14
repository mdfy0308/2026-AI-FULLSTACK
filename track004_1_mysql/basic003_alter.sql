1. 데이터베이스 언어
- DDL : create, alter(#), drop → CAD

ALTER TABLE 테이블명
     ADD     추가필드명       자료형 옵션       [FIRST | AFTER col_name]
     DROP    삭제필드명       
     CHANGE  이전필드명       새로운필드명      자료형  옵션
     MODIFY  수정할필드명     자료형             옵션
     RENAME  새로운테이블명


#1) 필드 추가
      alter table userinfo add uno int not null;
      alter table userinfo add uno2 int first; -- 맨 앞에
      alter table userinfo add email varchar(100) after name; -- name 뒤에

      mysql> desc userinfo;
      +-------+--------------+------+-----+---------+----------------+
      | Field | Type         | Null | Key | Default | Extra          |
      +-------+--------------+------+-----+---------+----------------+
      | uno2  | int          | YES  |     | NULL    |                |
      | no    | int          | NO   | PRI | NULL    | auto_increment |
      | name  | varchar(100) | NO   |     | NULL    |                |
      | email | varchar(100) | YES  |     | NULL    |                |
      | age   | int          | NO   |     | NULL    |                |
      | uno   | int          | NO   |     | NULL    |                |
      +-------+--------------+------+-----+---------+----------------+

#2) 필드 삭제
      alter table userinfo drop uno2;
      alter table userinfo drop uno;

#3) 필드 수정(change) - 필드명, 자료형 옵션 수정
      alter table userinfo change email etc varchar(100);
      

#4) 필드 수정(modify) - 자료형 옵션 수정 (add, drop, change | modify)
      alter table userinfo modify email varchar(100) not null;
      alter table userinfo modify etc varchar(300);
      alter table userinfo modify age int;


#5) 테이블명 수정 (add, drop, change | modify, rename )
      alter table userinfo rename users;

      mysql> desc users;
      +-------+--------------+------+-----+---------+----------------+
      | Field | Type         | Null | Key | Default | Extra          |
      +-------+--------------+------+-----+---------+----------------+
      | no    | int          | NO   | PRI | NULL    | auto_increment |
      | name  | varchar(100) | NO   |     | NULL    |                |
      | email | varchar(100) | NO   |     | NULL    |                |
      | age   | int          | YES  |     | NULL    |                |
      | etc   | varchar(300) | YES  |     | NULL    |                |
      +-------+--------------+------+-----+---------+----------------+


1) alter 문법
https://dev.mysql.com/doc.refman/8.0/en/table.html

ALTER TABLE tbl_name
    [alter_option [, alter_option] ...]
    [partition_options]

alter_option: {
    table_options
  | ADD [COLUMN] col_name column_definition
        [FIRST | AFTER col_name]
  | ADD [COLUMN] (col_name column_definition,...)
  | ADD {INDEX | KEY} [index_name]
        [index_type] (key_part,...) [index_option] ...
  | ADD {FULLTEXT | SPATIAL} [INDEX | KEY] [index_name]
        (key_part,...) [index_option] ...
  | ADD [CONSTRAINT [symbol]] PRIMARY KEY
        [index_type] (key_part,...)
        [index_option] ...
  | ADD [CONSTRAINT [symbol]] UNIQUE [INDEX | KEY]
        [index_name] [index_type] (key_part,...)
        [index_option] ...
  | ADD [CONSTRAINT [symbol]] FOREIGN KEY
        [index_name] (col_name,...)
        reference_definition
  | ADD [CONSTRAINT [symbol]] CHECK (expr) [[NOT] ENFORCED]
  | DROP {CHECK | CONSTRAINT} symbol
  | ALTER {CHECK | CONSTRAINT} symbol [NOT] ENFORCED
  | ALGORITHM [=] {DEFAULT | INSTANT | INPLACE | COPY}
  | ALTER [COLUMN] col_name {
        SET DEFAULT {literal | (expr)}
      | SET {VISIBLE | INVISIBLE}
      | DROP DEFAULT
    }
  | ALTER INDEX index_name {VISIBLE | INVISIBLE}
  | CHANGE [COLUMN] old_col_name new_col_name column_definition
        [FIRST | AFTER col_name]
  | [DEFAULT] CHARACTER SET [=] charset_name [COLLATE [=] collation_name]
  | CONVERT TO CHARACTER SET charset_name [COLLATE collation_name]
  | {DISABLE | ENABLE} KEYS
  | {DISCARD | IMPORT} TABLESPACE
  | DROP [COLUMN] col_name
  | DROP {INDEX | KEY} index_name
  | DROP PRIMARY KEY
  | DROP FOREIGN KEY fk_symbol
  | FORCE
  | LOCK [=] {DEFAULT | NONE | SHARED | EXCLUSIVE}
  | MODIFY [COLUMN] col_name column_definition
        [FIRST | AFTER col_name]
  | ORDER BY col_name [, col_name] ...
  | RENAME COLUMN old_col_name TO new_col_name
  | RENAME {INDEX | KEY} old_index_name TO new_index_name
  | RENAME [TO | AS] new_tbl_name
  | {WITHOUT | WITH} VALIDATION
}

partition_options:
    partition_option [partition_option] ...

partition_option: {
    ADD PARTITION (partition_definition)
  | DROP PARTITION partition_names
  | DISCARD PARTITION {partition_names | ALL} TABLESPACE
  | IMPORT PARTITION {partition_names | ALL} TABLESPACE
  | TRUNCATE PARTITION {partition_names | ALL}
  | COALESCE PARTITION number
  | REORGANIZE PARTITION partition_names INTO (partition_definitions)
  | EXCHANGE PARTITION partition_name WITH TABLE tbl_name [{WITH | WITHOUT} VALIDATION]
  | ANALYZE PARTITION {partition_names | ALL}
  | CHECK PARTITION {partition_names | ALL}
  | OPTIMIZE PARTITION {partition_names | ALL}
  | REBUILD PARTITION {partition_names | ALL}
  | REPAIR PARTITION {partition_names | ALL}
  | REMOVE PARTITIONING
}

key_part: {col_name [(length)] | (expr)} [ASC | DESC]

index_type:
    USING {BTREE | HASH}

index_option: {
    KEY_BLOCK_SIZE [=] value
  | index_type
  | WITH PARSER parser_name
  | COMMENT 'string'
  | {VISIBLE | INVISIBLE}
}

table_options:
    table_option [[,] table_option] ...

table_option: {
    AUTOEXTEND_SIZE [=] value
  | AUTO_INCREMENT [=] value
  | AVG_ROW_LENGTH [=] value
  | [DEFAULT] CHARACTER SET [=] charset_name
  | CHECKSUM [=] {0 | 1}
  | [DEFAULT] COLLATE [=] collation_name
  | COMMENT [=] 'string'
  | COMPRESSION [=] {'ZLIB' | 'LZ4' | 'NONE'}
  | CONNECTION [=] 'connect_string'
  | {DATA | INDEX} DIRECTORY [=] 'absolute path to directory'
  | DELAY_KEY_WRITE [=] {0 | 1}
  | ENCRYPTION [=] {'Y' | 'N'}
  | ENGINE [=] engine_name
  | ENGINE_ATTRIBUTE [=] 'string'
  | INSERT_METHOD [=] { NO | FIRST | LAST }
  | KEY_BLOCK_SIZE [=] value
  | MAX_ROWS [=] value
  | MIN_ROWS [=] value
  | PACK_KEYS [=] {0 | 1 | DEFAULT}
  | PASSWORD [=] 'string'
  | ROW_FORMAT [=] {DEFAULT | DYNAMIC | FIXED | COMPRESSED | REDUNDANT | COMPACT}
  | SECONDARY_ENGINE_ATTRIBUTE [=] 'string'
  | STATS_AUTO_RECALC [=] {DEFAULT | 0 | 1}
  | STATS_PERSISTENT [=] {DEFAULT | 0 | 1}
  | STATS_SAMPLE_PAGES [=] value
  | TABLESPACE tablespace_name [STORAGE {DISK | MEMORY}]
  | UNION [=] (tbl_name[,tbl_name]...)
}


-- 1. 테이블 준비

create table userinfo(
    no int not null primary key auto_increment,
    name varchar(100) not null,
    age int not null
);

mysql> desc userinfo;
 +-------+--------------+------+-----+---------+----------------+
 | Field | Type         | Null | Key | Default | Extra          |
 +-------+--------------+------+-----+---------+----------------+
 | no    | int          | NO   | PRI | NULL    | auto_increment |
 | name  | varchar(100) | NO   |     | NULL    |                |
 | age   | int          | NO   |     | NULL    |                |
 +-------+--------------+------+-----+---------+----------------+


--------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------


>>>> 연습문제1)
[001]  다음과 같이 테이블을 준비하시오    >> alter_coffee
mysql> desc alter_coffee;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cno    | int(11)     | YES  |     | NULL    |       |
| cname  | varchar(20) | YES  |     | NULL    |       |
| cprice | int(11)     | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

create table alter_coffee(
    cno int,
    cname varchar(20),
    cprice int
);


[002] 다음과 같이 DB와 테이블을 수정하시오  [TABLE명 : alter_coffee] -  ALTER TABLE
연습문제1) cno, cname,cprice필드를 ( not null )으로 수정
    alter table alter_coffee modify cno int not null;
    alter table alter_coffee modify cname varchar(20) not null;
    alter table alter_coffee modify cprice int not null;

연습문제2) 쿠폰필드  cgift    문자열고정(10)  미필수로 추가
    alter table alter_coffee add cgift varchar(10);

연습문제3) 쿠폰필드  cgift를  ccoupon으로 바꾸기
    alter table alter_coffee change cgift ccoupon varchar(10);

연습문제4) 쿠폰필드 ccoupon삭제
    alter table alter_coffee drop ccoupon;

연습문제5) cno를 cprice뒤로이동
    alter table alter_coffee change cno cno int after cprice;

연습문제6) cno를 맨위로
    alter table alter_coffee change cno cno int first;

연습문제7) cno를 primary key 추가
    alter table alter_coffee2 modify cno int auto_increment primary key;

연습문제8) alter_coffee테이블의 이름을 alter_coffee2로 바꾸기
    alter table alter_coffee rename alter_coffee2;

연습문제9) 다음과 같이 최종본으로 테이블만들기

mysql> desc alter_coffee2;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| cno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| cname  | varchar(20) | NO   |     | NULL    |                |
| cprice | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)



----------------------------------------------------------------
----------------------------------------------------------------

[milk 테이블]

1. milk 테이블의 mprice 필드를 NULL 허용으로 변경하시오.
    alter table milk modify mprice int;

2. milk 테이블에 mdate 필드를 DATE 타입으로 추가하시오.
    alter table milk add mdate date;

3. milk 테이블의 mdate 필드 이름을 mexpire로 변경하시오.
    alter table milk change mdate mexpire date;

4. milk 테이블의 mexpire 필드를 삭제하시오.
    alter table milk drop mexpire;

5. milk 테이블의 mno 필드를 mprice 뒤로 이동하시오.
    alter table milk change mno mno int after mprice;

6. milk 테이블의 mno 필드를 맨 위로 이동하시오.
    alter table milk change mno mno int first;

7. milk 테이블의 이름을 milk2로 변경하시오.
    alter table milk rename milk2;

    mysql> desc milk2;
    +--------+-------------+------+-----+---------+-------+
    | Field  | Type        | Null | Key | Default | Extra |
    +--------+-------------+------+-----+---------+-------+
    | mno    | int         | NO   | PRI | NULL    |       |
    | mname  | varchar(50) | NO   |     | NULL    |       |
    | mprice | int         | YES  |     | NULL    |       |
    | mnum   | int         | NO   |     | NULL    |       |
    | mtotal | int         | NO   |     | NULL    |       |
    +--------+-------------+------+-----+---------+-------+
    5 rows in set (0.00 sec)


[milk 테이블]

8. milk 테이블의 mprice 필드에 기본값(Default) 1000을 설정하시오.
    alter table milk2 alter mprice set default 1000;

9. milk 테이블의 mnum 필드에 0 이상만 입력되도록 CHECK 제약조건을 추가하시오.
    alter table milk2 add CHECK(mnum>=0);
    insert into  milk2 (mno, mname, mnum, mtotal) values (1, '서울우유', -1, 1);
    -- ERROR 3819 (HY000): Check constraint 'milk2_chk_1' is violated.
    -- MySQL에서 CHECK 제약조건(constraint)을 위반하여 데이터를 삽입하거나 수정할시 발생

10. milk 테이블의 mname 필드에 UNIQUE 제약조건을 추가하시오. 
    alter table milk2 add UNIQUE(mname); -- 중복값 비허용
    insert into  milk2 (mno, mname, mnum, mtotal) values (1, '서울우유', 1, 1);
    insert into  milk2 (mno, mname, mnum, mtotal) values (2, '서울우유', 1, 1);
    -- ERROR 1062 (23000): Duplicate entry '서울우유' for key 'milk2.mname'
    -- MySQL에서 테이블의 컬럼이 UNIQUE 제약 조건 또는 PRIMARY KEY로 설정되어 있는데, 
    -- 이미 값이 존재함에도 같은 값을 입력(INSERT/UPDATE)하려 할 때 발생하는 무결성 제약조건 위반

11. milk 테이블의 mtotal 필드를 삭제한 후, mprice * mnum을 자동 계산하는 생성 칼럼으로 다시 추가하시오.
    alter table milk2 drop mtotal; --삭제
    


12. milk_category 테이블을 새로 만들고, milk 테이블에 외래키(FK)를 추가하여 연결하시오.
create table milk_category (
    
);
