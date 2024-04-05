package org.zerock.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import java.util.List;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void register(BoardVO board) {
        log.info("register....."+board);
        boardMapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("get....."+bno);
        return boardMapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify...."+board);
        return boardMapper.update(board)==1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove..."+bno);
        return boardMapper.delete(bno)==1;
    }

    @Override
    public List<BoardVO> getList(Criteria cri) {
        log.info("getList.....");
        return boardMapper.getList(cri);
    }

    @Override
    public boolean views(Long bno){
        return boardMapper.views(bno)==1;
    }
}
