package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.BoardDto;
import com.the703.service.BoardService;
import com.the703.util.PagingUtil;

@Controller
public class BoardController {  
	
	@Autowired BoardService  service;
	
	//1. 전체보기
//	@RequestMapping("/board/list.do")
//	public String list(Model model) {  
//		model.addAttribute("list", service.selectAll());  
//		return  "board/list";   
//	}
	
	@RequestMapping("/board/list.do")
	public String list(Model model, 
					   @RequestParam(value="pstartno" , defaultValue ="1") int pstartno) {  
		model.addAttribute("paging", new PagingUtil(service.selectCnt(), pstartno) ); /* service 전체갯수 */
		model.addAttribute("list", service.select10(pstartno));  /* list10 */
		return  "board/list";   
	}
	
	
	//2. 글쓰기
	@RequestMapping( value="/board/write.do" , method=RequestMethod.GET)
	public String write() { return  "board/write";  }
	//http://localhost:8282/spring003_mvc/board/write.do
	
	//2. 글쓰기 기능
	@RequestMapping( value="/board/write.do" ,method = RequestMethod.POST)
	public String write_post(BoardDto dto, 
			@RequestParam("file") MultipartFile file,
			RedirectAttributes rttr) { 
		String result ="글쓰기 실패";
		
		if(service.insert(dto, file) > 0) {  result = "글쓰기 성공"; }
		rttr.addFlashAttribute("result", result);  // Flash - 1번만 실행
		return "redirect:/board/list.do";   //response.sendRedirect + alert (x)
	}
	
	// 3. 상세 보기
	@RequestMapping( value="/board/detail.do", method = RequestMethod.GET )
	public String detail( int bno ,  Model model ) { // 넘겨받는 bno, edit.jsp
		model.addAttribute("dto" , service.detail(bno));
		return  "board/detail";  
	}
	//http://localhost:8282/spring003_mvc/board/detail.do
	 
	// 4. 글 수정폼 경로 - view
	@RequestMapping(value="/board/edit.do", method = RequestMethod.GET)
	public String edit(int bno, Model model) { 
		model.addAttribute("dto", service.editView(bno));
		return  "board/edit";  
	} 
	
	//4. 글 수정 기능 - action
	@RequestMapping( value="/board/edit.do", method = RequestMethod.POST )
	public String edit_post(BoardDto dto, 
			@RequestParam("file") MultipartFile file,
			RedirectAttributes rttr) { 
		// 알림창
		String result = "비밀번호 확인";
		if(service.edit(dto, file) > 0) { result = "수정 성공"; }
		rttr.addFlashAttribute("result", result);
		return  "redirect:/board/detail.do?bno=" + dto.getBno();  
	}
	
	// 5. 글 삭제폼 경로 - view
	@RequestMapping( value="/board/delete.do", method = RequestMethod.GET)
	public String delete(int bno) { return  "board/delete";  }

	
	// 5. 글 삭제 기능 - action
	@RequestMapping( value="/board/delete.do", method = RequestMethod.POST)
	public String delete_post(BoardDto dto, RedirectAttributes rttr) {
	    // BoardDto로 받으면 bno + bpass 둘 다 자동으로 담김
	    String result = "비밀번호 확인";
	    if(service.delete(dto) > 0) { result = "삭제 성공"; }
	    rttr.addFlashAttribute("result", result);
	    return "redirect:/board/list.do";
	}

}


/*
/board/list.do            /view/board/list.jsp
/board/write.do           /view/board/write.jsp
/board/detail.do          /view/board/detail.jsp
/board/edit.do            /view/board/edit.jsp 
/board/delete.do          /view/board/delete.jsp
*/