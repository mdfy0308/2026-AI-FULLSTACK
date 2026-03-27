## Part001

●1. git, github
- git : 내 컴퓨터에서 파일의 변화를 기록
- github : 협업시 저장공간 (원격)

●2. 실습

1. Git 설치
   - [Git 공식 사이트](https://git-scm.com)에서 다운로드 후 설치.
   https://git-scm.com
   - 설치 후 git --version 으로 정상 설치 확인.

 
2. 사용자 정보 설정
   git config --list
   git config --global user.name "깃허브아이디"
   git config --global user.email "깃허브이메일"

   git config --global user.name "sujeong"
   git config --global user.email "mdfy0308@gmail.com"

 
3. GitHub 계정 준비
  - GitHub 회원가입 및 로그인.
  - 새 레포지토리(repository) 생성.                   

 
4. 레포지토리 연결
   - 새 컴퓨터에서 원하는 폴더로 이동 후: 

     git clone https://github.com/아이디/레포지토리명.git

     git clone https://github.com/mdfy0308/2026-AI-FULLSTACK.git

     cd C:\sujeong // change directory 경로 변경


 
- 이미 만든 프로젝트를 올리고 싶다면: 
  git init
  git remote add origin https://github.com/아이디/레포지토리명.git 

 
5. 작업 파일 올리기

   git add . // 파일을 원격저장소에 올린다 .(전부)
   git commit -m "첫 커밋 메시지" // 
   git push origin main //


   ⚠️ 여기서 main 대신 master 일 수도 있으니, 
   레포지토리 기본 브랜치 이름 확인 필요.
 
 
 
6. gitinore

- Git에게 “이건 안 가져가도 돼!”라고 알려주는 메모지

- Git = 장난감상자 (모든 장난감을  넣어두는 곳)  
- 파일들 = 장난감들  
- .gitignore - “이 장난감은 상자에 넣지 마!”라고 붙여둔 스티커   


※ VS CODE 설치
 

---
- TODO2 :  마크다운 문법

<!-- 주석 : 제목 h1~h6 -->
# 제목 ( 제일 큰 제목 )
## 중간 제목
### 작은 제목
#### step4
##### step5
###### step6

<!-- 구분선 -->
--- 

<!-- `` -->
🥇이모지 `윈도우 + .`

---

<!-- - 리스트 항목 -->
- 🍔🍟🥤 햄버거 세트
- 🍕 피자
- 🌭 핫도그

1. 주문한다.
2. 만든다.
3. 먹는다.

---
*별 하나 - 기울이기*
**별 두개 - 볼드/굵게**
***별 세개 - 기울이기+굵게***

~~취소선~~

>말풍선

```
문장을 사용할 때
긴 코드 블록
```

<!-- 원하는 언어의 코드를 작성할 때 -->

```java
public class Test{}
```

---
<!-- url 삽입 -->

[네이버](http://www.naver.com)

<!-- 이미지 삽입 -->
![프로필](me.png)

<img src="me.png" alt="학생의 프로필 사진"
     style="width: 80px; border: 2px solid blue;"/>

---
<!-- 테이블 -->

|no|name|
|----|----|
|01|김우빈|
|02|마동석|
|03|원빈|

|1|2|
|-|-|
|3|4|