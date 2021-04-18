package pj.spring.sweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;
import pj.spring.mapper.SwebMapper;
import pj.spring.service.SwebService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SwebTest {
	@Autowired
	HikariDataSource dataSource;
	
	@Autowired
	SwebMapper mapper;
	
	@Autowired
	SwebService service;

	@Test
	public void selectTest_service() {
		log.info(service.getBoard());
		log.info(service.getMember());
	}
	
	@Test
	public void selectTest_mapper() {
		log.info(mapper.getBoard());
		log.info(mapper.getMember());
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
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jweb", "4321");
			log.info(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
