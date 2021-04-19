package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.vo.BoardVO;
import jmp.spring.vo.Criteria;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getList(cri);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(vo);
	}

	@Override
	public BoardVO get(int bno) {
		// TODO Auto-generated method stub
		return mapper.get(bno);
	}

	@Override
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return mapper.getTotal();
	}
}
