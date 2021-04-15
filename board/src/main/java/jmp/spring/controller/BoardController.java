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
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("register")
	public void register() {
		log.info("register");
	}
	
	@PostMapping("register")
	public String registerPost(BoardVO vo, RedirectAttributes rttr) {
		log.info("=========vo : " + vo);
		service.insertBoard(vo);
		log.info("=========vo : " + vo);
		
		rttr.addFlashAttribute("resMsg", vo.getBno() + "번 게시물이 등록 되었습니다.");
		
		return "redirect:list";
	}
	
	@GetMapping({"get", "edit"})
	public void get(BoardVO vo, Model model) {
		log.info("========get");
		
		vo = service.get(vo.getBno());
		
		model.addAttribute("vo", vo);
	}
}
