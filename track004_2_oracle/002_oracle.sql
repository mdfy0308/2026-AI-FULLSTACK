-- 1. table

drop table sboard2;

create table sboard2(
    ID NUMBER NOT NULL,
    APP_USER_ID NUMBER NOT NULL,
    BTITLE VARCHAR2(1000) NOT NULL,
    BCONTENT CLOB NOT NULL,
    BPASS VARCHAR2(255) NOT NULL,
    BFILE VARCHAR2(255) default 'the703.png',
    BHIT NUMBER DEFAULT 0,
    BIP VARCHAR2(255) NOT NULL,
    CREATED_AT DATE default sysdate
);

create sequence sboard2_seq;
desc sboard2;

commit;


--1) crud
insert into  sboard2 ( ID                          ,  APP_USER_ID ,  BTITLE  ,  BCONTENT  ,  BPASS  ,  BFILE  ,  BIP  )
values               ( sboard2_seq.nextval   ,  1001    ,  'title'   , 'bcontent'  ,   '1111' ,   '1.png' ,   '127.0.0.1'   );

-- 전체select  ( 페이징 ) 12버전 이상
SELECT * FROM sboard2 
ORDER BY id DESC
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;

--  OFFSET 0 ROWS: 건너뛸 행의 개수 (0부터 시작)
--  FETCH NEXT 10 ROWS ONLY: 가져올 행의 개수
--  최신글부터 10개   0, 10   /  10,10  / 20, 10

-- 전체 select 11버전 이하
select * from(
         select row_number() over(order by id desc)  as rnum, 
                id, app_user_id, btitle, bcontent, bpass, bfile, bip, bhit, created_at
         from  sboard2
      ) A  
      where  A.rnum  between  0  and 10;


select count(*) from sboard2;

-- mysql ( oracle에서는 동작안함)
select *  from  sboard2  order by id   desc   limit  0, 10 ;     

-- 해당번호의 select
select *  from  sboard2    where  id=1;
  
--n해당번호 조회수 올리기
update  sboard2   set   bhit = bhit + 1  where  id=1;

-- 해당번호 업데이트
update  sboard2  set  btitle='new' , bcontent='new' , bfile='2.png'  where  id=1;
  
-- 해당번호 삭제
delete  from  sboard2   where  id=1;