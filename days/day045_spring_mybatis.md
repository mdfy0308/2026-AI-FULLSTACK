## 복습문제

#1. 프레임워크
   - 소프트웨어 개발의    [  #1.      ] 역할
   - 실행흐름 담당
#2. IOC
   -  인스턴스 생성~ 소멸까지 [#2.       ]를  [#3.         ]이 관리
#3. DI
   각 클래스의 의존관계를 [#4.        ]을통해서 컨테이너가 자동연결
#4. BEAN
   -  [#5.        ]

#5.  예시
---------------------------------
1) 롬복사용하려고함. 생성자, getter/setter까지 자동 생성되게

 [     ] #6
class MyA{
   private String name;
   private Animal ani;

   public MyA(String name, Animal ani){
      this.name = name;
      this.ani = ani;
   }
}
---------------------------------
1. setter 방식    #7
  다음에 해당하는 코드를 클래스 설정파일에 셋팅하시오.
     MyA myA = new MyA()  
     myA.setName("sally");
     myA.setAni("cat" );


<bean id="cat"  class="com.company.Cat"/>       
<bean    ="myA"       ="com.company.MyA">     #7-1
   <property  ="name"    ="sally"/>   #7-2
   <property  ="ani"       ="cat"/>   #7-3
</bean>

2.  생성자
다음에 해당하는 코드를 클래스 설정파일에 셋팅하시오.
     MyA myA = new MyA("sally" , "cat" );

<bean  id=""  class="com.company.MyA">    #8-1
   <constructor-arg    ="0"    ="sally"/>   #8-2
   <constructor-arg    ="1"    ="ani"/>    #8-3
</bean>

3. di-properties
다음과 같이 셋팅설정파일- config/test.properties
name=sally
ani=cat
다음에 해당하는 코드를 클래스 설정파일에 셋팅하시오.

<context:                    location="classpath:config/test.properties"/>   #9-1
<bean  id="myA"  class="com.company.MyA">     #9-2
   <constructor-arg   index="0"   value="${name}"/>   #9-3
   <constructor-arg   index="1"   ref="${ani}"/>   #9-4
</bean>

#6.  스프링 - 실습
>  프로젝트만들기 - spring002_db_mysql

    1. dynamic web project - spring002_db_mysql
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path



## 2. Spring

---------------------
#3.  Bean
---------------------

1.  xml   vs  Annotation
>> xml : 운영
>> Annotation : 개발
XML - [운영] , 모든 Bean을 명시적으로 xml에 등록
    - 여러개발자가 같은 설정파일을 공유해서 개발하면 
      수정시 충돌이 일어날 경우가 많음.

2.@Component
- @Component 일반적인 컴포넌트  <bean> 스프링이 관리하는 객체
- @Component 구체화된 형식
   @Controller  웹요청받아서 응답
   @Service     서비스 레이어, 비즈니스 로직
   @Repository  데이터베이스

3. Bean 의존관계주입
   1. @Autowired - 정밀한 의존관계 
      - 프로퍼티, setter, 생성자,, 적용
   2. @Qualifier - 동일한타입의 bean 구분
   3. @Value  단순값
   4. @Resource - 자원연결(  .properties)   

4. component-scan
<context:component-scan  base-package="경로설정"/>



---------------------
#4.   DB  + Mybatis
---------------------
1. DataSource
+ SimpleDrdiverDataSource   - 가장단순한버젼

2. mybatis
- sql을 별도로 파일분리해서 관리
- orm (object relational mapping) 프레임워크

3. 설정내용
root-context.xml   환경정보설정
db.propertis       db정보설정
SqlSessionFacotryBean  : SqlSession 생성 및 관리
SqlSession           :  sql 실행 , 트랜잭션
mapper.xml


1. 테이블 만들기
no	int	NO		0	
name	varchar(100)	NO			
age	int	YES			

2. crud
insert              : insert into userinfo_e (email, age) values (?, ?)
select(전체)         : select * from userinfo_e
select(해당번호 읽기) : select * from userinfo_e where no=?;
update(해당번호 수정) : update userinfo_e set name='name' where no=?;
delete(해당번호 삭제) : delete from userinfo_e where no=?; 



## 4. 포트포리오 안내 - 팀회의 (주제)

1   JAVA, JSP웹프로그래밍 >  
   [spring + mysql + jsp + mybatis] board + 멤버관리  → 수업예제

2   프로젝트Ⅰ(완성된 웹서비스 플랫폼 프로젝트 리뉴얼)   > 미니프로젝트  (5일)
   1) crud 중점 :  새로운주제 - 관리자
   상품관리 
   재고관리     ....
   프로모션관리  

3   Spring & MyBatis & GPT   
   [spring boot + oracle + 타임리프 + mybatis + api]  → 수업예제    
   
4   프로젝트ⅡBtoC 웹서비스 구축(Spring Framework 활용)       
   2) api → 사용자측

5   Node.js & Express Server & React          
   [node + react]  → 수업예제    

6   프로젝트Ⅲ홍보/마케팅에 활용 가능한 SNS 사이트 제작(Node.js 와 React 활용)   
   back [spring boot +  jpa + jwt + redis + oauth2.0 + api]  
       +
   front[react + next]   → project3

7   MSA & 리눅스 & 클라우드      
    → project3

........................................................
> 이력서준비 / 진도 / 면접
8   Django & Fluter         
9   프로젝트Ⅳ 매출 및 생산성 향상 앱개발[플러터(DART)활용 ]
    → project4
........................................................   




