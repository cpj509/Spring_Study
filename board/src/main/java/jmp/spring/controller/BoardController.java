package jmp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String registerPost(BoardVO vo) {
		log.info("=========vo : " + vo);
		service.insertBoard(vo);
		return "redirect:list";
	}
}
