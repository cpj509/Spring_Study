package jmp.spring.ex01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JunitTest {
	@Test
	public void testA() {
		Calculator cal = new Calculator();
		int res = cal.calculator("2", "1", "+");
		
		assertEquals(3, res);
	}
	@Test
	public void testB() {
		Calculator cal = new Calculator();
		int res = cal.calculator("2", "1", "-");
		
		assertEquals(3, res);
	}
	@Test
	public void testC() {
		Calculator cal = new Calculator();
//		스트링 배열 생성{"1", "2", str}
		String[] str = {"1", "2", "str"};
//		반복 처리
		for(String value : str) {
			System.out.println("===" + value);
			int res = cal.calculator(value, "1", "+");
			System.out.println("===" + res);
			assertEquals(2, res); 
		}
		
		
	}

}
