package com.the703.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/*
Q1. Player DTO 클래스 만들기
속성:
private String name;
private int score; 
*/

class Player {
	private String name;
	private int score;
	
	public Player() { super();  }
	public Player(String name, int score) { super(); this.name = name; this.score = score; }
	
	@Override
	public String toString() { return "Player [name=" + name + ", score=" + score + "]"; }
	public String getName() { return name; } 
	public void setName(String name) { this.name = name; } 
	public int getScore() { return score; } 
	public void setScore(int score) { this.score = score; }
	
	@Override public int hashCode() { return Objects.hash(name, score); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(name, other.name) && score == other.score;
	} 
}

public class Day029 {
	public static void main(String[] args) {
		
		//players 이름으로 ArrayList 만들기
		List<Player> players = new ArrayList<>();
		
		//2-2. 데이터 추가:
		players.add(new Player("Mario", 1200));
		players.add(new Player("Luigi", 1500));
		players.add(new Player("Peach", 1800));
		players.add(new Player("Bowser", 900));
		players.add(new Player("Bowser", 900));
		
		//2-3. for + size 이용해서 출력
		for(int i=0;i<players.size();i++) {
			System.out.printf("%d\t%s\t%d\n", (i+1), players.get(i).getName(), players.get(i).getScore());
		};
		
		// Q3. List에서 출력을 보면 Bowser   900  라는 같은데이터를 넣었는데 2개가 나옴. 이유는?
		// List는 배열의 단점을 개선한 클래스로, 순서가 있고 중복을 허용함
		
		//4-1. setPlayers 이름으로 HashSet 만들기
		Set<Player> setPlayers = new HashSet<>();
		
		//4-2. 동일한 데이터 넣기 (중복 허용 안됨)
		setPlayers.add(new Player("Mario", 1200));
		setPlayers.add(new Player("Luigi", 1500));
		setPlayers.add(new Player("Peach", 1800));
		setPlayers.add(new Player("Bowser", 900));
				
		//4-3. Iterator 이용해서 출력
		Iterator<Player> iter = setPlayers.iterator();
		int cnt = 1;
		while(iter.hasNext()) {  
			Player p = iter.next(); 
			System.out.printf("%d\t%s\t%d\n", cnt++, p.getName(), p.getScore());
		}
		
		//5-1. mapPlayers 이름으로 HashMap 만들기
		Map<String, Player> mapPlayers = new HashMap<>();
		
		//5-2.  데이터 넣기 (Key-Value 구조)
		mapPlayers.put("mario", new Player("Mario", 1200));
		mapPlayers.put("luigi", new Player("Luigi", 1500));
		mapPlayers.put("peach", new Player("Peach", 1800));
		mapPlayers.put("bowser", new Player("Bowser", 900));
		
		//5-3. for-each + entrySet 이용해서 출력
		for(String key : mapPlayers.keySet()) {
			System.out.printf("%s\t%s\t%d\n", key, mapPlayers.get(key).getName(), mapPlayers.get(key).getScore());
		}
		
		// 6-1. List코드에서 익명 클래스로 점수 오름차순 정렬
		players.sort(new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				return Integer.compare(p1.getScore(), p2.getScore());
			}
			
		});
		
		// 6-2. 람다식으로 점수 내림차순 정렬
		players.sort( (p1, p2) -> Integer.compare(p1.getScore(), p2.getScore()) );
		
		
		// 6-3. 메서드 참조로 점수 오름차순 정렬
		players.sort(Comparator.comparingInt(Player::getScore) );

		cnt=1;
		for(Player p:players) { 
			System.out.printf("%d\t%s\t%d\n", cnt++, p.getName(), p.getScore());
		}
		
	} //
} //
