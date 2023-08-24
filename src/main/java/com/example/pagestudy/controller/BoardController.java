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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pagestudy.service.BoardService;
import com.example.pagestudy.vo.BoardVO;
import com.example.pagestudy.vo.PageVO;
import com.example.pagestudy.vo.Pagination;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/board/list", method = RequestMethod.GET)
    public String list(Model model){
        
        System.out.println("gg");

        PageVO pageVO = new PageVO();
        //페이징[s]
        Pagination pagination = new Pagination();
        pagination.setCurrentPageNo(pageVO.getPageIndex());
        pagination.setRecordCountPerPage(pageVO.getPageUnit());
        pagination.setPageSize(pageVO.getPageSize());
        
        pageVO.setFirstIndex(pagination.getFirstRecordIndex());
        pageVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        
        List<BoardVO> boardList = boardService.getList(pageVO);
        int totCnt = boardService.getListCnt(pageVO);

        // System.out.println(boardList);
        // System.out.println(totCnt);
        
        pagination.setTotalRecordCount(totCnt);
        
        pageVO.setEndDate(pagination.getLastPageNoOnPageList());
        pageVO.setStartDate(pagination.getFirstPageNoOnPageList());
        pageVO.setPrev(pagination.getXprev());
        pageVO.setNext(pagination.getXnext());
        
        model.addAttribute("pageVO",pageVO);
        model.addAttribute("boardList",boardList);  
        model.addAttribute("totCnt",totCnt);
        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)pageVO.getPageUnit()));
        model.addAttribute("pagination",pagination);
        //페이징[e]
        
        // pageVO.setQustr();
        
        return "list";
    }

    @RequestMapping(value = "/board/list/page", method = RequestMethod.GET)
    public String listpage(Model model, @RequestParam("pageIndex") int page) throws UnsupportedEncodingException {
                
        // Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        // if(null != inputFlashMap) {
            
        //     model.addAttribute("msg",(String) inputFlashMap.get("msg"));
            
        // }
        
        PageVO pageVO = new PageVO();
        //페이징[s]
        Pagination pagination = new Pagination();
        pagination.setCurrentPageNo(page);
        pagination.setRecordCountPerPage(pageVO.getPageUnit());
        pagination.setPageSize(pageVO.getPageSize());
        
        pageVO.setFirstIndex(pagination.getFirstRecordIndex());
        pageVO.setRecordCountPerPage(pagination.getRecordCountPerPage());
        
        List<BoardVO> boardList = boardService.getList(pageVO);
        int totCnt = boardService.getListCnt(pageVO);
        
        pagination.setTotalRecordCount(totCnt);
        
        pageVO.setEndDate(pagination.getLastPageNoOnPageList());
        pageVO.setStartDate(pagination.getFirstPageNoOnPageList());
        pageVO.setPrev(pagination.getXprev());
        pageVO.setNext(pagination.getXnext());
        
        model.addAttribute("pageVO",pageVO);
        model.addAttribute("boardList",boardList);  
        model.addAttribute("totCnt",totCnt);
        model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)pageVO.getPageUnit()));
        model.addAttribute("pagination",pagination);
        //페이징[e]
        
        // pageVO.setQustr();
        
        return "list";
    }

    

    
    
}
