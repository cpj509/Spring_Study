package org.pj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.pj.domain.BoardVO;
import org.pj.domain.Criteria;

public interface BoardMapper {
	//@Select("select * from tbl_board where bno > 0")	Mapper 인터페이스. BoardMapper.xml을 사용하였기에 주석처리.
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);	//insert 후 결과 확인까지.(select)

	public BoardVO read(long bno);
	
	public int delete(long bno);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);	//검색에서 사용하기 위해 파라미터에 Criteria를 전달 받도록 설계.
}
