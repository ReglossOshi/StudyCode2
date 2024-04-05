package com.humanedu.starbucks.service;

import com.humanedu.starbucks.domain.FreeBoardVO;
import com.humanedu.starbucks.mapper.BoardMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class FreeBoardServiceImpl implements FreeBoardService {
    @Autowired
    private BoardMapper boardMapper;

    // 게시물 목록 조회 서비스
    @Override
    public List<FreeBoardVO> getFreeBoardList(String search) {
        List<FreeBoardVO> freeBoardVOList = boardMapper.getFreeBoardList(search);
        return freeBoardVOList;
    }
    
    @Override
    public int insertFreeBoard(
            String korName,
            String subject,
            String content,
            List<String> fileNameList
    ) {
        FreeBoardVO freeBoardVO = new FreeBoardVO();
        freeBoardVO.setName(korName);
        freeBoardVO.setSubject(subject);
        freeBoardVO.setContent(content);

        if(fileNameList !=null) {
        	if(fileNameList.size() >=1) {
        		freeBoardVO.setFile1Path(fileNameList.get(0));
        	}
        	if(fileNameList.size() >=2) {
        		freeBoardVO.setFile2Path(fileNameList.get(1));
        	}
        }

        int rtn = boardMapper.putFreeBoard(freeBoardVO);
        return rtn;
    }
    
    @Override
    public int deleteFreeBoard(int num) {
    	FreeBoardVO freeBoardVO = new FreeBoardVO();
    	freeBoardVO.setNum(num);
    	
    	int rtn = boardMapper.deleteFreeBoard(freeBoardVO);
    	return rtn;
    }
    
    @Override
    public int updateFreeBoard(int num, String korName, String subject, String content, List<String> fileNameList) {
    	FreeBoardVO freeBoardVO = new FreeBoardVO();
    	freeBoardVO.setNum(num);
    	freeBoardVO.setName(korName);
        freeBoardVO.setSubject(subject);
        freeBoardVO.setContent(content);
        
        if(fileNameList !=null) {
        	if(fileNameList.size() >=1) {
        		freeBoardVO.setFile1Path(fileNameList.get(0));
        	}
        	if(fileNameList.size() >=2) {
        		freeBoardVO.setFile2Path(fileNameList.get(1));
        	}
        }
        
        int rtn = boardMapper.updateFreeBoard(freeBoardVO);
        return rtn;
    }
    
    @Override
    public List<FreeBoardVO> getUpdateFreeBoard(int num) {
    	
    	List<FreeBoardVO> freeBoardVOList = boardMapper.getUpdateFreeBoard(num);
        return freeBoardVOList;
    }
    
//    @Override
//    public List<FreeBoardVO> getFreeBoardList(String search) {
//        List<FreeBoardVO> freeBoardVOList = null;
//        
//        if(search==null) {
//        	freeBoardVOList = boardMapper.getFreeBoardList(search);
//        } else if(!search.equals("")){
//        	freeBoardVOList = boardMapper.getFreeBoardList(search);
//        }
//        return freeBoardVOList;
//    }
}