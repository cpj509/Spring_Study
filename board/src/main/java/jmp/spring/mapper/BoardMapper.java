package jmp.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import jmp.spring.vo.BoardVO;
import jmp.spring.vo.Criteria;

public interface BoardMapper {
	@Select("select sysdate from dual")
	public String getTime();
	
	public String getTime2();
	
	public List<BoardVO> getList(Criteria cri);
	
	public int insertBoard(BoardVO vo);
	
	public BoardVO get(int bno);
	
	public int update(BoardVO vo);
	
	public int delete(int bno);
	
	public int getTotal();
}
