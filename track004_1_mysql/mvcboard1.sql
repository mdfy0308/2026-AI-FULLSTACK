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
