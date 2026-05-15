package com.the703.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1. Dto 데이터전송목적 (기본생성자, 필드생성자, toString, getter/setter, HashCode, equals)
class BankDto{
	private String id;
	private String pass;
	private double balance; // 멤버변수
	
	public BankDto() { super();	}
	public BankDto(String id) { super(); this.id = id; }
	public BankDto(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankDto [id=" + id + ", pass=" + pass + ", balance=" + balance + "]";
	}

	public String getId() { return id; }  
	public void setId(String id) { this.id = id; }  
	public String getPass() { return pass; }  
	public void setPass(String pass) { this.pass = pass; }  
	public double getBalance() { return balance; }  
	public void setBalance(double balance) { this.balance = balance; }

	@Override public int hashCode() { return Objects.hash(id); }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankDto other = (BankDto) obj;
		return Objects.equals(id, other.id);
	}  
}

class Bank{
	List<BankDto> users;   // 객체를 생성하는게 아니라 정보만 받을 목적
	
	public Bank() { super(); }
	public Bank(List<BankDto> users) { super(); this.users = users; }
	
	// 메뉴 - 안에 내용작성
	void menu() {
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		
		while(menu != 9) {
			System.out.println("========BANK========");
			System.out.println("* 1.➕ 계좌 추가");
			System.out.println("* 2.🔍 계좌 조회");
			System.out.println("* 3.💵 입금하기");
			System.out.println("* 4.💸 출금하기");
			System.out.println("* 5.🗑️ 계좌 삭제");
			System.out.println("* 9.✖ 종료");
			System.out.print("입력 >>> ");
			
			menu = sc.nextInt();
			
			if(menu == 1) { add(); }
			else if(menu > 5 && menu < 9) { System.out.println("없는 메뉴입니다."); continue; }
			else {
				//로그인
				BankDto find = login(); //로그인 확인
				if(find == null) {	System.out.println("정보를 확인해주세요."); continue; }
				
				//메뉴에 맞는 기능 호출
				switch(menu) {
				case 2: show(find); break;
				case 3: deposit(find); break;
				case 4: withdraw(find); break;
				case 5: delete(find); break;
				case 9: exit(); break;
				}				
			}
		}
	} // menu end
	
	// 유저추가 (add)
	void add() {
		//변수
		Scanner sc = new Scanner(System.in);
		
		//입력 - 사용자에게 정보입력받기
		System.out.print("아이디 입력 : "); String id = sc.next();
		System.out.print("비밀번호 입력 : "); String pass = sc.next();
		System.out.print("잔액 입력 : "); double balance = sc.nextInt();
				
		//처리 
		users.add( new BankDto(id, pass, balance) );

	}
	// 유저 로그인 			유저 정보 
	BankDto login(){ 
		//변수
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("아이디 입력 : "); String id = sc.next();
		System.out.print("비밀번호 입력 : "); String pass = sc.next();
		
		//처리
		for(BankDto u : users) {
			if(u.getId().equals(id) && u.getPass().equals(pass)) { return u; }
		}
		return null; 
	}
	
	void show(BankDto user) {
		System.out.printf("ID: %s\nPASS: %s\nBALANCE: %.2f\n", user.getId(), user.getPass(), user.getBalance());
	}
	
	// 입금   (get) 		
	void deposit(BankDto user){
		Scanner sc = new Scanner(System.in);
		System.out.println("입금할 금액: ");
		double price = sc.nextDouble();
		user.setBalance(user.getBalance() + price);
		System.out.println("===입금 완료===");
		System.out.println("잔액: " + user.getBalance());
	}
	
	// 출금   (get) 		
	void withdraw(BankDto user){
		Scanner sc = new Scanner(System.in);
		System.out.println("출금할 금액: ");
		double price = sc.nextDouble();
		
		if(price > user.getBalance()) {
			System.out.println("잔액이 부족합니다.");
			System.out.println("잔액: " + user.getBalance());
		} else {
			user.setBalance(user.getBalance() - price);
			System.out.println("===출금 완료===");
			System.out.println("잔액: " + user.getBalance());
		}
	}
	
	// 유저삭제(remove) 	
	void delete(BankDto user){
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌를 삭제하시겠습니까? Y/N");
		String ans = sc.next();
		
		if(ans.toLowerCase().equals("y")){
			users.remove(user);
			System.out.println("===삭제 완료===");
		}
	}
	
	// 종료   			
	void exit(){
		System.out.println("종료합니다.");
	}
}

public class BankProjectV4 {
	public static void main(String[] args) {
		
		List<BankDto>  users = new ArrayList<>();
		Bank      controller = new Bank(users);
		controller.menu();
			
	} // end main
} // end class
