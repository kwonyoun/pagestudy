package com.example.pagestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String test(){
        System.out.println("test");
        return "test";
    }

    @GetMapping("/this")
    public String test2(){
        System.out.println("this");
        return "this";
    }
    
}
