package com.humanedu.starbucks.service;

import java.util.List;

import com.humanedu.starbucks.domain.FreeBoardVO;

public interface FreeBoardService {
    List<FreeBoardVO> getFreeBoardList(String search);
    
    int insertFreeBoard(String korName,
                        String subject,
                        String content,
                        List<String> fileNameList);
    
    int deleteFreeBoard(int num);
    
    int updateFreeBoard(
    		int num, 
    		String korName,
            String subject,
            String content,
            List<String> fileNameList);
    List<FreeBoardVO> getUpdateFreeBoard(int num);

    
}
