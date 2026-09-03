#### ■ Step4. HTTPS + DOMAIN

1. DuckDns 도메인 생성
1) https://www.duckdns.org/
2) 로그인
3) SUB DOMAIN → the703-js.duckdns.org → add domain
4) ec2 public ip 연동 - 13.125.236.249
5) Token
```
the703-js.duckdns.org
45aa8fef-240e-4df8-b5b8-84a7132587a0
```

2. EC2 서버에서 DuckDns IP 자동 갱신 설정
> AwS Ec2의 인스턴스를 중지했다가 켜면 퍼블릭 ip 주소가 변경됨

1) ssh 접속
2) duckdns 폴더 만들기
```bash
sudo mkdir -p ~/duckdns
cd ~/duckdns
```

3) duck.sh 쉘스크립트 작성
```bash
sudo vi duck.sh
esc, i
esc, :wq!
```
```bash
echo url="https://www.duckdns.org/update?domains=도메인명&token=복사해둔토큰&ip=" | curl -k -o ~/duckdns/duck.log -K -

echo url="https://www.duckdns.org/update?domains=the703-js&token=45aa8fef-240e-4df8-b5b8-84a7132587a0&ip=" | curl -k -o ~/duckdns/duck.log -K -
``` 
※ -k : ssl/tls 인증서 건너뛰기
※ -o ~/duckdns/duck.log : 성공하면 ok 실패시 ko
※ -K : 표준 입력의 설정 - 코드 중간에 | curl 설정파일 형태로 읽어들이기

4) 실행 권한주기 - 소유자 모든 권한, 그룹X, 다른X
```bash
sudo chmod 700 duck.sh
crontab -e
2

# i - 맨 아랫줄에 붙이기
*/5 * * * * /home/ubuntu/duckdns/duck.sh >/dev/null 2>&1
#분 시 일 월 요일
# */5 * * * * 5분마다
#(년)월일 시분(초) 읽는 방향 ←

# >/dev/null 화면에 안 띄우기
# 2>&1 에러메시지 무시하기
```

3. Nginx 설정 변경
1) 설정파일 수정
```bash
sudo vi /etc/nginx/sites-available/default
#  esc , i

server {
    listen 80;
    server_name the703-js.duckdns.org;
    #   ... 기존내용그대로  ...
}
# esc  :wq!
```

2) Nginx 재시작
```bash
sudo nginx -t
sudo systemctl restart nginx

# 변경된 내용이 메모리에 반영되지 않아 경고가 떴을 경우
sudo systemctl daemon-reload
sudo systemctl restart nginx
```

4. Certbot으로 https(SSL) 인증서 발급받기
1) certbot 설치
```bash
sudo apt update
sudo apt install snapd -y # 격리된 환경 제공
sudo snap install core 
sudo snap refresh core
sudo snap install --classic certbot # certbot SSL 무료 인증서 발급 도구
sudo ln -s /snap/bin/certbot /usr/bin/certbot # 터미널 어디에서든지 certbot 사용 가능
```

2) 인증서 발급 명령어 실행
```bash
# sudo certbot --nginx -d mytestapp.duckdns.org
sudo certbot --nginx -d the703-js.duckdns.org

# email 입력 - 만료 알림용, 약관동의 y, 이메일 수신 y, 리다이렉트 설정 2

```

5. 프로젝트 환경 변수 및 설정 수정
> before : http://13.125.236.249/
> after  : https://the703-js.duckdns.org

1) boot : SecurityConfig, yml
2) react : .env

6. 소셜 마무리
1) 카카오 개발자
https://developers.kakao.com/

2) 네이버 개발자
https://developers.naver.com/main/

3) 구글콘솔 개발자
https://console.cloud.google.com/apis/dashboard

```
https://the703-js.duckdns.org/login/oauth2/code/kakao

https://the703-js.duckdns.org/login/oauth2/code/naver

https://the703-js.duckdns.org/login/oauth2/code/google

```