package pj.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.spring.mapper.SwebMapper;
import pj.spring.vo.SwebBoardVO;
import pj.spring.vo.SwebMemberVO;

@Service
public class SwebServiceImpl implements SwebService {
	@Autowired
	SwebMapper mapper;
	
	@Override
	public List<SwebBoardVO> getBoard() {
		// TODO Auto-generated method stub
		return mapper.getBoard();
	}

	@Override
	public List<SwebMemberVO> getMember() {
		// TODO Auto-generated method stub
		return mapper.getMember();
	}

}
