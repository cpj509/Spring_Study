package spring.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Chef{
	String type;

	public Chef(@Value("중식")  String type) {
		System.out.println("Chef의 생성자 =============== " + type);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}


@Component
class Rest{
	
	@Autowired
	Chef chef;

	public Rest() {
//		this.chef = new Chef("중식");
		
	}

	public Rest(Chef chef) {
		super();
		this.chef = chef;
	}

	@Override
	public String toString() {
		return chef.type + " 식당 입니다.";
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
}

public class DiTest {
	public static void main(String[] args) {
//		- JAVA 설정 파일 작성
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
//		- xml 설정 파일 작성(어노테이션 사용)
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring/config.xml");
		System.out.println("rest: " + context.getBean("rest"));
		
//		Rest rest = new Rest();
//		System.out.println(rest);
		
//		의존성 주입
//		1. 만들 때 주입
//		Chef chef = new Chef("중식");
//		Rest rest = new Rest(chef);
//		System.out.println(rest);
		
//		2. Use Getter & Setter
//		Chef chef = new Chef("중식");
//		Rest rest = new Rest();
//		rest.setChef(chef);
//		System.out.println(rest);
		
	}
}
