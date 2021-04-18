package pj.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;
import pj.spring.service.SwebService;

@Controller
@Log4j
public class SwebController {
	@Autowired
	SwebService service;
}
