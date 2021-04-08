package jmp.spring.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jdk.internal.org.jline.utils.Log;
import jmp.spring.vo.MainVO;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class SampleController {
	@GetMapping("main")
	public void main(MainVO vo, Model model) {
		log.info("========main()");
		model.addAttribute("time", new Date());
	}
	@GetMapping("mainTest/main")
	public void mainTest() {
		log.info("========mainTest()");
	}
	@GetMapping("fileUpload")
	public void fileUpload() {
		log.info("get fileUpload;");
	}
	@PostMapping("fileUpload")
	public String fileUploadExe(ArrayList<MultipartFile> files) {
		log.info("post fileUpload: ");
		
		files.forEach(file->{
			log.info(file.getOriginalFilename());
			log.info(file.getSize());
		});
		
		return "aa";
	}
}