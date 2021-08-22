package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "spring", "spring")){
			log.info(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
