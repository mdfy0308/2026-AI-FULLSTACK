package com.the703.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagingUtil {

	private int listtotal;		// 전체글 갯수
	private int onepagelist;	// 한 페이지에 보여줄 게시물의 수
	private int pagetotal;		// 전체 페이지 수
	private int bottomlist;		// 하단의 페이지 나누기 : 이전 1 2 3 ... 9 10 다음
	private int pstartno;		// 페이지 시작번호

	private int current;		// 현재 페이지 번호 8
	private int start;			// 시작 1
	private int end;			// 마지막 20
	
	
	public PagingUtil(int listtotal, int pstartno) { //전체글 수, 시작하는 번호
		super();
		this.listtotal   = listtotal; // 전체글 수
		this.onepagelist = 10;		  // 한 페이지에 보여줄 게시물의 수
		this.pagetotal	 = listtotal <= 0 ? 1 : 
						   (int)Math.ceil(listtotal/(double)onepagelist);
		this.bottomlist  = 10;
		this.pstartno 	 = (pstartno-1)*onepagelist;   // (1) 1-0, 10개 (2) 2-10, 10개 (3) 3-10, 10개
		this.current	 = pstartno;
		this.start		 = ((this.current-1)/this.bottomlist) * this.bottomlist +1;
		this.end  	     = ((this.start)) + this.bottomlist -1;
		
		if(this.end > this.pagetotal) { this.end = this.pagetotal; }
	}
	
}
