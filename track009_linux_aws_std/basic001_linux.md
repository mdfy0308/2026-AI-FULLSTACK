## CI/CD
1. CI (Continuous Integration, 지속적 통합)
- 개발자들이 작성한 코드를 정기적으로 중앙저장소에 병합하고 자동으로 빌드 및 테스트 하는 과정

2. CD (Continuous Delivery / Continuous Deployment, 지속적 전달 및 배포)
- CI를 거친 코드를 프로덕션(실서비스) 환경에 배포할 수 있도록 준비, 배포 단계


## Part001. Linux

### 진행사항
1. Ubuntu 24.04 컨테이너 실행 방법
2. linux 사용자
3. 기본명령어
4. 파일
5. 유저
6. job + 쉘스크립트

#### 1. Ubuntu 24.04 컨테이너 실행 방법
- 도커(Docker) : 컨테이너 기반의 가상화 플랫폼
- 우분투(Ubuntu) : 리눅스 운영 체제

1. 이미지 다운로드 (pull)
```bash
docker pull ubuntu:24.04
```

2. 컨테이너 실행 (run)
```bash
docker run -it  --name myubuntu ubuntu:24.04 bash
```
1) -it : -i(표준입력 Interactive), -t(터미널 Pseudo-TTY)
2) --name myubuntu : 컨테이너 이름 지정
3) ubuntu:24.04 : 이미지 이름 및 태그(버전)
4) bash : 컨테이너 내부에서 실행할 쉘 전달 및 배포)

3. 컨테이너 내부에서 패키지 업데이트 및 필수 패키지 일괄 설치
※ 
```bash
apt update && apt upgrade -y && DEBIAN_FRONTEND=noninteractive apt install -y vim man-db net-tools iproute2 adduser sudo
```

1) apt update: 설치 가능한 패키지 목록을 최신 상태로 업데이트합니다.
2) &&: 앞의 명령어가 성공적으로 끝나면 뒤의 명령어를 연속해서 실행합니다.
3) apt upgrade -y: 설치되어 있는 모든 프로그램을 최신 버전으로 업그레이드합니다. (-y는 확인 질문에 자동으로 Yes 응답)
4) DEBIAN_FRONTEND=noninteractive: 패키지 설치 중 대국민 설문 형태(시간대 설정 등)의 키보드 입력을 요구하는 팝업 창을 띄우지 않고 기본값으로 자동 진행하게 만듭니다. (도커 컨테이너 환경에서 설치가 중간에 멈추는 것을 방지하는 핵심 설정)
5) apt install -y ...: 지정한 패키지들을 자동으로 설치합니다.

4. 컨테이너 종료 후 다시 실행(ps 상태확인 / start 실행)
```bash
docker ps -a
```
```bash
docker start -ai myubuntu
```
1) -a : 터미널 실시간 화면 보이기
2) -i : 키보드 입력

##### ■ 정리 1) docker (prps)
1) 이미지 다운로드 - docker pull
2) 이미지 컨테이너 만든 후 실행 - docker run
3) 도커 확인 - docker ps
4) 재실행 - docker start


#### 2. linux 사용자
1. '#' : root 사용자 (최고 관리자)
2. '$' : 일반 사용자 (일반 계정 관리자)
    ※ AWS EC2에서 sudo 명령을 붙여서 실행


#### 3. 기본 명령어
```
#1. 날짜 확인
date

#2. 출력
echo hello

#3. 명령어 위치 확인
which date

#4. 명령어 설명서(메뉴얼)
man date
```

```bash
#man 명령어가 작동하지 않거나 최소화된 메뉴얼 복원
apt update #패키지 최신상태
apt install -y man-db manpages #설치, 조리도구, 기본명령어 메뉴얼
yes | unminimize #자동으로 yes, 일반문서 상태
```


```bash
man date 
↑ ↓ q(빠져나오기)

date
date "+%Y-%m-%d"
```

Q1. hi 출력
echi hi
Q2. man 이용해서 echo 확인
man echo

```
root@7d11daf96426:/# echo hi
hi
root@7d11daf96426:/# man echo
ECHO(1)                           User Commands
ECHO(1)
q   #빠져나오기
```

##### ■ 정리 2) 기본
1) 날짜 date
2) 출력 echo
3) 위치 which
4) 매뉴얼 man


#### 4. 파일
1) 파일 및 디렉토리 생성 / 삭제
```bash
mkdir 디렉토리명 # 디렉토리 만들기
mkdir -p 경로/하위경로 # 중간 디렉토리 생성
touch 파일명 # 빈 파일 생성

rm  파일명      # 파일 삭제
rm -r 디렉토리명 # 디렉토리 삭제
```

2) 파일 확인 및 경로 이동
```bash
ls -al  # 목록 보기
pwd     # 현재 경로
cd 디렉토리명   # 디렉토리로 이동
cd ..   # 상위 경로
```

```bash
root@7d11daf96426:/# pwd
root@7d11daf96426:/# ls
root@7d11daf96426:/# ls -al

root@7d11daf96426:/# cd ~ # 자기 폴더로 이동
root@7d11daf96426:~# pwd
/root
root@7d11daf96426:~#

root@7d11daf96426:~# mkdir basic1
root@7d11daf96426:~# ls -al
drwxr-xr-x 2 root root 4096 Sep  1 02:17 basic1
root@7d11daf96426:~# mkdir -p basic2/a/b/c # 연결해서 디렉토리 만들기

root@7d11daf96426:~# rm basic2
rm: cannot remove 'basic2': Is a directory # 하위 폴더가 있어서 삭제 안 됨
root@7d11daf96426:~# rm -r basic2 # 하위 폴더까지 포함하여 삭제
root@7d11daf96426:~# ls
basic1
```

Q1. test 폴더만들기
```
root@7d11daf96426:~# mkdir test
root@7d11daf96426:~# ls
basic1  test
```

Q2. 폴더 안에  test1.txt 파일 만들기
```
root@7d11daf96426:~/test# touch test1.txt
```

Q3. 파일 확인 - 디렉토리인지, 폴더인지까지 구분
```
root@7d11daf96426:~/test# ls -al
total 8
drwxr-xr-x 2 root root 4096 Sep  1 02:46 .
drwx------ 1 root root 4096 Sep  1 02:46 ..
-rw-r--r-- 1 root root    0 Sep  1 02:46 test1.txt
```

3) 파일 쓰기 > (덮어쓰기), >> (이어쓰기)
```bash
echo "hi" > test1.txt
cat test1.txt # 파일 보기
echo "first" > test1.txt    # 덮어쓰기
echo "second" >> test1.txt  # 이어쓰기
cat test1.txt
```

Q1. test 폴더로 이동
Q2. test1.txt 파일에 apple 글쓰기
Q3. test1.txt 파일에 banana, coconut 이어서 쓰기
```bash
root@7d11daf96426:~/test# cd ~
root@7d11daf96426:~# cd test
root@7d11daf96426:~/test# ls
test1.txt
root@7d11daf96426:~/test# echo "apple" > test1.txt
root@7d11daf96426:~/test# echo "banana" >> test1.txt
root@7d11daf96426:~/test# echo "coconut" >> test1.txt
root@7d11daf96426:~/test# cat test1.txt
apple
banana
coconut
```

4) 삭제 및 복사
```bash
cp [원본파일] [이동할 폴더] # 복사
mv [원본파일] [이동할 폴더/새 파일명] # 이동

mv test/test1.txt basic1/fruits.txt
```

Q1. basic1 폴더의 fruits.txt 파일을 복사해서
Q2. test 폴더의 eat.txt 파일명으로 옮기기
```bash
root@7d11daf96426:~# mv basic1/fruits.txt test/eat.txt
root@7d11daf96426:~# cd test
root@7d11daf96426:~/test# ls -al
total 12
drwxr-xr-x 2 root root 4096 Sep  1 03:17 .
drwx------ 1 root root 4096 Sep  1 02:46 ..
-rw-r--r-- 1 root root   21 Sep  1 03:00 eat.txt
root@7d11daf96426:~/test# cat eat.txt
apple
banana
coconut
```

5) vi 에디터
```
1. sudo vi file1.txt 실행  ($ 일반 사용자 - sudo)
2. vi 안에서 [Esc] 눌러 명령 모드로 전환   
3. [i] 눌러 입력 모드로 전환 → 새 설정 붙여넣기  , 편집
4. [Esc] → :wq! → 저장 후 종료
```

Q1.  test 폴더안에  num.txt 파일만들기
Q2.  num.txt vi에디터이용해서
one-1
two-2
three-3 
Q3. 파일확인
```bash
root@7d11daf96426:~# cd test
root@7d11daf96426:~/test# touch num.txt
root@7d11daf96426:~/test# sudo vi num.txt
root@7d11daf96426:~/test# cat num.txt
one-1
two-2
three-3
```

> 정리문제
Q1. 파일만들기   mylinux.txt
Q2. 파일안에 답채우기  예)
echo 
man  ....
Q2) 번 문제
-    출력   echo
-    사용서 man
-    파일생성   touch
-    디렉토리만들기 mkdir
-    목록보기   ls -al
-    상위이동   cd .. / cd ~
-    파일,폴더삭제  rm (-r)
-    file1.txt 을 back.txt으로 파일복사 cp 경로/file.txt 경로/back.txt
-    back.txt를 test.txt로 이름변경     mv 경로/back.txt 경로/test.txt
Q3. vi이용해서 맨위에 작성자본인이름 추가
Q5. mylinux.txt 백업해서 ubuntu에 backup.txt로 
Q6. 상위로 이동 testdir 삭제

```bash
root@7d11daf96426:~/test# touch mylinux.txt
root@7d11daf96426:~/test# echo "echo" > mylinux.txt
root@7d11daf96426:~/test# echo "man" >> mylinux.txt
root@7d11daf96426:~/test# cat mylinux.txt
echo
man ...
root@7d11daf96426:~/test# sudo vi mylinux.txt
root@7d11daf96426:~/test# cat mylinux.txt
echo
man ...
root@7d11daf96426:~/test#
root@7d11daf96426:~/test# cd ~
root@7d11daf96426:~# mkdir ubuntu
root@7d11daf96426:~# ls
basic1  file1.txt  test  ubuntu
root@7d11daf96426:~# mv test/mylinux.txt ubuntu/backup.txt
root@7d11daf96426:~# cd ubuntu
root@7d11daf96426:~/ubuntu# ls
backup.txt
root@7d11daf96426:~/ubuntu# cd ..
root@7d11daf96426:~# rm -r test
root@7d11daf96426:~# ls
basic1  file1.txt ubuntu
root@7d11daf96426:~/ubuntu# cat backup.txt
writer_js
-    출력   echo
-    사용서 man
-    파일생성   touch
-    디렉토리만들기 mkdir
-    목록보기   ls -al
-    상위이동   cd .. / cd ~
-    파일,폴더삭제  rm (-r)
-    file1.txt 을 back.txt으로 파일복사 cp 경로/file.txt 경로/back.txt
-    back.txt를 test.txt로 이름변경     mv 경로/back.txt 경로/test.txt
```


#### 5. 유저
1. 유저 추가 및 삭제
```bash
sudo adduser one
sudo passwd 1111
sudo deluser one
```

2. 권한 구조 변경
```bash
ls -al
d             rwx                       r-x  --- 2              sally sally 4096 Feb  3 15:04 .    
→  d 디렉토리  소유자(읽기:4/쓰기:2/실행:1) 그룹(읽기:4/쓰기:-/실행:1) 다른사람(읽기:-/쓰기:-/실행:-)
d rwx                                   r-x                     r-x 1 root  root  4096 Feb  3 14:59 ..
→  d 디렉토리  소유자(읽기:4/쓰기:2/실행:1) 그룹(읽기:4/쓰기:-/실행:1) 다른사람(읽기:-/쓰기:-/실행:-)
```

```
adduser one
New password:
Retype new password: ← 입력해도 안 보인다
y

cd /home
su - one
mkdit folder1
ls -al
echo date > log.txt
```
one@7d11daf96426:~$ ls -al
total 24
drwxr-x--- 3 one  one  4096 Sep  1 05:45 .
drwxr-xr-x 1 root root 4096 Sep  1 05:36 ..
-rw-r--r-- 1 one  one   220 Sep  1 05:36 .bash_logout
-rw-r--r-- 1 one  one  3771 Sep  1 05:36 .bashrc
-rw-r--r-- 1 one  one   807 Sep  1 05:36 .profile
##### d(폴더)   소유자 rwx   그룹 rwx   다른 사람 r-x   775
##### r 읽기:4, w 쓰기:2, x 실행:1       
d rwx rwx r-x 2 one  one  4096 Sep  1 05:45 folder1
##### -(파일) 소유자 rw- 그룹 rw- 다른사람 r--      664
-rw-rw-r-- 1 one one   29 Sep  1 05:53 log.txt
one@7d11daf96426:~$

- root에서 유저 만들기
Q1. `two` 유저 만들기 (비번: 2222)
Q2. `two`로 로그인(`su - two`) / `two` 홈 디렉토리 찾아가기
Q3. `two`로 접속해서 `/home/one` 찾아가는 거 가능한지 확인

```bash
root@7d11daf96426:/# adduser two # two 유저 만들기
New password:                       ## 비밀번호 2222 설정
Retype new password:
root@7d11daf96426:/# su - two       # two로 로그인
two@7d11daf96426:~$ cd /home        # 홈 디렉토리  찾아가기

two@7d11daf96426:/home$ cd one      
-bash: cd: one: Permission denied   # /home/one 찾아갈 수 없음(권한 없음)

two@7d11daf96426:/home$ ls -al
total 20
drwxr-xr-x 1 root   root   4096 Sep  1 05:59 .
drwxr-xr-x 1 root   root   4096 Sep  1 02:33 ..
drwxr-x--- 3 one    one    4096 Sep  1 05:58 one
drwxr-x--- 2 two    two    4096 Sep  1 05:59 two
drwxr-x--- 2 ubuntu ubuntu 4096 Aug 10 14:55 ubuntu
two@7d11daf96426:/home$
```

```bash
# root 계정에서 소유자7   그룹5   다른사람5
# rwx읽기/쓰기/실행7   r-x읽기/실행5    r-x읽기/실행5
root@7d11daf96426:/home# ls -al
total 20

drwxr-xr-x 1 root   root   4096 Sep  1 05:59 .
drwxr-xr-x 1 root   root   4096 Sep  1 02:33 ..
drwxr-x--- 3 one    one    4096 Sep  1 05:58 one
drwxr-x--- 2 two    two    4096 Sep  1 06:08 two
drwxr-x--- 2 ubuntu ubuntu 4096 Aug 10 14:55 ubuntu

root@7d11daf96426:/home# chmod 755 /home/one # 권한 변경

total 20
drwxr-xr-x 1 root   root   4096 Sep  1 05:59 .
drwxr-xr-x 1 root   root   4096 Sep  1 02:33 ..
drwxr-xr-x 3 one    one    4096 Sep  1 05:58 one
drwxr-x--- 2 two    two    4096 Sep  1 06:08 two
drwxr-x--- 2 ubuntu ubuntu 4096 Aug 10 14:55 ubuntu

```

Q4. 권한 변경 후 `two`로 접속해서 `/home/one` 찾아가는 거 가능한지 확인
```bash
su - two
pwd     #현재 위치 확인
cd /home/one
two@7d11daf96426:/home/one$
```

Q5. log.txt 파일 읽기
```bash
ls-al
-rw-rw-r-- 1 one one   29 Sep  1 05:53 log.txt

two@7d11daf96426:/home/one$ cd folder1
two@7d11daf96426:/home/one/folder1$ cat log.txt
Tue Sep  1 05:53:24 UTC 2026
```

Q6. root 계정에서 /home/one 폴더 다른사람이 못읽게 처리
```bash 
chmod 750 /home/one # 사용자7 그룹5 다른사람0
```

■ 정리
1. 유저 만들기 adduser  username
2. 권한 주기    chmod   000/777 ... (rwxr-x...) 소유자/그룹/다른사람


#### 6. job + 쉘스크립트
1. 프로세스 상태 확인
```bash
ps -ef
```
1) e: 모든 프로세스 표시
2) f: 풀포맷 - 자세하게 출력

2. 실시간 모니터링
```bash
top # ctrl + c로 빠져나오기
```

3. ip 주소 확인
```bash
ip a
```

4. hello world 출력 쉘스크립트 작성
```bash
vi hello.sh             #! /bin/bash
echo "Hello World"

ls -al
chmod +x hello.sh       # 모든 사용자에 hello 실행 권한 추가
chmod -x hello.sh       # 실행 권한 제거

./hello.sh  # 실행
```

```bash
root@7d11daf96426:/home# vi hello.sh
root@7d11daf96426:/home# ls -al
total 24
drwxr-xr-x 1 root   root   4096 Sep  1 06:52 .
drwxr-xr-x 1 root   root   4096 Sep  1 02:33 ..
-rw-r--r-- 1 root   root     19 Sep  1 06:52 hello.sh
drwxr-x--- 3 one    one    4096 Sep  1 05:58 one
drwxr-x--- 2 two    two    4096 Sep  1 06:08 two
drwxr-x--- 2 ubuntu ubuntu 4096 Aug 10 14:55 ubuntu
root@7d11daf96426:/home# chmod +x hello.sh
root@7d11daf96426:/home# ./hello.sh
Hello World
root@7d11daf96426:/home#
```

Q1. 현재시간출력 쉘스크립트 작성  > date_log.sh
#!/bin/bash
date
date > log.txt
echo  "log.txt 파일에 시각이 저장되었습니다."

```bash
root@7d11daf96426:/# vi date_log.sh
```

Q2. 권한확인 실행권한주기
```bash
root@7d11daf96426:/# chmod +x date_log.sh
```

Q3. 실행 및 확인
```bash
root@7d11daf96426:/# ./date_log.sh
Tue Sep  1 07:04:54 UTC 2026
log.txt done
```


## Part002. Aws