package jmp.spring.vo;

import lombok.Data;

@Data
public class PageNavi {
	int startPage;  	// 시작페이지 번호
	int endPage;   	// 끝 페이지 번호
	boolean prev; 	// prev 표시여부
	boolean next; 	// next 표시여부
	
	public PageNavi(Criteria cri, int total) {
		endPage = (int)Math.ceil(cri.getPageNo() / 10.0) * 10;
		startPage = endPage - 9;
		
		int realEndPage = (int)Math.ceil((total * 1.0) / cri.getAmount());
		
		prev = startPage > 1;
		next = realEndPage > endPage;
		
		endPage = endPage > realEndPage ? realEndPage : endPage;
		
		
		
	}
	
	
}
