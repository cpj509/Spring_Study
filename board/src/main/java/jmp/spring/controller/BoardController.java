package jmp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVO;
import jmp.spring.vo.Criteria;
import jmp.spring.vo.PageNavi;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("delete")
	public String delete(BoardVO vo, RedirectAttributes rttr) {
		log.info(vo);
		
		int res = service.delete(vo.getBno());
		
		String resMsg = "";
		if(res > 0)
			resMsg = vo.getBno() + "번 게시물을 삭제 하였습니다.";
		else
			resMsg = "삭제에 실패 하였습니다.";
		
		rttr.addFlashAttribute("resMsg", resMsg);
		
		return "redirect:list";
	}
	
	@PostMapping("edit")
	public String editPost(BoardVO vo, RedirectAttributes rttr) {
		log.info(vo);
		
		int res = service.update(vo);
		String resMsg = "";
		if(res > 0)
			resMsg = "수정 되었습니다.";
		else
			resMsg = "수정에 실패 하였습니다.";
		
		rttr.addAttribute("bno", vo.getBno());
		rttr.addFlashAttribute("resMsg", resMsg);
		
		return "redirect:get";
	}
	
	@GetMapping("list")
	public String list(Criteria cri, Model model) {
		
		
		log.info("list");
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageNavi", new PageNavi(cri, service.getTotal()));
		
		return "board/list_b";
	}
	
	@GetMapping("register")
	public String register() {
		log.info("register");
		return "board/register_b";
	}
	
	@PostMapping("register")
	public String registerPost(BoardVO vo, RedirectAttributes rttr) {
		log.info("=========vo : " + vo);
		service.insertBoard(vo);
		log.info("=========vo : " + vo);
		
		rttr.addFlashAttribute("resMsg", vo.getBno() + "번 게시물이 등록 되었습니다.");
		
		return "redirect:list";
	}
/*
	@GetMapping({"get", "edit"})
	public String get(BoardVO vo, Model model) {
		log.info("========get, edit");
		
		vo = service.get(vo.getBno());
		
		model.addAttribute("vo", vo);
		
		return "board/get_b";
	}
*/
	@GetMapping("get")
	public String get(BoardVO vo, Model model) {
		log.info("========get");
		
		vo = service.get(vo.getBno());
		
		model.addAttribute("vo", vo);
		
		return "board/get_b";
	}

	@GetMapping("edit")
	public String edit(BoardVO vo, Model model) {
		log.info("========edit");
		
		vo = service.get(vo.getBno());
		
		model.addAttribute("vo", vo);
		
		return "board/edit_b";
	}
}
