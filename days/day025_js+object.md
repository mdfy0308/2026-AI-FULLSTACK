## 1. 복습문제

복습문제 (1)



```java

// ### Q1. 다음의 상속도를 그리시오.
// ### Q2. 상속도에서  각각의 클래스에서 사용가능한 멤버변수/멤버함수를  적으시오.

		Animal {name / eat(), sleep(), poo() }
			↑							      ↑	
	  	   Cat								Dog
{name / @eat(), @sleep(), @poo()}		{name / @eat(), @sleep(), @poo()}


abstract class Animal{    
   String name; 
   abstract void eat();   
   abstract void sleep(); 
   abstract void poo();  
}
class Cat  extends Animal{  // 구현클래스 - 고양이는 동물이다
   @Override void eat()   {  System.out.println(super.name + "고양이 냠냠!");  }
   @Override void sleep() {  System.out.println(super.name + "고양이 수면!");  }
   @Override void poo()   {  System.out.println(super.name + "고양이 시원");  }
}
class Dog  extends Animal{  // 구현클래스 - 강아지는 동물이다
   @Override void eat()   {  System.out.println(super.name + "강아지 냠냠!");  }
   @Override void sleep() {  System.out.println(super.name + "강아지 수면!");  }
   @Override void poo()   {  System.out.println(super.name + "강아지 시원");  }
}
public class Abstract001 {
   public static void main(String[] args) {
      //1. abstract  class : 일반클래스 + 설계
	   // Animal ani = new Animal();   
		
// ### Q3. 이 코드에서 오류나는 이유는? 
	   // abstract는 {}구현부가 없으므로 실체화되지 않는다.
    
      Animal ani = null;
		ani = new Cat();

// ### Q4.    업캐스팅/다운캐스팅 ? 
      // 부모←자식 업캐스팅

		ani.name = "sally";   // ani.eat();
		
      //2. 사용목적
		// 한가지 타입으로 여러 객체를 관리
		Animal [] arr = {new Cat() , new Cat() , new Dog() , new Dog() };
		int cnt=0;
		
//### Q5.  다음이 출력되게 코드를 작성하시오.
		/*  ani1고양이 냠냠!
		    ani2고양이 냠냠!
		    ani3강아지 냠냠!
		    ani4강아지 냠냠!   */
	
		for(Animal a : arr) {
			a.name = "ani" + ++cnt;
			a.eat();
		}
    }
}
```



복습문제 (2)

### Q6. 오류나는 부분을 주석달고 이유를 적으시오.

```java
class Papa{  int brain; }
class Mama{  int brain; }
// class Son extends Papa, Mama{} 
// extends로 다중 상속 불가 / 상속받은 것이 어느 클래스의 변수인지 알 수 없음
```
interface Animal2{
     

### Q7.  interface에서의 멤버변수에 붙는 키워드는?
   String company="(주) thejoa"; 
   // static final, 클래스 변수
   
### Q8.  interface에서의 멤버함수에 붙는 키워드는?
   void eat(); 
   // abstract, 구현부 없음
}

class Saram implements Animal2{ 
   @Override public void eat() { 
      company="kakao";  
      System.out.println( Animal2.company  + " 랍스탑.... 냠냠 "   );
   }
}



복습문제 (3)
```java
interface Vehicle {  public void run();    } 

class MotorCycle implements Vehicle {
   @Override   public void run() {   System.out.println("오토바이가 달립니다.");   }
    public void helmat() {   System.out.println("헬멧을 착용합니다.");   }
}
class Car implements Vehicle {
   @Override  public void run() {     System.out.println("자동차가 달립니다.");   }
}

// ### Q9.  Driver 클래스를 작성하시오.

class Driver {
    void drive(Vehicle v){
        if(v instanceof MotorCycle) { ((MotorCycle)v).helmet(); }
        v.run();
    }
}


public class InterfaceEx002{
   public static void main(String[] args) {
      Driver driver = new Driver();
      
      Car car = new Car();
      MotorCycle mo = new MotorCycle();
      
      driver.drive(car);
      driver.drive(mo);
   }
}
```
>> 실행화면
자동차가 달립니다.

헬멧을 착용합니다.
오토바이가 달립니다.     




## 2. java

part1. 제어문 - 절차지향

part2. OOP - 객체지향
   2-1. 클래스 사용 ( 클래스 VS 객체 )
   2-2. 클래스 설정 (static, final, public ■캡슐화)
   2-3. 클래스 ■상속 : 재활용
   2-4. ■다형성 : 하나의 타입(부모)으로 여러 객체(자식)를 관리함 (상속 먼저)
   2-5. ■추상화 : 공통적인 속성 뽑기

part3. OOP - 활용
   1. 콜렉션 프레임 워크
   2. lambda + stream
   3. io
   4. network (Thread)

