package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MybatisDynamicTestVO;

public interface BoardMapper {
	  //@Select("select * from tbl_board where bno > 0") public List<BoardVO>
	  public List<BoardVO> getList(Criteria cri);

	  public void insert(BoardVO board);
	  
	  public void insertSelectKey(BoardVO board);

	  public BoardVO read(Long bno1);

	  public int delete(Long bno);

	  public int update(BoardVO board);

	  public int views(Long bno);

	List<BoardVO> getDynamicMybatis(MybatisDynamicTestVO test);
	List<BoardVO> getDynamicMybatis2(MybatisDynamicTestVO test);
}
