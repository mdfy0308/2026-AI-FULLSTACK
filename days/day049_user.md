#1. spring003_mvc 안전한 복사해서 ex03 번만들기
#2. 테이블 users
mysql> desc users;
+----------+--------------+------+-----+-------------------+-------------------+
| Field    | Type         | Null | Key | Default           | Extra             |
+----------+--------------+------+-----+-------------------+-------------------+
| uno      | int          | NO   | PRI | NULL              | auto_increment    |
| nickname | varchar(20)  | NO   |     | NULL              |                   |
| bpass    | varchar(50)  | NO   |     | NULL              |                   |
| email    | varchar(100) | NO   |     | NULL              |                   |
| mobile   | varchar(50)  | NO   |     | NULL              |                   |
| udate    | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| bip      | varchar(50)  | NO   |     | NULL              |                   |
+----------+--------------+------+-----+-------------------+-------------------+
7 rows in set (0.00 sec)

mysql>

■ model
1) Dto
2) Dao - join / login / mypage  / 아이디 중복검사 (해당 sql 찾기)
3) Service  테스트

■ controller
1) UserController

■ view
1) 회원가입  join 
2) 로그인    login 
3) 마이페이지 mypage
4) 아이디중복검사  (ajax)
5) board 검색    (ajax)




▶ 1. Security?
 - 애플리케이션의 보안(인증, 인가)을 담당
 - Filter의 흐름에 따라 처리

▶ 2. 인증  VS  인가
 - 인증  Authentication - [본인]이 맞는지 확인     : 여권 가지고 비행기 탑승, 로그인
 - 인가  Authorization  - 인증된사용자가 [접근가능] : 승객은 조종실에 못 들어감.

▶ 3. Security 아키텍쳐

=====================
       ② [UsernamePasswordAuthentication Token]
          ↓
① Http Request  →     [AuthenticationFilter] ③ ...  →  [Authentication  Manager]
         ↓⑩               ⑨     ←
          [SecurityContextHolder]
=====================

-1. 사용자가 로그인 폼태그 시도 (username + password 전달)
-2. UsernamePasswordAuthentication 요청정보  Authentication 를 생성
-3. Authentication 인증처리
★UsernamePasswordAuthentication


-10. 인증 완료가 [사용자정보]   SecurityContextHolder 담기
    - AuthenticationSuccessHandler   를 실행( 성공 )
    - AuthenticationFailureHandler   를 실행( 실패 )

=====================
 [AuthenticationFilter] ③   → [Authentication  Manager] → ④[AuthenticationProvider(s)]
                                            ← ⑨       ↑   ↓⑤   
                     ↑                            [ UserDetailsService ]    
                        ProviderManager                ↑   ↓⑥
                                                 [ UserDetails ]   

=====================
-4. Authentication  Manager  인증담당
★UsernamePasswordAuthentication  Token은 Provider를 찾는데 사용
 
AuthenticationProvider
★ 로그인정보 DB정보와 비교

UserDetailsService
★ DB에 있는 [사용자정보]가져오기



1. pom.xml - 시큐리티 부품 가져오기
2. security-context.xml - 부품 세팅
3. web.xml - 부품 끼우기
4. SecurityController 