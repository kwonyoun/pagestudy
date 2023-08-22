package com.example.pagestudy.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.pagestudy.service.BoardService;
import com.example.pagestudy.vo.BoardVO;
import com.example.pagestudy.vo.PageVO;
import com.example.pagestudy.vo.Pagination;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/board/list", method = RequestMethod.GET)
    public String list(@ModelAttribute("searchVO") PageVO searchVO, HttpServletRequest request, Model model) throws UnsupportedEncodingException {
                
        // Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        // if(null != inputFlashMap) {
            
        //     model.addAttribute("msg",(String) inputFlashMap.get("msg"));
            
        // }
        
        System.out.println("gg");
        //페이징[s]
        Pagination pagination = new Pagination();
        pagination.setCurrentPageNo(searchVO.getPageIndex());
        pagination.setRecordCountPerPage(searchVO.getPageUnit());
        pagination.setPageSize(searchVO.getPageSize());
        
        searchVO.setFirstIndex(pagination.getFirstRecordIndex());
        searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        
        List<PageVO> boardList = boardService.getList(searchVO);
        int totCnt = boardService.getListCnt(searchVO);
        
        pagination.setTotalRecordCount(totCnt);
        
        searchVO.setEndDate(pagination.getLastPageNoOnPageList());
        searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
        searchVO.setPrev(pagination.getXprev());
        searchVO.setNext(pagination.getXnext());
        
        model.addAttribute("boardList",boardList);
        model.addAttribute("totCnt",totCnt);
        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
        model.addAttribute("pagination",pagination);
        //페이징[e]
        
        // searchVO.setQustr();
        
        return "/board/list";
    }

    // @RequestMapping(value = "/board/list", method = RequestMethod.GET)
    // public String list(@ModelAttribute("searchVO") PageVO searchVO, HttpServletRequest request, Model model) throws UnsupportedEncodingException {
                
    //     // Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
    //     // if(null != inputFlashMap) {
            
    //     //     model.addAttribute("msg",(String) inputFlashMap.get("msg"));
            
    //     // }
        
    //     System.out.println("gg");
    //     //페이징[s]
    //     Pagination pagination = new Pagination();
    //     pagination.setCurrentPageNo(searchVO.getPageIndex());
    //     pagination.setRecordCountPerPage(searchVO.getPageUnit());
    //     pagination.setPageSize(searchVO.getPageSize());
        
    //     searchVO.setFirstIndex(pagination.getFirstRecordIndex());
    //     searchVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        
    //     List<PageVO> boardList = boardService.getList(searchVO);
    //     int totCnt = boardService.getListCnt(searchVO);
        
    //     pagination.setTotalRecordCount(totCnt);
        
    //     searchVO.setEndDate(pagination.getLastPageNoOnPageList());
    //     searchVO.setStartDate(pagination.getFirstPageNoOnPageList());
    //     searchVO.setPrev(pagination.getXprev());
    //     searchVO.setNext(pagination.getXnext());
        
    //     model.addAttribute("boardList",boardList);
    //     model.addAttribute("totCnt",totCnt);
    //     model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)searchVO.getPageUnit()));
    //     model.addAttribute("pagination",pagination);
    //     //페이징[e]
        
    //     // searchVO.setQustr();
        
    //     return "/board/list";
    // }

    
    
}
