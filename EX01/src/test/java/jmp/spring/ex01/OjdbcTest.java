package jmp.spring.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class OjdbcTest {
	
	@Test
	public void testConn() {
		Connection conn = null;
		long start = System.currentTimeMillis();
		System.out.println((start / 1000.0) + "Second");
		for(int i = 0; i < 100; i++) {
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "spring", "spring");
								
				conn.close();
				
				System.out.println("===========" + conn + "=====" + i);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if(!conn.isClosed()) {
						conn.close();
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000.0 + "Second");
	}
}