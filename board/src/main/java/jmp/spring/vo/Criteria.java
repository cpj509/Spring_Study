package jmp.spring.vo;

import lombok.Data;

@Data
public class Criteria {
	int pageNo;	//	페이지 번호
	int amount;	//	페이지 당 게시물 수
	
	public Criteria() {
		this.pageNo = 1;
		this.amount = 10;
	}
}
