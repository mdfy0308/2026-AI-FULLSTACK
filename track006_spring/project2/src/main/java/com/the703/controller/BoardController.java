package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	//��1.  ��ü����Ʈ
	//	@RequestMapping("/board/list.do")
	//	public String list(Model model) {  
	//		model.addAttribute("list", service.selectAll());  
	//		return  "board/list";   
	//	}
	
	@RequestMapping("/board/list.do")
	public String list(Model model  , @RequestParam(value="pstartno" , defaultValue = "1" ) int pstartno  ) {
		
		model.addAttribute("paging" , new PagingUtil( service.selectCnt() , pstartno) );  /*  service��ü���� */
		model.addAttribute("list"   , service.select10(pstartno));     /*  list10 */
		return  "board/list";   
	} 
	
	@RequestMapping( value="/board/write.do" , method=RequestMethod.GET)
	public String write() { return  "board/write";  }

	//��2. �۾��� ���  
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_MEMBER')")  //4. �ȿ� �ִ� ������
	//@PreAuthorize("isAuthenticated()  and  hasRole('ROLE_ADMIN')") //3. �α��� + ADMIN ������ �ִٸ�
	//@PreAuthorize("isAnonymous()")
	@PreAuthorize("isAuthenticated()")
	@RequestMapping( value="/board/write.do" 
							,method = RequestMethod.POST , headers=("content-type=multipart/*"))
	public String write_post(BoardDto dto ,
			 @RequestParam("file") MultipartFile file   ,
			RedirectAttributes rttr) { 
		String result ="글쓰기 실패";
		
		if(service.insert(dto , file) > 0) {  result = "글쓰기 성공"; }
		rttr.addFlashAttribute("result", result);
		return "redirect:/board/list.do";
	}
	

	@RequestMapping("/board/detail.do")
	public String detail( int bno ,  Model model ) {  
		model.addAttribute("dto" , service.detail(bno)); 
		return  "board/detail";  
	}

	 

	@RequestMapping( value= "/board/edit.do" , method = RequestMethod.GET)
	public String edit( int bno  , Model model) {  // �Ѱܹ޴� bno , edit.jsp  
		model.addAttribute("dto" , service.editView(bno));
		return  "board/edit";  
	} 

	@RequestMapping( value= "/board/edit.do" , method = RequestMethod.POST)
	public String edit_post(
			BoardDto dto,
			@RequestParam("file")  MultipartFile file, 
			RedirectAttributes rttr) { 
		// �˸�â
		String result = "수정 실패";
		if( service.edit(dto , file) > 0 ) {  result = "수정 성공";  }
		rttr.addFlashAttribute("result", result);
		
		return "redirect:/board/detail.do?bno=" + dto.getBno();
	} 


	@RequestMapping( value="/board/delete.do", method = RequestMethod.GET)
	public String delete(int bno) { return  "board/delete";  }
	

	@RequestMapping( value="/board/delete.do" , method = RequestMethod.POST)
	public String delete_post(BoardDto dto, RedirectAttributes rttr) {  
		String result = "��й�ȣ Ȯ��!";
		if( service.delete(dto) > 0 ) {  result = "��������";  }
		rttr.addFlashAttribute("result", result);
		
		return  "redirect:/board/list.do";  
	}

}
 