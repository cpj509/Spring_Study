package jmp.spring.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jdk.internal.org.jline.utils.Log;
import jmp.spring.vo.sampleVOList;
import jmp.spring.vo.sampleVO;

@Controller
public class MainController {

	@GetMapping("fileUpload")
	public String fileUpload() {
		return "fileUpload";
	}

//	@GetMapping("fileUpload")
//	public String fileUpload(ArrayList<MultipartFile> files) {
//		return "fileUpload";
//	}
	
	@GetMapping("getJson")
	public @ResponseBody sampleVO getJson(sampleVO vo) {
//		json data type으로 return.
//		jackson databind maven에 추가 해야 함.
		System.out.println("========== getJson : " + vo);
		return vo;
	}
	
	@GetMapping("forward")
	public String forward(Model model) {
		System.out.println("==========forward");
		model.addAttribute("serverTime", new Date());
		
		return "forward:/res";
	}
	
	@GetMapping("res")
	public String res() {
		System.out.println("==========res");
		return "res";
	}
	
	@GetMapping("redirect")
	public String redirect(Model model) {
		System.out.println("==========redirect");
		model.addAttribute("serverTime", new Date());
		
		return "redirect:/res";
	}
	
	@GetMapping("main")
	public String main(sampleVOList vo) {
		System.out.println("===========main controller");
//		System.out.println(vo.getName());
//		System.out.println(vo.getAge());
		System.out.println(vo.getList());
		return "main";
	}
	
	@GetMapping("login")
	public String login(@RequestParam("id") String id) {
		System.out.println(id);
		return "jmp".equals(id) ? "login/success" : "login/fail";
	}
}
