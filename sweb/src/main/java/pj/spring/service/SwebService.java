package pj.spring.service;

import java.util.List;

import pj.spring.vo.SwebBoardVO;
import pj.spring.vo.SwebMemberVO;

public interface SwebService {
	public List<SwebBoardVO> getBoard();
	public List<SwebMemberVO> getMember();
}
