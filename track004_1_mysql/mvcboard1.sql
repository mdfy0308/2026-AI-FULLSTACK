use mbasic;
show tables;

create table mvcboard1(
	bno int not null auto_increment primary key,
    bname varchar(200) not null,
    bpass varchar(50) not null,
    btitle varchar(1000) not null,
    bcontent text,
    bdate timestamp default current_timestamp not null,
    bhit int not null default 0,
    bip varchar(50) not null
);

alter table mvcboard1 modify bcontent text not null;
desc mvcboard1;
select * from mvcboard1;
select count(*) from mvcboard1 order by bno desc;

select *, (select count(*) from mvcboard1) `cnt` from mvcboard1 order by bno desc;

create table users(
	uno int not null auto_increment primary key,
    nickname varchar(20) not null,
    bpass varchar(50) not null,
    email varchar(100) not null,
    mobile varchar(50) not null,
    udate timestamp not null default current_timestamp,
    bip varchar(50) not null
);

desc users;
select * from users;

delete from users where uno > 1;
ALTER TABLE users AUTO_INCREMENT = 1;
