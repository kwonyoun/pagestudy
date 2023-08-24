package com.example.pagestudy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.pagestudy.vo.BoardVO;
import com.example.pagestudy.vo.PageVO;

@Mapper
public interface BoardDAO {

    public List<BoardVO>getList(PageVO searchVO);
    public int getListCnt(PageVO searchVO);
    
}
