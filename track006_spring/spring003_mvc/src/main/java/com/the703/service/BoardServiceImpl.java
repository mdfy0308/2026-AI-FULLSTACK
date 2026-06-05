package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.the703.dao.BoardMapper;
import com.the703.dto.BoardDto;

@Service
public class BoardServiceImpl  implements BoardService {
	@Autowired  BoardMapper  dao;  // db관련   
	@Override public List<BoardDto> selectAll() { return dao.selectAll(); }

	@Override public int insert(BoardDto dto) {
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		return dao.insert(dto);
	} 
	@Override public BoardDto detail(int bno) {
		dao.hit(bno);
		return dao.select(bno);
	} 
	@Override public BoardDto editView(int bno) { return dao.select(bno); }
	
	@Override public int edit(BoardDto dto) { 
		// 1. 정보 가져오기
		BoardDto original = dao.select(dto.getBno());
		
		// 2. 비밀번호 비교
		if(original.getBpass().equals(dto.getBpass())) {
	        return dao.update(dto);  // 번호 일치하면 수정 실행
	    }
		return 0; // 불일치시 → result값 변화 없음(수정 실패)
	}
	
	@Override public int delete(BoardDto dto) { 
		// 1. 정보 가져오기
		BoardDto original = dao.select(dto.getBno());
		
		// 2. 비밀번호 비교하기
		if(original.getBpass().equals(dto.getBpass())) {
			return dao.delete(dto.getBno()); // 번호 일치하면 삭제
		}
		return 0; // 불일치시 → result값 변화 없음(삭제 실패)
	}
}
