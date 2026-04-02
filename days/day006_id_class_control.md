- Todo1: css(2) 내부적용 / id vs class
- Todo2: java 제어문 - IF


### ■1.  복습문제 - 노트 준비 ~09:45

> 정리문제 (1)
1. 배경을 파란색으로 설정하는 속성은?    background-color:blue
2. 글자색상을 빨간색으로 지정하는 속성은?  
3. 글자 크기를 20px로 지정하는 속성은?  
4. 글자를 가운데 정렬하는 속성은?  
5. 글자에 밑줄을 추가하는 속성은?  
6. 글꼴을 Arial로 지정하는 속성은?  
7. 글자를 굵게 표시하는 속성은?  
8. 요소의 가로 길이를 300px로 지정하는 속성은?  
9. 요소의 바깥쪽 여백을 10px로 지정하는 속성은?  
10. 요소의 안쪽 여백을 15px로 지정하는 속성은?  
11. 요소에 1px 실선 테두리를 추가하는 속성은?  
12. 모서리를 둥글게 10px로 만드는 속성은?  
13. 그림자 효과를 추가하는 속성은?  
14. 천천히 움직이는 장면전환효과를 주는 속성은? 

> 정리문제 (2)
15.  가로 사이즈 지정가능한것은 block   /    inline
16.  a태그에 margin-top 줄수   o      /   x
17.  css 적용방법 3가지 (   /    /    )
18.  css 적용 내부적용방법은 (   ) 태그안에 (   ) 태그 적용해서 사용


> 정리문제 (3)
1.  연산자의 우선순위를 적으시오.
() {}
값
비교
조건
대입

2.  다음오류 해결
short sh1 = 1 , sh2=2;
short result = sh1 + sh2;

3. 필수조건
q1-1 int형 변수 x가 3보다 크고 10보다 작을때 true인 조건식 
q1-2 char형 변수 ch가 'a' 또는 'A'일때   true인 조건식    
q1-3 char형 변수 ch가 숫자('0'~'9')일때   true인 조건식     
q1-4 char형 변수 ch가 영문자(대문자 또는 소문자) 일때   true인 조건식



### ■2.  css 내부 적용 id, class

```html
 <div>
        <h3>id</h3>
        <p> css 선택자  - 유일한 값 </p>
        <dl>
            <dt> id 특징 </dt>
            <dd> html 문서에서 한번만 사용 가능 </dd>
            <dd id="id1"> 중복 불가 - Error: Duplicate ID </dd>
            <dd id="id2"> css에서는 #id명 </dd>
            <dd> 우선순위 id와 class 모두 있을 때 id가 더 높음 </dd>
        </dl>
    </div>

    <div>
        <h3>class</h3>
        <p> css 선택자 - 여러개 선택시 </p>
        <dl>
            <dt> class의 특징 </dt>
            <dd class="mycss"> 재사용 가능 : 여러 요소에 class 지정 가능 </dd>
            <dd class="mycss two"> 하나의 요소에 여러개의 class 사용 가능 </dd>
            <dd> css에서는 .class명 </dd>
            <dd> 반복되는 스타일에 적합 </dd>
        </dl>
    </div>
```

### ■3. java 제어문 if

1. CONTROL - IF

조건문
1. 프로그램 코드 실행 흐름
- 위에서 아래로, 왼쪽에서 오른쪽으로 
- 제어문은 개발자가 원하는 방향으로 변경할 수 있도록 도와줌.

2. 종류
- 조건문 : if, switch
- 반복문 : for, while, do while
- 제어 키워드 : break, continue



### ■4. 복습문제