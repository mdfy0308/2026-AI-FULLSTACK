1.  CSR VS  SSR
- SSR : 서버가 웹페이지의 렌더링 , 초기속도가 빠르고 /서버부하가 커지고, 깜박임
- CSR : 브라우저가 웹페이지를 렌더링 , 화면바뀜 빠름 / 초기속도 느림  

2. 기술스택
[PROJECT]
ㄴ BACK  :  boot  + jpa  + oracle  + (mybatis) + jwt + redis
ㄴ FRONT :  react + next + antd 

### 1. BACK
1. JAVA 17
2. SPRING BOOT (gradle)
3. security + jwt +  redis + oauth2.0 + jpa + mybatis + oracle

1) spring boot     - 애플리케이션기반의 프레임워크 /  내장 tomcat / 자동설정
2) spring security - 인증,인가 /  필터체인의 요청 보호 / 
                     oauth2.0(외부인증 - 카카오, 네이버, 구글)와 쉬운연동
3) mybatis         - xml  sql 복잡한 쿼리 작성
4) jwt             - json  web token  / 토큰기반의 인증방식 
                     토큰안에 사용자의 정보와 권한을 담아 전달, 
                     서버가 세션을 직접관리 하지 않고, 
                     클라이언트가 토큰을 보관
5) redis           - 캐시/세션을 관리 ,  refresh token을 저장 ,  
                     캐싱처리(자주사용하는 값을 미리 넣어놓고 요청이 있을때 서버 거치지 않고 빠르게 제공)에 활용              
6) jpa             - sql 작성없이 객체중심의 처리


1.  SPRING boot  → 애플리케이션 실행기반
2.  SPRING security + jwt/oauth2.0   → 인증/인가 처리
3.  redis   →  토큰/세션/캐시관리
4.  jpa + mybatis  → 데이터베이스 접근 (orm + sql mapper 병행)


##### [실습]  1. 스프링부트 프로젝트 
- [x] 1. 개발개요안내
- [x] 2. java.sun.com - JAVA 17 다운로드 - 설치
- [x] 3. SPRING BOOT   - https://spring.io/ - 다운로드 - 설치
  > 이전버젼
  https://github.com/spring-projects/spring-tools/wiki/Previous-Versions
- [x] 4. SPRING BOOT 프로젝트 만들기
- [x] 5. lombok

 
##### [실습]  2. docker 설치
- [x] 1. docker 설치
- https://www.docker.com/products/docker-desktop/ (AMD)
- 다운로드 및 설치 → 1. window 업데이트 2. USE WSL 2

```bash
wsl --update
```

```bash
docker --version
docker ps
```

- [ ] 2. redis 설치
```bash
docker pull  redis
docker run   -d  --name  my-redis  -p 6379:6379   redis

docker  exec  -it  my-redis  redis-cli
docker  exec  -it  my-redis  redis-cli  FLUSHALL
keys *
get  저장이름
```

```필기
docker pull  redis  --> 최신버전 redis 다운로드
docker run          -d          --name  my-redis    -p 6379:6379        redis
--> 생성 및 실행      백그라운드   생성될 이름           내 컴퓨터 6379 번호로 내부에 6379로 연결

docker  exec  -it  my-redis  redis-cli
-->     실행   i: 표준입력, t: 가상터미널
docker  exec  -it  my-redis  redis-cli  FLUSHALL
keys *
get  저장이름
```

1. JWT  VS  세션
- 세션 : 서버 메모리에 사용자 상태를 저장 →  서버 확장시 부담  
                                    (서버에서 출입명단 직접 들고 있는 것)
- JWT(Json Web Token) : 토큰 자체에 인증정보를 포함  → 확장성
                                    (사용자가 출입증을 직접 들고다니기)

2. Access  Token vs  Refresh Token 
1) Access  Token :  짧은 기간 유효(출입증)    → api 호출 시 사용    
2) Refresh Token :  긴   기간 유효(장기체류증) →  redis 냉장고에 안전보관   

3. Redis 사용이유?
- 토큰 냉장고 → 장기체류증 안전하게 보관, 필요시 꺼내 씀
- Refresh Token 중앙에서 관리
- TTL(만료 시간)로 자동 만료처리
- 로그아웃 시 즉시 삭제


##### [실습] 3. oracle 유저 세팅

```sql
-- cmd
-- sqlplus
-- conn  system/1234
 
-- 유저만들기 ( 오라클 12 이상에서 기존방식으로 사용자 생성 허용 )
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
create user boot  identified by react;

-- 권한부여
grant  connect , resource  to boot;

ALTER USER boot DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;    -- 물리적공간이용
grant  create table to boot;
```


##### [실습] 4. Boot + React ver.1 (기본 게시판 + 회원가입)
1. board
- [✔] 1. project
- [✔] 2. 부품객체 () : gradle
  ※ https://mvnrepository.com/
- [✔] 3. application.yml
```yml
spring:
  datasource:
    url: jdbc:oracle:thin:@localhost:1521/XE    # jdbc url
    username: boot                              # 사용자 계정
    password: react                             # 비밀번호
    driver-class-name: oracle.jdbc.OracleDriver # oracle, mysql, h2

  jpa:
    hibernate:
      ddl-auto: update    # 엔티티 변경사항 - db테이블 자동으로 변경사항 반영
                          # update: 수정 반역, 기존 데이터 유지 / create-drop : 생성후 삭제, 매번 초기화
                          # 배포할 때는 none(기본)
    properties:
      hibernate:
        format_sql: true  # 콘솔 및 로그에 출력되는 sql 둘여쓰기 속성
        show_sql: true    # sql 쿼리 문장을 그대로 로그에 출력

  servlet:
    multipart:
      enabled: true           # 파일 업로드 처리 기능 활성화
      max-file-size: 10MB     # 업로드하는 최대 허용 용량
      max-request-size: 20MB  # 한번에 전송되는 총용량

  data:
    redis:
      host: localhost     # redis 연결 주소
      port: 6379          # 서버 포트
      timeout: 2000       # 서버와 연결 대기시간

  config:
    import: 
      - optional:application-oauth.yml    # api 설정관련
      - optional:file:.env[.properties]   # .env 파일 실제 보관키


mybatis:
  config-location: classpath:mybatis-config.xml   # 전역 설정 파일
  mapper-locations: classpath:mapper/**/*.xml     # 매퍼 경로 패턴
  type-aliases-package: com.thejoa703.domain      # 도메인 설정

jwt:
  issuer: thejoa703                       # jwt 토큰 발행한 주체자
  secret: ${JWT_SECRET}                   # 사용할 비밀키
  access-token-exp-seconds: 900           # 유효시간
  refresh-token-exp-seconds: 1209600      
  header: Authorization                   # 토큰 전달시 http요청 헤더 이름 지정
  prefix: Bearer                          # 토큰 앞에 붙는 이름 (접두사)

file:
  upload-dir: uploads   # 업로드된 파일 설정 경로

#server:
#  port: 8484
```
  ※ (oracle db:table) → dto → mapper → service → controller → view
- [✔] 4. entity (테이블을 객체로 처리)
  back1
  └─ src/main/java
    └─ com.the703.entity
      ├─ AppUser
      └─ Post

  A. JPA
    - ORM(Object-Relational Mapping)
    부품객체(자바 클래스)와 RDB(관계형 데이터베이스)의 불일치 해결하려고
    SQL 중심이 아니라 객체 중심으로 데이터를 다룰 수 있게 해주는 기술

    - 1. @Entity DB의 테이블과 매핑
    - 테이블 컬럼 변경시 SQL을 일일이 수정할 필요 없이 엔티티 클래스만 수정
    - 데이터베이스 방언(Dialect) 지원 → oracle, mysql 특정 데이터에 종속

    - 2. JpaRepository - db에 접속해서 crud 작업을 처리하는 인터페이스
    - 3. 외래키 설정
      
      > AppUser (한 사람이 여러 개의 글을 작성할 수 있다.)
      @OneToMany

      > Post(여러 개의 글)
      @ManyToOne

- [✔] 5. Dto
  back1
      └─ src/main/java
        └─ com.the703.repository
          ├─ AppUserRepository
          └─ PostRepository
- [✔] 6. Repository
  back1
    └─ src/main/java
      └─ com.the703.repository
        ├─ AppUserRepository
        └─ PostRepository
- [] 7. Service
- [] 8. Controller
- [] 9. View


2. 회원가입
