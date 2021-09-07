package org.pj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.pj.domain.BoardVO;
import org.pj.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor	//생성자를 만들고 자동으로 주입함. Autowired를 작성 안해도 됨.
public class BoardController {
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {	//redirectattributes를 사용하는 이유는 새로운 데이터를 전달하기 위해서.(redirect)
		log.info("register: " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";	//redirect:를 사용하면 스프링 MVC가 내부적으로 response.sendredirect()를 처리해 줌.
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") long bno, Model model) {
		log.info("get or modify");
		
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify: " + board);
		
		if(service.modify(board)) {	//service.modify는 boolean값
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
		
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") long bno, RedirectAttributes rttr) {
		log.info("remove......." + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		
	}

}
