package org.pj.service;

import java.util.List;

import org.pj.domain.BoardVO;
import org.pj.domain.Criteria;

public interface BoardService {
	public void register(BoardVO board);
	public BoardVO get(long bno);
	public boolean modify(BoardVO board);
	public boolean remove(long bno);
//	public List<BoardVO> getList();
	public List<BoardVO> getList(Criteria cri);

}
