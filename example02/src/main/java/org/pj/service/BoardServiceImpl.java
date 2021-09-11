package org.pj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pj.domain.BoardVO;
import org.pj.domain.Criteria;
import org.pj.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("register........" + board);
		
		mapper.insertSelectKey(board);
		
	}

	@Override
	public BoardVO get(long bno) {
		// TODO Auto-generated method stub
		log.info("get.........." + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("modify.........." + board);
		return mapper.update(board) == 1;	//정상적으로 반환 시에 1 반환.
	}

	@Override
	public boolean remove(long bno) {
		// TODO Auto-generated method stub
		log.info("remove.........." + bno);
		return mapper.delete(bno) == 1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		// TODO Auto-generated method stub
//		log.info("getList............");
//		
//		return mapper.getList();
//	}
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("getList with criteria: " + cri);
		
		return mapper.getListWithPaging(cri);
	}

}
