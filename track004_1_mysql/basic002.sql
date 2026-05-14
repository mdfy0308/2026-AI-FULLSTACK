
[연습문제]
[001]  다음과 같이 DB와 테이블을 만드시오        >> coffee
커피번호 : cno    int           필수입력     primary key
커피이름 : cname  varchar(50)   필수입력
커피가격 : cprice   int          필수입력

create table coffee(
    cno int not null auto_increment primary key,
    cname varchar(50) not null,
    cprice int not null
);


-- +--------+-------------+------+-----+---------+----------------+
-- | Field  | Type        | Null | Key | Default | Extra          |
-- +--------+-------------+------+-----+---------+----------------+
-- | cno    | int(11)     | NO   | PRI | NULL    | auto_increment |    
-- | cname  | varchar(50) | NO   |     | NULL    |                |
-- | cprice | int(11)     | NO   |     | NULL    |                |
-- +--------+-------------+------+-----+---------+----------------+


[002] 다음과 같이 DB와 테이블을 만드시오           >> milk
우유번호 : mno      int           필수입력     primary key
우유이름 : mname    varchar(50)  필수입력
우유가격 : mprice   int          필수입력
우유갯수 : mnum     int         필수입력
우유총액 : mtotal   int         필수입력

create table milk(
    mno int not null auto_increment primary key,
    mname varchar(50) not null,
    mprice int not null,
    mnum int not null,
    mtotal int not null
);

-- +--------+-------------+------+-----+---------+----------------+
-- | Field  | Type        | Null | Key | Default | Extra          |
-- +--------+-------------+------+-----+---------+----------------+
-- | mno    | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | mname  | varchar(50) | NO   |     | NULL    |                |
-- | mprice | int(11)     | NO   |     | NULL    |                |
-- | mnum   | int(11)     | NO   |     | NULL    |                |
-- | mtotal | int(11)     | NO   |     | NULL    |                |
-- +--------+-------------+------+-----+---------+----------------+



[003] 다음과 같이 DB와 테이블을 만드시오    >> score

create table score(
    sno int not null auto_increment primary key,
    sname varchar(20) not null,
    sjava int not null,
    sjsp int not null,
    sspring int not null,
    sproject int not null,
    sstotal int,
    ssavg int,
    semail varchar(50)
);

-- +----------+-------------+------+-----+---------+----------------+
-- | Field    | Type        | Null | Key | Default | Extra          |
-- +----------+-------------+------+-----+---------+----------------+
-- | sno      | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | sname    | varchar(20) | NO   |     | NULL    |                |
-- | sjava    | int(11)     | NO   |     | NULL    |                |
-- | sjsp     | int(11)     | NO   |     | NULL    |                |
-- | sspring  | int(11)     | NO   |     | NULL    |                |
-- | sproject | int(11)     | NO   |     | NULL    |                |
-- | sstotal  | int(11)     | YES  |     | NULL    |                |
-- | ssavg    | int(11)     | YES  |     | NULL    |                |
-- | semail   | varchar(50) | YES  |     | NULL    |                |
-- +----------+-------------+------+-----+---------+----------------+


[004]  다음과 같이 DB와 테이블을 만드시오      >> emp

create table emp(
    empno int not null auto_increment primary key,
    ename varchar(20),
    job varchar(20),
    mgr int,
    hiredate date,
    sal int,
    comm int,
    deptno int
);


mysql> desc emp;
-- +----------+-------------+------+-----+---------+----------------+
-- | Field    | Type        | Null | Key | Default | Extra          |
-- +----------+-------------+------+-----+---------+----------------+
-- | empno    | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | ename    | varchar(20) | YES  |     | NULL    |                |
-- | job      | varchar(20) | YES  |     | NULL    |                |
-- | mgr      | int(11)     | YES  |     | NULL    |                |
-- | hiredate | date        | YES  |     | NULL    |                |
-- | sal      | int(11)     | YES  |     | NULL    |                |
-- | comm     | int(11)     | YES  |     | NULL    |                |
-- | deptno   | int(11)     | YES  |     | NULL    |                |
-- +----------+-------------+------+-----+---------+----------------+
-- 8 rows in set (0.01 sec)



[005]  다음과 같이 DB와 테이블을 만드시오 >> dept
create table dept(
    deptno int not null auto_increment primary key,
    dname varchar(20),
    loc varchar(20)
);

mysql> desc dept;
-- +--------+-------------+------+-----+---------+----------------+
-- | Field  | Type        | Null | Key | Default | Extra          |
-- +--------+-------------+------+-----+---------+----------------+
-- | deptno | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | dname  | varchar(20) | NO   |     | NULL    |                |
-- | loc    | varchar(20) | NO   |     | NULL    |                |
-- +--------+-------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)


[006]  다음과 같이 DB와 테이블을 만드시오    >> salagrade

create table salagrade(
    grade int not null auto_increment primary key,
    losal int,
    hisal int
);

mysql> desc salagrade;
-- +-------+---------+------+-----+---------+----------------+
-- | Field | Type    | Null | Key | Default | Extra          |
-- +-------+---------+------+-----+---------+----------------+
-- | grade | int(11) | NO   | PRI | NULL    | auto_increment |
-- | losal | int(11) | YES  |     | NULL    |                |
-- | hisal | int(11) | YES  |     | NULL    |                |
-- +-------+---------+------+-----+---------+----------------+
-- 3 rows in set (0.02 sec)


