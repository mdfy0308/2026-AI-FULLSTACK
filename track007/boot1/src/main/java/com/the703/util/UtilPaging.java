package com.the703.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UtilPaging {
	private int listtotal;		// 전체글 193
	private int onepagelist;	// 한페이지에 보여줄 게시물의 수 10
	private int pagetotal;		// 전체글/보여줄 수. 193/10 → 19페이지 + 3글 = 20페이지
	private int bottomlist;		// 하단페이지수 10
	private int pstartno;		// 페이지 시작번호(1) 1, 10
	private int current;		// 현재 페이지 번호
	private int start;			// 시작 번호
	private int end;			// 끝 번호
	
	public UtilPaging(int listtotal, int pageNo) { this(listtotal, pageNo, 10, 10); }
	//한페이지 10, 하단 네비 10 기본

	public UtilPaging(int listtotal, int pageNo, int onepagelist, int bottomlist) {
		this.listtotal = (listtotal <= 0) ? 1 : listtotal;
		this.onepagelist = onepagelist; 
		this.pagetotal = (int) Math.ceil(this.listtotal / (double) onepagelist);
		// 193/10 	→ 19.3 	→ 올림 	→	20
		// 200/10 	→ 20 	→ 올림을 해도	20
		this.bottomlist = bottomlist;
		this.current = pageNo; // 23 → start=21, end 30
		
		this.start = ((current - 1) / bottomlist) * bottomlist + 1;
		// 21 → (21-1)/10 → 앞자리를 2로 * 10 + 1
		// 30 → (30-1)/10 → 앞자리를 2로 * 10 + 1
		
		this.end = start + bottomlist - 1;
		// 21 + 10 - 1 = 30
				
		if (end > pagetotal) { end = pagetotal; }
		// 30 > 26 → 마지막은 26으로
		this.pstartno = (pageNo - 1) * onepagelist + 1;
	}
}
