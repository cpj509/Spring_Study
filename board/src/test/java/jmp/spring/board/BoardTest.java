package jmp.spring.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVO;
import jmp.spring.vo.Criteria;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardTest {

	@Autowired
	HikariDataSource dataSource;
	
	@Autowired
	BoardMapper mapper;
	
	@Autowired
	BoardService service;
	
	/*
	 * 작성자 : 
	 * 작성일 : 
	 * 반환값 : 
	 */
	
	@Test
	public void getTotalTest_service() {
		log.info(service.getTotal());
	}
	
	@Test
	public void getTotalTest_mapper() {
		log.info(mapper.getTotal());
	}
	
	@Test
	public void service5() {
		service.delete(15);	//	custom value. need to fix.
		log.info("delete finish.(service)");
	}
	
	@Test
	public void mapperTest7() {	//delete test(mapper)
		mapper.delete(16);	//	custom value. need to fix.
		log.info("delete finish.(mapper)");
	}
	
	@Test
	public void service4() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(21);	//	custom value. need to fix.
		vo.setTitle("업데이트Title2");
		vo.setContent("업데이트Content2");
		vo.setWriter("업데이트Writer2");
		
		service.update(vo);
		
		log.info("=======update finish!!(service)=======");
	}
	
	@Test
	public void mapperTest6() {	//	update test
		BoardVO vo = new BoardVO();
		
		vo.setBno(20);	//	custom value. need to fix.
		vo.setTitle("업데이트Title");
		vo.setContent("업데이트Content");
		vo.setWriter("업데이트Writer");
		
		mapper.update(vo);
		
		log.info("=======update finish!!=======");
	}
	
	@Test
	public void service3() {	//	select * from bno(service)
		service.get(22);
		log.info("=========get service test");
	}
	
	@Test
	public void mapperTest5() {	//	select * from bno
		mapper.get(22);
		log.info("=========get mapper test");
	}
	
	@Test
	public void service2() {	//	insert test(service)
		BoardVO vo = new BoardVO();
		
		vo.setTitle("TestTitle2");
		vo.setContent("TestContent2");
		vo.setWriter("TestWriter2");
		service.insertBoard(vo);
		
		log.info("==========insert finish!!!==========");
	}
	
	@Test
	public void mapeprTest4() {	//	insert test
		BoardVO vo = new BoardVO();
		vo.setTitle("TestTitle");
		vo.setContent("TestContent");
		vo.setWriter("TestWriter");
		mapper.insertBoard(vo);
		
		log.info("==========insert finish!!!==========");
	}
	
	@Test
	public void getListTest_service() {	//	select test(service)
		Criteria cri = new Criteria();
		cri.setPageNo(1);
		log.info(service.getList(cri));
	}
	
	@Test
	public void getListTest_mapper() {
		Criteria cri = new Criteria();
		cri.setPageNo(2);
		log.info(mapper.getList(cri));
	}
	
	@Test
	public void gettime2Test() {	//	get time test
		log.info("=======" + mapper.getTime2());
	}
	
	@Test
	public void mapperTest() {
		log.info("=======" + mapper.getTime());
	}
	
	@Test
	public void hikariCPTest() {
		try {
			Connection con = dataSource.getConnection();
			log.info(con);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void ojdbcTest() {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "spring", "spring");
			log.info(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
