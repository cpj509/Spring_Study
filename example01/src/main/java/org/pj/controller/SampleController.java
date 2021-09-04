package org.pj.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.pj.domain.SampleDTO;
import org.pj.domain.SampleDTOList;
import org.pj.domain.TodoDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("basic...............");
	}
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get............");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get...........");
	}
	
	@GetMapping("/example01")
	public String example01(SampleDTO dto) {
		log.info("" + dto);
		return "example01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {	//파라미터 요구.
		log.info("name: " + name);
		log.info("age: " + age);
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {	//ArrayList.
		log.info("ids: " + ids);
		
		return "ex02List";	
	}
	
	@GetMapping("/ex02Array")
	public String ex02List(@RequestParam("ids") String[] ids) {	//배열.
		log.info("array ids: " + Arrays.toString(ids));
		
		return "ex02Array";	
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {	//객체 list.
		log.info("list dtos: " + list);
		
		return "ex02Bean";
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {	//파라미터 변환 처리
		log.info("todo: " + todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {	//Model 실습. 그냥 int로 사용시 에러.
		log.info("dto: " + dto);
		log.info("page: " + page);
		
		return "sample/ex04";
	}
	
	@GetMapping("/home")
	public String home(Model model) {	//home.jsp에 시간 데이터 전달.
		model.addAttribute("serverTime", new java.util.Date());
		
		return "home";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {	//객체 타입 실습. jackson-databind 라이브러리를 이용해서 자동으로 JSON 타입의 객체를 변환해서 전달.
		log.info("/ex06...........");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("Friend");
		
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {	//HTTP 헤더 실습.
		log.info("/ex07...............");
		
//		{"name": "홍길동"}
		String msg = "{\"name\": \"Jack\"}";
				
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload..........");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {	//upload 테스트.
		log.info("/exUploadPost..........");
		files.forEach(file ->{
			log.info("-------------------------");
			log.info("name: " + file.getOriginalFilename());
			log.info("size: " + file.getSize());
		});
	}
	 
}
