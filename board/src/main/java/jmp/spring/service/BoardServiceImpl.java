package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public int insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(vo);
	}
}