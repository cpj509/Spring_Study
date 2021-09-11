package org.pj.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;	//소수점을 하나 붙여주는 이유는 int끼리 나누면 결과가 0가 되버리는 경우를 방지하기 위해서.
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));	//마지막 페이지 계산. 전체 글수 / 한 페이지에 나오는 글수.
		if(realEnd < this.endPage) {	//맨 마지막 페이지 맞춤용.
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

}
