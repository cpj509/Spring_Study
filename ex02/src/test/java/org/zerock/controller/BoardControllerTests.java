package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration	//Servlet의 ServletContext를 이용하기 위해서 적용. WebApplicationContext를 이용하기 위해.
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class BoardControllerTests {
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {	//Before가 적용된 메서드는 모든 테스트 전에 매번 실행.
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
	}
	
	@Test
	public void testRegister() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "테스트 새 글 제목")
				.param("content", "테스트 새 글 내용")
				.param("writer", "user00")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
				
	}
	
	@Test
	public void testGet() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "1")
				).andReturn().getModelAndView().getModelMap());
	}

}
