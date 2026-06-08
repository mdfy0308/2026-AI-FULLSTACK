package com.the703.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.BoardMapper;
import com.the703.dto.BoardDto;

@Service
public class BoardServiceImpl  implements BoardService {
	@Autowired  BoardMapper  dao;  // db관련   
	@Override public List<BoardDto> selectAll() { return dao.selectAll(); }

	@Override public int insert(BoardDto dto, MultipartFile file) {
		String fileName="";
		
		if(!file.isEmpty()) {
			fileName = file.getOriginalFilename();
			String uploadPath = "C:/file/";
			File demp = new File(uploadPath + fileName);
			
			try { file.transferTo(demp); } 
			catch (IOException e) {  e.printStackTrace(); }
		}
		
		dto.setBfile(fileName);
		
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		return dao.insert(dto);
	} 
	
	@Override public BoardDto detail(int bno) {
		dao.updateHit(bno); // 조회수 올리기
		return dao.select(bno);
	} 
	
	@Override public BoardDto editView(int bno) { return dao.select(bno); }
	
	@Override public int edit(BoardDto dto, MultipartFile file) { 
		
		int result = -1; // 비번 안 맞음
		// 1. 정보 가져오기
		BoardDto find = dao.select(dto.getBno()); // 해당 유저 찾기
		
		// 2. 비밀번호 비교
		if(find.getBpass().equals(dto.getBpass())) { // 비밀번호 비교
			
			String fileName = dto.getBfile();
			// #1. 기본 파일명으로 들어간 것 넣음
			
			if( !file.isEmpty()) {
				fileName = file.getOriginalFilename();
				String uploadPath = "C:/file/";
				File demp = new File( uploadPath + fileName );
				
				try { file.transferTo(demp); } // #2. 파일 올리기
				catch (IOException e) { e.printStackTrace(); }
			}
			dto.setBfile(fileName); // #3. 파일명 세팅
	        result = dao.update(dto);  // 번호 일치하면 수정 실행
	    }
		return result;
	}
	
	@Override public int delete(BoardDto dto) { 
		int result = -1; // 비번 안 맞음
		// 1. 정보 가져오기
		BoardDto find = dao.select(dto.getBno());
		
		// 2. 비밀번호 비교하기
		if(find.getBpass().equals(dto.getBpass())) {
			result = dao.delete(dto.getBno()); // 번호 일치하면 삭제
		}
		return result; // 불일치시 → result값 변화 없음(삭제 실패)
	}

	/* paging */
	/* paging */
	
	@Override
	public List<BoardDto> select10(int pstartno) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", (pstartno-1)*10);
		map.put("end", 10);
		return dao.select10(map);
	}

	@Override public int selectCnt() {  return dao.selectCnt(); }
	
	
	
}
