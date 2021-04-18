package pj.spring.mapper;

import java.util.List;

import pj.spring.vo.SwebBoardVO;
import pj.spring.vo.SwebMemberVO;

public interface SwebMapper {
	public List<SwebBoardVO> getBoard();
	public List<SwebMemberVO> getMember();
}
