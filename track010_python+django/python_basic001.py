# ==============================================================================
# 00. 설치 및 환경 설정 가이드 (터미널에서 먼저 실행)
# ==============================================================================
# 0) python.org
#   vs code : Extension - python Extension pack / python indent
# 1) 파이썬 설치 확인: python --version / python -V
# 2) 가상환경 생성: python -m venv venv
# 3) 가상환경 활성화:
#    - Windows (CMD): venv\Scripts\activate
#    - Windows (PowerShell): .\venv\Scripts\Activate.ps1
#    - Windows (Git Bash) / Mac / Linux: source venv/Scripts/activate (Mac은 venv/bin/activate)
#    * 활성화 성공 시 터미널 왼쪽에 (venv) 가 표시됩니다.
# 4) 필수 패키지 설치: pip install numpy pandas
# ==============================================================================

# ==============================================================================
# [1교시] Python 핵심 (Java/JS 문법 비교 및 핵심 문법)
# ==============================================================================
# 1) ; 사용하지 않고
# 2) {} 사용하지 않고 들여쓰기로 코드블록 구분
# 3) 타입 선언 명시하지 않음(int, float, String, Boolean ...)

print("\n\n--- [1] Python 핵심 ---")
print("\n--- 0. 변수 선언 및 출력 ---")
### int, String / const, let, var 키워드가 필요하지 않음.
### 변수명 = 값 (js는 true, false / python은 True, False)
age = 33
name = "PYTHON"
is_active = True

# f-string
print(f"이름은 {name}, 나이는 {age}살. 활성화 상태: {is_active}!")

#Q. day라는 변수 만들어서 "금요일" 넣기
day = "금요일"

#Q. f-string으로 출력
print(f"오늘은 {day}!")

print("\n--- 1. 제어문 (if) ---")
# 1. if(조건){} ()생략가능
# if 조건 : 
#   들여쓰기가 맞아야 블록 인식
# 2. else if → elif
if age>=20 :
    print(f"{name}은 성인입니다.")
else :
    print(f"{name}은 미성년자입니다.")

print("\n--- 2. 반복문 (for i in range) ---")
# java : for(int i=1;i<4;i++){  }
# python : for i in range(1, 4) : 
# 한 개 in 영역 range(1,4) : 1부터 4전까지
for i in range(1, 4) :
    print(f"카운트 : {i}")

print("\n--- 3. 리스트(List) ---")
# java의 ArrayList
fruits = ["apple", "banana", "coconut"]

print(f"과일 리스트: {fruits}")
for i in fruits :
    print(i)

fruits.append("orange") # js에서는 push(), java에서는 add()
print(f"추가 후 과일리스트 : {fruits}")
print(f"리스트의 0번째 과일 : {fruits[0]}")
print(f"리스트의 -1번째 과일 : {fruits[-1]}") # 뒤에서부터 카운트 / 맨 뒤 요소 추출

print("\n--- 4. 딕셔너리(Dictionary) ---")
# java의 HashMap : key-value
# json 형태로 데이터 가공
user_info = {"name" : "ALPHA", "role" : "admin", "level" : 5}

user_info["level"] += 1 #기존의 key의 value 수정 / 없으면 새로 key-value 추가

print(f"딕셔너리 {user_info}")
print(f"User의 이름은 {user_info['name']}입니다.")
print(f"User의 역할은 {user_info['role']}, 레벨은 {user_info['level']}입니다.")


print("\n--- 5. 컴프리헨션(Comprehension) ---")
# java의 Lambda식   .filter().map()...

# 짝수 찾아서 짝수의 제곱
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

##         1) for i in ranges
es = [i**2 for i in numbers if i%2==0 ] ## 4) 리스트에 담기
##   3)제곱                 2) 짝수 고르기
print(f"짝수 찾아서 제곱 : {es}")


## 예시2)
categories = ["커뮤니티", "커머스", "콘텐츠"]
cs = { i: 0 for i in categories }
#   3) {} 2)결과물을 0으로 세팅 1) for 이용해서 하나씩 key
print(f"딕셔너리 초기값들을 0으로 세팅: {cs}")

# ------------------------------------------------------------------------------
# ✏️ [연습문제 01 - Python 기초 및 컴프리헨션]
# ------------------------------------------------------------------------------

scores = [45, 75, 88, 52, 95, 60]
members = ["kim", "lee", "park"]

# Q1. scores 리스트에서 60점 이상인 점수만 10점씩 가산한 `passed_scores` 리스트를 만드세요.
# Q2. members 리스트의 각 이름을 Key로, "OFFLINE"을 Value로 갖는 `status_dict` 딕셔너리를 만드세요.

# --- [작성 공간] ---
passed_scores = [i+10 for i in scores if i>=60]
status_dict = {i:"OFFLINE" for i in members}

# 🎯 [목표 출력 결과]
# Q1 결과: [85, 98, 105, 70]
# Q2 결과: {'kim': 'OFFLINE', 'lee': 'OFFLINE', 'park': 'OFFLINE'}

# --- [출력 확인 공간] ---
print("\n--- [연습문제 01 결과 확인] ---")
print("Q1 결과:", passed_scores)
print("Q2 결과:", status_dict)


# ==============================================================================
# [2교시] NumPy 기초: 수치 데이터 및 배열 다루기
# ==============================================================================
# NumPy (Number Python) 수치 데이터 계산, C언어 구현 데이터 고속처리
# 파이썬의 list는 메모리 주소를 참조해서 속도가 느림


print("\n\n--- [2] NumPy 기초 ---") # a ze a
import numpy as np
# np.array([])              : 기존 파이썬 리스트를 NumPy 배열로 변환
# np.zeros(shape)           : 지정 크기만큼 0으로 채워진 배열
# np.arrange(start, end)    : start부터 end 전까지 연속된 배열

print("\n--- 1. 1차원 및 2차원 배열(NDArray) 생성 ---")
# 1. 배열
# shape : 1차원 배열(5,) 2차원 배열(2,3) 3차원(2,2,3)
arr1 = np.array([10, 20, 30, 40, 50])
print(f"1차원 배열 : {arr1}")
print(f"Array Shape : {arr1.shape}")

arr2 = np.array([[1,2,3], [4,5,6]])
print(f"2차원 배열 : {arr2}")
print(f"Array Shape : {arr2.shape}")

arr3 = np.array([
    [[1,2,3], [4,5,6]], 
    [[7,8,9], [10,11,12]]
])
print(f"3차원 배열 : {arr3}")
print(f"Array Shape : {arr3.shape}")

##Q. 3행 2열 [방문자수, 매출액] 형태
data_2d = np.array([
    [150, 20000],
    [300, 50000],
    [500, 70000]
])

print(f" 방문매출 2d배열 : {data_2d}")
print(f" Array Shape : {data_2d.shape}")

zero_arr = np.zeros((2,3))  #2층 3칸 0으로 채워진 공간
seq_arr = np.arange(1,6)   # [1,2,3,4,5] 생성
print(f" zeros 2d배열 : {zero_arr}")
print(f" arange(1,6) 1d배열 : {seq_arr}")


print("\n--- 2. 인덱싱 및 슬라이싱 [행, 열] ---")
# data_2d = np.array([
#     [150, 20000],
#     [300, 50000],
#     [500, 70000]
# ])

# [행, 열] 범위 지정
# [start:end] start부터 end 전까지 범위 지정
# 범위 `:`  if 조건 :   , for i in range : 
# data_2d[: , 0] 모든 행(:)의 0번째 열(방문자 수)
visitors = data_2d[:, 0]    #방문자 수 컬럼만 추출 행(:), 열(0)
print(f"방문자 수 추출 : {visitors}")

sales = data_2d[:, 1]
print(f"매출액 추출 : {sales}")

print(data_2d[0])   # 결과 [  150 20000]
print(data_2d[0:1]) # 결과 [[  150 20000]] # 0부터 1전까지
print(data_2d[0:2]) # 결과 [[  150 20000] [  300 50000]] # 0부터 2전까지

print("\n--- 3. 조건부 추출 (Boolean Indexing) ---")
# 매출액이 30000 넘었니? [False, True, True]
# sql : where sales >= 30000
# Q [행, 열] 이용해서 매출액만 추출
sales_30000 = data_2d[:,1] >= 30000
print(f"매출액 3만 이상 필터링 : {sales_30000}") # [False  True  True]
print(f"필터링된 실제 데이터: {data_2d[sales_30000]}") #  [[  300 50000] [  500 70000]]


print("\n--- 4. 수치 통계 연산 및 Axis(축) 연산 ---")
# 통계 함수 : 평균-mean, 합계-sum, 최대값-max, 표준편차-std
print("방문자수 평균 :", np.mean(visitors))
print("총 매출액 합계 :", np.sum(sales))
print("방문자수 최대 :", np.max(visitors))
print("매출액 표준편차 :", np.std(sales)) #평균에서 멀어진 정도
# 표준편차 : 100, 100, 100(평균 100) 표준편차 0 - 비슷한 정도
# 표준편차 : 0, 100, 200(평균 100) 표준편차가 크다

# axis(축) 옵션
# axis=None(기본값) : 전체 요소를 통틀어서 계산
# axis=0    : 열(Column) 방향으로 계산(세로)
# axis=1    : 행(Column) 방향으로 계산(가로)
col_sums = np.sum(data_2d, axis=0) 
print(f"Axios=0, 열(세로)방향 합계: {col_sums}")

# ------------------------------------------------------------------------------
# ✏️ [연습문제 02 - NumPy 다차원 배열 연산]
# ------------------------------------------------------------------------------
# store_data는 4개 매장의 [주문 건수, 총 결제 금액] 데이터입니다.
# Q1. 주문 건수(0번 열)가 30건 이상인 매장의 데이터만 추출하여 `over_30_stores`에 저장하세요.
# Q2. 전체 매장의 총 결제 금액(1번 열) 합계(`total_pay`)와 주문 건수(0번 열)의 평균(`avg_orders`)을 구하세요.
#
# 🎯 [목표 출력 결과]
# Q1 결과 (주문 30건 이상 매장):
# [[    40 120000]
#  [    85 250000]
#  [    50 180000]]
# Q2 결과 -> 총 결제 금액: 585000원, 평균 주문 건수: 47.5건

store_data = np.array([
    [40, 120000],
    [15, 35000],
    [85, 250000],
    [50, 180000]
])

# --- [작성 공간] ---
# 주문 건수가 30건 이상인 매장
over_30_stores = store_data[store_data[:, 0] >= 30]

# 총 결제금액 합계
total_pay = np.sum(store_data[:, 1])

# 주문건수 평균
avg_orders = np.mean(store_data[:, 0])


# --- [출력 확인 공간] ---
print("\n--- [연습문제 02 결과 확인] ---")
print("Q1 결과 (주문 30건 이상 매장):\n", over_30_stores)
print(f"Q2 결과 -> 총 결제 금액: {total_pay}원, 평균 주문 건수: {avg_orders}건")


# ==============================================================================
# [3~4교시] Pandas 데이터 정제 & 실전 집계 (EDA)
# ==============================================================================
# Pandas - 엑셀이나 관계형 데이터베이스의 테이블 형태
# 핵심객체
# 1) Series : 1차원 데이터(1개의 컬럼)
# 2) DataFrame : 2차원데이터(행과 열로 구성된 표 형태)


print("\n\n--- [3] Pandas 데이터 정제 & 실전 집계 ---")
import pandas as pd

raw_data = [
    {'date': '2026-06-01', 'category': '커뮤니티', 'visitor_count': 150, 'sales_amount': 10000},
    {'date': '2026-06-01', 'category': '커머스', 'visitor_count': 300, 'sales_amount': 50000},
    {'date': '2026-06-02', 'category': '커뮤니티', 'visitor_count': 200, 'sales_amount': 15000},
    {'date': '2026-06-02', 'category': '콘텐츠', 'visitor_count': 400, 'sales_amount': 25000},
    {'date': '2026-06-03', 'category': '커머스', 'visitor_count': 500, 'sales_amount': 80000},
]

print("\n--- 1. 샘플 데이터 생성 및 DataFrame 변환 ---")
# DB에서 select * from 테이블명
# DataFrame
df = pd.DataFrame(raw_data)
print(df)


print("\n--- 2. 데이터 탐색 메서드 (head, info, describe) ---")
# head() : 상단 미리보기 (기본값 5)
# info() : 전체행 개수, 컬럼 데이터타입, Null(결측치) 존재여부 확인
# describe() : 평균, 표준편차, 사분위수 등 요약 통계량

print("\n2-1. 상단 미리보기 head")
print(df.head())
print()
print(df.head(2))

print("\n2-2. 데이터구조 및 타입 확인 info")
df.info()
# <class 'pandas.DataFrame'>
# RangeIndex: 5 entries, 0 to 4
# Data columns (total 4 columns):
#  #   Column         Non-Null Count  Dtype
# ---  ------         --------------  -----
#  0   date           5 non-null      str  
#  1   category       5 non-null      str  
#  2   visitor_count  5 non-null      int64
#  3   sales_amount   5 non-null      int64
# dtypes: int64(2), str(2)
# memory usage: 292.0 bytes

print("\n2-3. 수치형 데이터 기술통계 describe")
print (df.describe())
#        visitor_count  sales_amount
# count       5.000000      5.000000
# mean      310.000000  36000.000000
# std       143.178211  29025.850547
# min       150.000000  10000.000000
# 25%       200.000000  15000.000000
# 50%       300.000000  25000.000000
# 75%       400.000000  50000.000000
# max       500.000000  80000.000000

print("\n--- 3. 조건 조회 (Boolean Filtering) 및 파생 컬럼 생성 ---")
# df[ 컬럼 > 조건 ] 특정 조건의 행만 추출 (가로방향의 데이터)
# df[새컬럼명] = 연산식     기존 컬럼 계산하고 새로운 컬럼 생성

# 방문자 수가 200명 이상
over_200_df = df[ df["visitor_count"] >= 200]
df['avg_spend'] = df['sales_amount'] / df['visitor_count'] # 1인당 평균 결제금액

print(f"방문자 200명 이상 필터링 : {over_200_df}")
print(f"총 매출액 : {df['sales_amount']}")
print(f"평균 추가 : {df['avg_spend']}")

print("\n--- 4. 핵심 그룹화 연산 (groupby) ---")
# SQL - groub by 기준필드
# df.groupby(그룹기준컬럼)
# sum() 합계
# reset_index() 인덱스 번호 초기화 0, 1, 2 ...

summary_df = df.groupby('category')[['visitor_count', 'sales_amount']].sum().reset_index()
print(summary_df)

print("\n--- 5. 분석 결과를 파이썬 리스트로 추출 ---")
# toList() : 파이썬 List `[]` 포맷 변환, Chart.js, 그래프 그릴 때
categories_list = summary_df['category'].tolist()
visitor_list = summary_df['visitor_count'].tolist()
sales_list = summary_df['sales_amount'].tolist()

print(f"카테고리 목록(x축) : ", categories_list)
print(f"방문자수 합계(y축) : ", visitor_list)
print(f"매출액 합계(y축) : ", sales_list)

# ------------------------------------------------------------------------------
# ✏️ [연습문제 03 - Pandas 필터링, 컬럼 생성 및 Groupby]
# ------------------------------------------------------------------------------
log_data = [
    {'server': 'Server_A', 'status_code': 200, 'response_time_ms': 120},
    {'server': 'Server_B', 'status_code': 500, 'response_time_ms': 450},
    {'server': 'Server_A', 'status_code': 200, 'response_time_ms': 150},
    {'server': 'Server_B', 'status_code': 200, 'response_time_ms': 200},
    {'server': 'Server_A', 'status_code': 404, 'response_time_ms': 80},
]
# Q1. log_df에서 status_code가 200인 행만 추출해 `success_df`를 만드세요.
log_df = pd.DataFrame(log_data)
success_df = log_df[log_df['status_code'] == 200]

# Q2. log_df에 response_time_ms를 1000으로 나눈 `response_time_sec` 컬럼을 추가하세요.
log_df['response_time_sec'] = log_df['response_time_ms'] / 1000

# Q3. server별 response_time_ms의 평균을 구해 `server_summary` DataFrame을 만들고, 
#     서버 이름 목록을 `server_list` 파이썬 리스트로 추출하세요.
server_summary = log_df.groupby('server')[['response_time_ms']].mean().reset_index()
server_list = server_summary['server'].tolist()

print(f"서버 이름 목록 : ", server_list)

# --- [출력 확인 공간] ---
print("\n--- [연습문제 03 결과 확인] ---")
print("Q1 결과 (정상 응답):\n", success_df)
print("\nQ2 결과 (서버별 평균 응답시간 집계):\n", server_summary)
print("Q3 리스트 변환 결과:", server_list)

# 🎯 [목표 출력 결과]
# Q1 결과 (정상 응답):
#      server  status_code  response_time_ms
# 0  Server_A          200               120
# 2  Server_A          200               150
# 3  Server_B          200               200
#
# Q3 결과 (서버별 평균 응답시간 집계):
#      server  response_time_ms
# 0  Server_A        116.666667
# 1  Server_B        325.000000
# Q3 리스트 변환 결과: ['Server_A', 'Server_B']