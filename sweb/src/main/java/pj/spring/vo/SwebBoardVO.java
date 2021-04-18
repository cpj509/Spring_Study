package pj.spring.vo;

import lombok.Data;

@Data
public class SwebBoardVO {
	private int bnum;
	private String title;
	private String content;
	private String regDate;
	private String memberId;
	private int hit;
}
