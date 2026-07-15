## 0. SSR vs CSR

1) SSR (Server-Side Rendering)
→ 서버가 완성된 HTML을 만들어서 클라이언트(브라우저)에게 제공
- 기술 스택 : BOOT + security + thymeleaf + oracle + mybatis
- 렌더링 주체 : 서버
- 초기 로딩 : 빠름
- 화면 전환 : 새로고침

2) CSR (Client-Side Rendering)
→ 클라이언트(브라우저)가 HTML + JS를 이용해서 화면 그리기
- 기술 스택 : node(backend) / react + next(frontend)
- 렌더링 주체 : 브라우저
- 초기 로딩 : 느림
- 화면 전환 : 부드러움

> backend : boot + security + jwt + redis + jpa
> frontend : react + next


## 1. 프로젝트 구조
```
back/
├── config/
│   └── db.js                  # Oracle DB 설정
├── middlewares/
│   └── isAuthenticated.js     # 로그인 인증 미들웨어
├── models/
│   └── users.js               # 사용자 DB 모델 및 쿼리 함수
├── passport/
│   ├── index.js               # Passport 초기화
│   └── local.js               # Local 전략 설정
├── routes/
│   └── user.js                # 사용자 관련 API 라우터
├── node_modules/              # npm 패키지
├── .env                       # 환경변수
├── app.js                     # 서버 진입점
├── package.json               # 프로젝트 설정 및 스크립트
├── package-lock.json          # 패키지 버전 고정
├── test1.js   # 모델 함수 테스트 스크립트
```

http://nodejs.org/ko
1) 다운로드 및 설치
2) 확인
```
node -v
npm -v
```
3) 관리자 권한으로 power shell 실행
```
PS C:\WINDOWS\system32> Get-ExecutionPolicy
RemoteSigned
PS C:\WINDOWS\system32> Set-ExecutionPolicy
```

### 1) 프로젝트 만들기
0. 구조 확인
```
back/   node
front/  react + next
```

1. 프로젝트 만들기
```js
npm init
```

2. 실습
```
mkdir back
cd back
npm init
```

### 2) 패키지 설치
```
npm install
```

```
{
  "name": "back",
  "version": "1.0.0",
  "main": "app.js",
  "scripts": {
    "dev": "nodemon app", -- 개발시
    "start": "cross-env NODE_ENV=production pm2 start app.js" -- 운영환경
  },
  "dependencies": {
    "aws-sdk": "^2.710.0",          -- aws 서비스 연동
    "bcrypt": "^5.1.0",             -- 비밀번호 암호화
    "cookie-parser": "^1.4.6",      -- 쿠키 데이터 파싱
    "cors": "^2.8.5",               -- 웹보안정책 cors
    "cross-env": "^7.0.3",          -- 운영체제별 환경변수 통일
    "dotenv": "^16.3.1",            -- 환경변수 파일관리
    "express": "^4.21.2",           -- node.js 웹서버 프레임워크
    "express-session": "^1.17.3",   -- 로그인 상태 세션관리
    "helmet": "^7.0.0",             -- 보안 관련 http 헤더 설정
    "hpp": "^0.2.3",                -- http 파라미터 오염방지 보안
    "morgan": "^1.10.0",            -- 서버 요청 로그 기록
    "multer": "^1.4.5-lts.1",       -- 파일 업로드 미들웨어
    "oracledb": "^6.4.0",           -- oracle
    "passport": "^0.7.0",           -- 인증처리
    "passport-local": "^1.0.0",     -- 이메일/비번 로그인
    "pm2": "^5.3.0",                -- 서버 무중단 관리
    "swagger-jsdoc": "^6.2.8",      -- api 문서화 엔진
    "swagger-ui-express": "^5.0.1"  -- 페이지 처리
  },
  "devDependencies": {
    "nodemon": "^3.0.1"             -- 개발중에 코드변경 자동 반영
  }
}
```

### 3) 서버 진입점
```
back/
├── app.js                     # 서버 진입점
```

1. app.js
```

```

2. 실행
```
npx nodemon app.js
```

3. 브라우저 실행
브라우저에서 http://localhost:3065

---

## 2. 개발
### 1) model
```
back/
├── config/
│   └── db.js                  # Oracle DB 설정
├── models/
│   └── users.js               # 사용자 DB 모델 및 쿼리 함수
├── .env                       # 환경변수
├── test1.js   # 모델 함수 테스트 스크립트
```

#### 1. id: node / pass: react - oracle 유저 만들기
```sql
-- cmd
-- sqlplus
-- conn system/1234

-- 유저 만들기 (오라클 12 이상에서 기존 방식으로 사용자 생성 허용)
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
create user node identified by react;

-- 권한 부여
grant connect, resource to node;

alter user node default tablespace users quota unlimited on users; -- 물리적 공간 이용
grant create table to node;
```

#### 2. appuser 테이블
```
DROP  TABLE APPUSER  CASCADE CONSTRAINTS;

CREATE TABLE APPUSER (
    APP_USER_ID     NUMBER NOT NULL,
    EMAIL           VARCHAR2(255) NOT NULL UNIQUE,
    PASSWORD        VARCHAR2(255) NOT NULL,
    NICKNAME        VARCHAR2(100),
    MOBILE          VARCHAR2(20),
    MBTI_TYPE_ID    NUMBER,
    UFILE           VARCHAR2(255),
    CREATED_AT      DATE DEFAULT SYSDATE,
    CONSTRAINT PK_APPUSER PRIMARY KEY (APP_USER_ID)
);

CREATE SEQUENCE APPUSER_SEQ;
```

#### 3. .env - 환경변수
```
# 세션 쿠키 암호화 키
COOKIE_SECRET=appsecret

# Oracle DB 접속 정보
DB_USER=node
DB_PASSWORD=react
DB_CONNECT=localhost:1521/XE
```

#### 4. config/db.js
```
```

#### 5. models/users.js
```
```

#### 6. model 함수 테스트
```js
```

### 2) controller
back/
├── middlewares/
│   └── isAuthenticated.js     # 로그인 인증 미들웨어
├── passport/
│   ├── index.js               # Passport 초기화
│   └── local.js               # Local 전략 설정
├── routers/
│   └── user.js                # 사용자 관련 API 라우터
├── node_modules/              # npm 패키지
├── app.js


#### 1. routers/user.js
```
주소경로
post : /user/register (requestBody)
post : /user/login    (requestBody)
post : /user/logout   
get  : /user/
patch: /user/{id}/nickname
※비교  /user/nickname?id=1
delete: /user/{id}
```

patch: /user/{id}/nickname  ← rest 방식         데이터접근방식 : url 자원소스 포함
※비교  /user/nickname?id=1  ← queryString 방식  데이터접근방식 : url?key=value


##### http 표준 프로토콜 사용
- GET(조회), POST(생성), PUT/PATCH(수정), DELETE(삭제)


#### 2. app.js


#### 3. passport/index.js, local.js


#### 4. middlewares/isAuthenticated.js