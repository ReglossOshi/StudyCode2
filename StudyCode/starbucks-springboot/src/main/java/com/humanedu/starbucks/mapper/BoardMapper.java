package com.humanedu.starbucks.mapper;

import java.util.List;

import com.humanedu.starbucks.domain.FreeBoardVO;

public interface BoardMapper {
	 public List<FreeBoardVO> getFreeBoardList(String search);
	 
	 int putFreeBoard(FreeBoardVO freeBoardVO);
	 int deleteFreeBoard(FreeBoardVO freeBoardVO);
	 
	 int updateFreeBoard(FreeBoardVO freeBoardVO);
	 
	 public List<FreeBoardVO> getUpdateFreeBoard(int num);
}
