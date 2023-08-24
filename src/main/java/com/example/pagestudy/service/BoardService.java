package com.example.pagestudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pagestudy.dao.BoardDAO;
import com.example.pagestudy.vo.BoardVO;
import com.example.pagestudy.vo.PageVO;

@Service
public class BoardService {

    @Autowired
    BoardDAO dao;
    
    public List<BoardVO> getList(PageVO searchVO) {
        return dao.getList(searchVO); 
    }

    public int getListCnt(PageVO searchVO) {
        return dao.getListCnt(searchVO);
    }
    
}
